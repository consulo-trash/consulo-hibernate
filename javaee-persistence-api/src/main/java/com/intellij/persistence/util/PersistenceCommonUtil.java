/*
 * Copyright 2000-2007 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.persistence.util;

import gnu.trove.THashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;

import javax.annotation.Nullable;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.jam.model.util.JamCommonUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.persistence.PersistenceHelper;
import com.intellij.persistence.facet.PersistenceFacetBase;
import com.intellij.persistence.facet.PersistenceFacetConfiguration;
import com.intellij.persistence.model.PersistenceMappings;
import com.intellij.persistence.model.PersistencePackage;
import com.intellij.persistence.model.PersistenceQuery;
import com.intellij.persistence.model.PersistentEmbeddedAttribute;
import com.intellij.persistence.model.PersistentObject;
import com.intellij.persistence.model.PersistentRelationshipAttribute;
import com.intellij.persistence.model.TableInfoProvider;
import com.intellij.persistence.roles.PersistenceClassRole;
import com.intellij.persistence.roles.PersistenceClassRoleEnum;
import com.intellij.persistence.roles.PersistenceRoleHolder;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiArrayType;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMember;
import com.intellij.psi.PsiType;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.PropertyUtil;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.psi.util.TypeConversionUtil;
import com.intellij.util.ExecutorsQuery;
import com.intellij.util.Function;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import com.intellij.util.QueryExecutor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericValue;

/**
 * @author Gregory.Shrago
 */
public class PersistenceCommonUtil {
  @NonNls public static final String PERSISTENCE_FRAMEWORK_GROUP_ID = "persistence";

  private PersistenceCommonUtil() { }

  @Nonnull
  public static List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> getAllPersistenceFacets(@Nonnull final Project project) {
    final List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> result = new ArrayList<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>();
    for (Module module : ModuleManager.getInstance(project).getModules()) {
      result.addAll(getAllPersistenceFacets(module));
    }
    return result;
  }

  @Nonnull
  public static List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> getAllPersistenceFacets(@Nonnull final Module module) {
    final List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> result = new ArrayList<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>();
    for (Facet facet : FacetManager.getInstance(module).getAllFacets()) {
      if (facet instanceof PersistenceFacetBase) {
        result.add((PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>)facet);
      }
    }
    return result;
  }

  private static Key<CachedValue<List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>>> MODULE_PERSISTENCE_FACETS = Key.create("MODULE_PERSISTENCE_FACETS");
  @Nonnull
  public static List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> getAllPersistenceFacetsWithDependencies(@Nonnull final Module module) {
    CachedValue<List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>> cachedValue =
      module.getUserData(MODULE_PERSISTENCE_FACETS);
    if (cachedValue == null) {
      cachedValue = CachedValuesManager.getManager(module.getProject()).createCachedValue(new CachedValueProvider<List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>>() {
        public Result<List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>> compute() {
          final Set<Module> modules = new THashSet<Module>();
          modules.addAll(Arrays.asList(JamCommonUtil.getAllDependentModules(module)));
          modules.addAll(Arrays.asList(JamCommonUtil.getAllModuleDependencies(module)));
          final Set<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>> facets = new THashSet<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>();
          for (Module depModule : modules) {
            facets.addAll(getAllPersistenceFacets(depModule));
          }
          return new Result<List<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>>(new ArrayList<PersistenceFacetBase<PersistenceFacetConfiguration, PersistencePackage>>(facets),
                                                                                                           ProjectRootManager.getInstance(module.getProject()));
        }
      }, false);
      module.putUserData(MODULE_PERSISTENCE_FACETS, cachedValue);
    }
    return cachedValue.getValue();
  }

  public static PersistenceModelBrowser createSameUnitsModelBrowser(@Nullable final PsiElement sourceElement) {
    final PsiClass sourceClass;
    final Set<PersistencePackage> unitSet;
    if (sourceElement == null || (sourceClass = PsiTreeUtil.getParentOfType(sourceElement, PsiClass.class, false)) == null) {
      unitSet = null;
    }
    else {
      unitSet = getAllPersistenceUnits(sourceClass, new THashSet<PersistencePackage>());
    }
    return createUnitsAndTypeMapper(unitSet);
  }

  public static PersistenceModelBrowser createSameUnitsModelBrowser(@Nullable final DomElement sourceDom) {
    final Set<PersistencePackage> unitSet;
    final DomElement rootElement;
    if (sourceDom == null || !((rootElement = sourceDom.getRoot().getRootElement()) instanceof PersistenceMappings)) {
      unitSet = null;
    }
    else {
      unitSet = new THashSet<PersistencePackage>(PersistenceHelper.getHelper().getSharedModelBrowser().getPersistenceUnits((PersistenceMappings)rootElement));
    }
    return createUnitsAndTypeMapper(unitSet);
  }

  public static PersistenceModelBrowser createUnitsAndTypeMapper(@Nullable final Set<PersistencePackage> unitSet) {
    return PersistenceHelper.getHelper().createModelBrowser().setRoleFilter(new Condition<PersistenceClassRole>() {
      public boolean value(final PersistenceClassRole role) {
        final PersistentObject object = role.getPersistentObject();
        final PersistenceClassRoleEnum roleType = role.getType();
        return roleType != PersistenceClassRoleEnum.ENTITY_LISTENER && object != null && (unitSet == null || unitSet.contains(role.getPersistenceUnit()));
      }
    });
  }

  public static PersistenceModelBrowser createFacetAndUnitModelBrowser(final PersistenceFacetBase facet,
                                                                 final PersistencePackage unit,
                                                                 final PersistenceClassRoleEnum type) {
    return PersistenceHelper.getHelper().createModelBrowser().setRoleFilter(new Condition<PersistenceClassRole>() {
      public boolean value(final PersistenceClassRole role) {
        final PersistentObject object = role.getPersistentObject();
        return object != null && (type == null || role.getType() == type) && (unit == null || unit.equals(role.getPersistenceUnit())) &&
               (facet == null || facet.equals(role.getFacet()));
      }
    });
  }

  @Nullable
  public static PsiType getTargetEntityType(final PsiMember psiMember) {
    return getTargetEntityType(PropertyUtil.getPropertyType(psiMember));
  }

  @Nullable
  public static PsiType getTargetEntityType(final PsiType type) {
    final Pair<JavaContainerType, PsiType> containerType = getContainerType(type);
    return containerType.getSecond();
  }

  public static <T extends Collection<PersistencePackage>> T getAllPersistenceUnits(@Nullable final PsiClass sourceClass, @Nonnull final T result) {
    for (PersistenceClassRole role : getPersistenceRoles(sourceClass)) {
      ContainerUtil.addIfNotNull(role.getPersistenceUnit(), result);
    }
    return result;
  }


  @Nonnull
  public static PersistenceClassRole[] getPersistenceRoles(@Nullable final PsiClass aClass) {
    if (aClass == null || !aClass.isValid()) return PersistenceClassRole.EMPTY_ARRAY;
    return PersistenceRoleHolder.getInstance(aClass.getProject()).getRoles(aClass);
  }

  @Nonnull
  public static <T extends PersistencePackage, V extends PersistenceMappings> Collection<V> getDomEntityMappings(final Class<V> mappingsClass,
                                                                                                                 final T unit, final PersistenceFacetBase<?, T> facet) {
    final THashSet<V> result = new THashSet<V>();
    for (PersistenceMappings mappings : facet.getDefaultEntityMappings(unit)) {
      if (ReflectionCache.isAssignable(mappingsClass, mappings.getClass())) {
        result.add((V)mappings);
      }
    }
    for (GenericValue<V> value : unit.getModelHelper().getMappingFiles(mappingsClass)) {
      ContainerUtil.addIfNotNull(value.getValue(), result);
    }
    return result;
  }

  public static boolean isSameTable(final TableInfoProvider table1, final TableInfoProvider table2) {
    if (table1 == null || table2 == null) return false;
    final String name1 = table1.getTableName().getValue();
    return StringUtil.isNotEmpty(name1) &&
           Comparing.equal(name1, table2.getTableName().getValue()) &&
           Comparing.equal(table1.getSchema().getValue(), table2.getSchema().getValue()) &&
           Comparing.equal(table1.getCatalog().getValue(), table2.getCatalog().getValue());
  }

  public static String getUniqueId(final PsiElement psiElement) {
    final VirtualFile virtualFile = psiElement == null ? null : PsiUtilBase.getVirtualFile(psiElement);
    return virtualFile == null ? "" : virtualFile.getUrl();
  }

  public static String getMultiplicityString(final boolean optional, final boolean many) {
    final String first = (optional ? "0" : "1");
    final String last = (many ? "*" : "1");
    return first.equals(last) ? first : first + ".." + last;
  }

  public static <T, V extends Collection<T>> V mapPersistenceRoles(final V result, final Project project, final PersistenceFacetBase facet, final PersistencePackage unit, final Function<PersistenceClassRole, T> mapper) {
    final Collection<PersistenceClassRole> allRoles = PersistenceRoleHolder.getInstance(project).getClassRoleManager()
      .getUserData(PersistenceRoleHolder.PERSISTENCE_CLASS_ROLES_KEY, PersistenceRoleHolder.PERSISTENCE_ALL_ROLES_DATA_KEY);
    if (allRoles != null) {
      for (PersistenceClassRole role : allRoles) {
        if ((facet == null || facet == role.getFacet()) && (unit == null || unit == role.getPersistenceUnit())) {
          ContainerUtil.addIfNotNull(mapper.fun(role), result);
        }
      }
    }
    return result;
  }

  public static boolean haveCorrespondingMultiplicity(final PersistentRelationshipAttribute a1, final PersistentRelationshipAttribute a2) {
    return a1.getAttributeModelHelper().getRelationshipType().corresponds(a2.getAttributeModelHelper().getRelationshipType());
  }

  public static <T extends PersistencePackage> boolean processNamedQueries(final PersistenceFacetBase<?, T> facet,
                                                                           final boolean nativeQueries, final Processor<PersistenceQuery> processor) {
    return processNamedQueries(nativeQueries? PersistenceRoleHolder.PERSISTENCE_ALL_NATIVE_QUERIES_DATA_KEY : PersistenceRoleHolder.PERSISTENCE_ALL_QUERIES_DATA_KEY, facet, processor);
  }

  private static <T extends PersistencePackage> boolean processNamedQueries(final Key<Map<PersistenceFacetBase, Collection<PersistenceQuery>>> queriesDataKey,
                                                                            final PersistenceFacetBase<?, T> facet,
                                                                            final Processor<PersistenceQuery> processor) {
    final Map<PersistenceFacetBase, Collection<PersistenceQuery>> namedQueriesMap = PersistenceRoleHolder.getInstance(facet.getModule().getProject())
      .getClassRoleManager()
      .getUserData(PersistenceRoleHolder.PERSISTENCE_CLASS_ROLES_KEY, queriesDataKey);
    if (namedQueriesMap != null) {
      final Collection<PersistenceQuery> queries = namedQueriesMap.get(facet);
      if (queries != null && !ContainerUtil.process(queries, processor)) {
        return false;
      }
    }
    return true;
  }

  @Nonnull
  public static Pair<JavaContainerType, PsiType> getContainerType(final PsiType type) {
    if (type instanceof PsiArrayType) {
      return Pair.create(JavaContainerType.ARRAY, ((PsiArrayType)type).getComponentType());
    }
    final PsiClassType.ClassResolveResult classResolveResult = type instanceof PsiClassType? ((PsiClassType)type).resolveGenerics() : null;
    if (classResolveResult == null) return Pair.create(null, type);
    final PsiClass psiClass = classResolveResult.getElement();
    if (psiClass == null) return Pair.create(null, type);
    final PsiManager manager = psiClass.getManager();
    final GlobalSearchScope scope = ProjectScope.getAllScope(manager.getProject());
    for (JavaContainerType collectionType : JavaContainerType.values()) {
      if (collectionType == JavaContainerType.ARRAY) continue;
      final PsiClass aClass = JavaPsiFacade.getInstance(manager.getProject()).findClass(collectionType.getJavaBaseClassName(), scope);
      if (aClass != null && (manager.areElementsEquivalent(aClass, psiClass) || psiClass.isInheritor(aClass, true))) {
        final PsiTypeParameter[] typeParameters = aClass.getTypeParameters();
        final PsiType entityType;
        if (typeParameters.length > 0) {
          entityType = TypeConversionUtil.getSuperClassSubstitutor(aClass, psiClass, classResolveResult.getSubstitutor()).substitute(typeParameters[typeParameters.length - 1]);
        }
        else {
          entityType = PsiType.getJavaLangObject(manager, scope);
        }
        return Pair.create(collectionType, entityType);
      }
    }
    return Pair.create(null, type);
  }

  public static Query<PersistentObject> queryPersistentObjects(final PersistenceMappings mappings) {
    return new ExecutorsQuery<PersistentObject, PersistenceMappings>(mappings, Collections.<QueryExecutor<PersistentObject, PersistenceMappings>>singletonList(
      new QueryExecutor<PersistentObject, PersistenceMappings>() {

      public boolean execute(PersistenceMappings queryParameters, Processor<PersistentObject> consumer) {
        if (!ContainerUtil.process(queryParameters.getModelHelper().getPersistentEntities(), consumer)) return false;
        if (!ContainerUtil.process(queryParameters.getModelHelper().getPersistentSuperclasses(), consumer)) return false;
        if (!ContainerUtil.process(queryParameters.getModelHelper().getPersistentEmbeddables(), consumer)) return false;
        return true;
      }
    }));
  }

  @Nullable
  public static PsiClass getTargetClass(final PersistentRelationshipAttribute attribute) {
    final GenericValue<PsiClass> classValue = attribute.getTargetEntityClass();
    final PsiClass targetClass;
    if (classValue.getStringValue() != null) {
      targetClass = classValue.getValue();
    }
    else {
      final PsiType entityType = getTargetEntityType(attribute.getPsiMember());
      targetClass = entityType instanceof PsiClassType ? ((PsiClassType)entityType).resolve() : null;
    }
    return targetClass;
  }

  @Nullable
  public static PsiClass getTargetClass(final PersistentEmbeddedAttribute attribute) {
    final GenericValue<PsiClass> classValue = attribute.getTargetEmbeddableClass();
    final PsiClass targetClass;
    if (classValue.getStringValue() != null) {
      targetClass = classValue.getValue();
    }
    else {
      final PsiType entityType = PropertyUtil.getPropertyType(attribute.getPsiMember());
      targetClass = entityType instanceof PsiClassType ? ((PsiClassType)entityType).resolve() : null;
    }
    return targetClass;
  }
}
