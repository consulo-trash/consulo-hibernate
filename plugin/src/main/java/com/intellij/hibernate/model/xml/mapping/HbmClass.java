// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.hibernate.model.converters.LazyTypeConverter;
import com.intellij.hibernate.model.converters.MappingClassResolveConverter;
import com.intellij.hibernate.model.enums.LazyType;
import com.intellij.hibernate.model.enums.OptimisticLockType;
import com.intellij.hibernate.model.enums.PolymorphismType;
import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.psi.PsiClass;
import com.intellij.util.xml.Attribute;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.SubTagList;

/**
 * hibernate-mapping-3.0.dtd:class interface.
 * Type class documentation
 * <pre>
 * 	Root entity mapping.  Poorly named as entities do not have to be represented by 
 * 	classes at all.  Mapped entities may be represented via different methodologies 
 * 	(POJO, Map, Dom4j).
 * </pre>
 */
public interface HbmClass extends CommonDomModelElement, HbmClassBase {

	/**
	 * Returns the value of the select-before-update child.
	 * Attribute select-before-update
	 * @return the value of the select-before-update child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getSelectBeforeUpdate();


	/**
	 * Returns the value of the persister child.
	 * Attribute persister
	 * @return the value of the persister child.
	 */
	@Nonnull
        @Convert(MappingClassResolveConverter.class)
        GenericAttributeValue<PsiClass> getPersister();


	/**
	 * Returns the value of the polymorphism child.
	 * Attribute polymorphism
	 * @return the value of the polymorphism child.
	 */
	@Nonnull
	GenericAttributeValue<PolymorphismType> getPolymorphism();


	/**
	 * Returns the value of the discriminator-value child.
	 * Attribute discriminator-value
	 * @return the value of the discriminator-value child.
	 */
	@Nonnull
	GenericAttributeValue<String> getDiscriminatorValue();


	/**
	 * Returns the value of the dynamic-update child.
	 * Attribute dynamic-update
	 * @return the value of the dynamic-update child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getDynamicUpdate();


	/**
	 * Returns the value of the catalog child.
	 * Attribute catalog
	 * @return the value of the catalog child.
	 */
	@Nonnull
	GenericAttributeValue<String> getCatalog();


	/**
	 * Returns the value of the rowid child.
	 * Attribute rowid
	 * @return the value of the rowid child.
	 */
	@Nonnull
	GenericAttributeValue<String> getRowid();


	/**
	 * Returns the value of the entity-name child.
	 * Attribute entity-name
	 * @return the value of the entity-name child.
	 */
	@Nonnull
	GenericAttributeValue<String> getEntityName();


	/**
	 * Returns the value of the optimistic-lock child.
	 * Attribute optimistic-lock
	 * @return the value of the optimistic-lock child.
	 */
	@Nonnull
	GenericAttributeValue<OptimisticLockType> getOptimisticLock();


	/**
	 * Returns the value of the where child.
	 * Attribute where
	 * @return the value of the where child.
	 */
	@Nonnull
	GenericAttributeValue<String> getWhere();


	/**
	 * Returns the value of the subselect child.
	 * Attribute subselect
	 * @return the value of the subselect child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("subselect")
	GenericAttributeValue<String> getSubselectAttr();


	/**
	 * Returns the value of the schema child.
	 * Attribute schema
	 * @return the value of the schema child.
	 */
	@Nonnull
	GenericAttributeValue<String> getSchema();


	/**
	 * Returns the value of the node child.
	 * Attribute node
	 * @return the value of the node child.
	 */
	@Nonnull
	GenericAttributeValue<String> getNode();


	/**
	 * Returns the value of the mutable child.
	 * Attribute mutable
	 * @return the value of the mutable child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getMutable();


	/**
	 * Returns the value of the abstract child.
	 * Attribute abstract
	 * @return the value of the abstract child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getAbstract();


	/**
	 * Returns the value of the lazy child.
	 * Attribute lazy
	 * @return the value of the lazy child.
	 */
	@Nonnull
        @Convert(LazyTypeConverter.class)
        GenericAttributeValue<LazyType> getLazy();


	/**
	 * Returns the value of the proxy child.
	 * Attribute proxy
	 * @return the value of the proxy child.
	 */
	@Nonnull
        @Convert(MappingClassResolveConverter.class)
        GenericAttributeValue<PsiClass> getProxy();


	/**
	 * Returns the value of the table child.
	 * Attribute table
	 * @return the value of the table child.
	 */
	@Nonnull
        @Attribute("table")
        GenericAttributeValue<String> getTableName();


	/**
	 * Returns the value of the check child.
	 * Attribute check
	 * @return the value of the check child.
	 */
	@Nonnull
	GenericAttributeValue<String> getCheck();


	/**
	 * Returns the value of the batch-size child.
	 * Attribute batch-size
	 * @return the value of the batch-size child.
	 */
	@Nonnull
	GenericAttributeValue<Integer> getBatchSize();


	/**
	 * Returns the value of the dynamic-insert child.
	 * Attribute dynamic-insert
	 * @return the value of the dynamic-insert child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getDynamicInsert();


	/**
	 * Returns the value of the name child.
	 * Attribute name
	 * @return the value of the name child.
	 */
	@Nonnull
        @com.intellij.util.xml.Attribute("name")
        GenericAttributeValue<PsiClass> getClazz();


	/**
	 * Returns the list of meta children.
	 * Type meta documentation
	 * <pre>
	 * 	META element definition; used to assign meta-level attributes to a class
	 * 	or property.  Is currently used by codegenerator as a placeholder for
	 * 	values that is not directly related to OR mappings.
	 * </pre>
	 * @return the list of meta children.
	 */
	@Nonnull
	List<HbmMeta> getMetas();
	/**
	 * Adds new child to the list of meta children.
	 * @return created child
	 */
	HbmMeta addMeta();


	/**
	 * Returns the value of the subselect child.
	 * @return the value of the subselect child.
	 */
	@Nonnull
	GenericDomValue<String> getSubselect();


	/**
	 * Returns the value of the cache child.
	 * Type cache documentation
	 * <pre>
	 *  The cache element enables caching of an entity class. 
	 * </pre>
	 * @return the value of the cache child.
	 */
	@Nonnull
	HbmCache getCache();


	/**
	 * Returns the list of synchronize children.
	 * @return the list of synchronize children.
	 */
	@Nonnull
	List<HbmSynchronize> getSynchronizes();
	/**
	 * Adds new child to the list of synchronize children.
	 * @return created child
	 */
	HbmSynchronize addSynchronize();


	/**
	 * Returns the value of the comment child.
	 * Type comment documentation
	 * <pre>
	 *  The comment element allows definition of a database table or column comment. 
	 * </pre>
	 * @return the value of the comment child.
	 */
	@Nonnull
	GenericDomValue<String> getComment();


	/**
	 * Returns the list of tuplizer children.
	 * Type tuplizer documentation
	 * <pre>
	 *     TUPLIZER element; defines tuplizer to use for a component/entity for a given entity-mode
	 * </pre>
	 * @return the list of tuplizer children.
	 */
	@Nonnull
	List<HbmTuplizer> getTuplizers();
	/**
	 * Adds new child to the list of tuplizer children.
	 * @return created child
	 */
	HbmTuplizer addTuplizer();


	/**
	 * Returns the value of the discriminator child.
	 * Type discriminator documentation
	 * <pre>
	 *  Polymorphic data requires a column holding a class discriminator value. This
	 * value is not directly exposed to the application. 
	 * </pre>
	 * @return the value of the discriminator child.
	 */
	@Nonnull
	HbmDiscriminator getDiscriminator();


	/**
	 * Returns the value of the natural-id child.
	 * Type natural-id documentation
	 * <pre>
	 *  A natural-id element allows declaration of the unique business key 
	 * </pre>
	 * @return the value of the natural-id child.
	 */
	@Nonnull
	HbmNaturalId getNaturalId();


	/**
	 * Returns the value of the loader child.
	 * Type loader documentation
	 * <pre>
	 *  The loader element allows specification of a named query to be used for fetching
	 * an entity or collection 
	 * </pre>
	 * @return the value of the loader child.
	 */
	@Nonnull
	HbmLoader getLoader();


	/**
	 * Returns the value of the sql-insert child.
	 * Type sql-insert documentation
	 * <pre>
	 *  custom sql operations 
	 * </pre>
	 * @return the value of the sql-insert child.
	 */
	@Nonnull
	HbmSqlStatement getSqlInsert();


	/**
	 * Returns the value of the sql-update child.
	 * @return the value of the sql-update child.
	 */
	@Nonnull
	HbmSqlStatement getSqlUpdate();


	/**
	 * Returns the value of the sql-delete child.
	 * @return the value of the sql-delete child.
	 */
	@Nonnull
	HbmSqlStatement getSqlDelete();


	/**
	 * Returns the list of filter children.
	 * Type filter documentation
	 * <pre>
	 * 	FILTER element; used to apply a filter.
	 * </pre>
	 * @return the list of filter children.
	 */
	@Nonnull
	List<HbmFilter> getFilters();
	/**
	 * Adds new child to the list of filter children.
	 * @return created child
	 */
	HbmFilter addFilter();


	/**
	 * Returns the list of resultset children.
	 * Type resultset documentation
	 * <pre>
	 *  The resultset element declares a named resultset mapping definition for SQL queries 
	 * </pre>
	 * @return the list of resultset children.
	 */
	@Nonnull
	List<HbmResultset> getResultsets();
	/**
	 * Adds new child to the list of resultset children.
	 * @return created child
	 */
	HbmResultset addResultset();


	/**
	 * Returns the value of the id child.
	 * Type id documentation
	 * <pre>
	 *  Declares the id type, column and generation algorithm for an entity class.
	 * If a name attribut is given, the id is exposed to the application through the 
	 * named property of the class. If not, the id is only exposed to the application 
	 * via Session.getIdentifier() 
	 * </pre>
	 * @return the value of the id child.
	 */
	@Nonnull
	HbmId getId();


	/**
	 * Returns the value of the composite-id child.
	 * Type composite-id documentation
	 * <pre>
	 *  A composite key may be modelled by a java class with a property for each 
	 * key column. The class must implement java.io.Serializable and reimplement equals() 
	 * and hashCode(). 
	 * </pre>
	 * @return the value of the composite-id child.
	 */
	@Nonnull
	HbmCompositeId getCompositeId();


	/**
	 * Returns the value of the version child.
	 * Type version documentation
	 * <pre>
	 *  Versioned data requires a column holding a version number. This is exposed to the
	 * application through a property of the Java class. 
	 * </pre>
	 * @return the value of the version child.
	 */
	@Nonnull
	HbmVersion getVersion();


	/**
	 * Returns the value of the timestamp child.
	 * @return the value of the timestamp child.
	 */
	@Nonnull
	HbmTimestamp getTimestamp();


	/**
	 * Returns the list of property children.
	 * Type property documentation
	 * <pre>
	 *  Property of an entity class or component, component-element, composite-id, etc. 
	 * JavaBeans style properties are mapped to table columns. 
	 * </pre>
	 * @return the list of property children.
	 */
	@Nonnull
	List<HbmProperty> getProperties();
	/**
	 * Adds new child to the list of property children.
	 * @return created child
	 */
	HbmProperty addProperty();


	/**
	 * Returns the list of many-to-one children.
	 * Type many-to-one documentation
	 * <pre>
	 *  Declares an association between two entities (Or from a component, component element,
	 * etc. to an entity). 
	 * </pre>
	 * @return the list of many-to-one children.
	 */
	@Nonnull
	List<HbmManyToOne> getManyToOnes();
	/**
	 * Adds new child to the list of many-to-one children.
	 * @return created child
	 */
	HbmManyToOne addManyToOne();


	/**
	 * Returns the list of one-to-one children.
	 * Type one-to-one documentation
	 * <pre>
	 *  Declares a one-to-one association between two entities (Or from a component, 
	 * component element, etc. to an entity). 
	 * </pre>
	 * @return the list of one-to-one children.
	 */
	@Nonnull
	List<HbmOneToOne> getOneToOnes();
	/**
	 * Adds new child to the list of one-to-one children.
	 * @return created child
	 */
	HbmOneToOne addOneToOne();


	/**
	 * Returns the list of component children.
	 * Type component documentation
	 * <pre>
	 *  A component is a user-defined class, persisted along with its containing entity
	 * to the table of the entity class. JavaBeans style properties of the component are
	 * mapped to columns of the table of the containing entity. A null component reference
	 * is mapped to null values in all columns and vice versa. Components do not support
	 * shared reference semantics. 
	 * </pre>
	 * @return the list of component children.
	 */
	@Nonnull
	List<HbmComponent> getComponents();
	/**
	 * Adds new child to the list of component children.
	 * @return created child
	 */
	HbmComponent addComponent();


	/**
	 * Returns the list of dynamic-component children.
	 * Type dynamic-component documentation
	 * <pre>
	 *  A dynamic-component maps columns of the database entity to a java.util.Map 
	 * at the Java level 
	 * </pre>
	 * @return the list of dynamic-component children.
	 */
	@Nonnull
	List<HbmDynamicComponent> getDynamicComponents();
	/**
	 * Adds new child to the list of dynamic-component children.
	 * @return created child
	 */
	HbmDynamicComponent addDynamicComponent();


	/**
	 * Returns the list of properties children.
	 * Type properties documentation
	 * <pre>
	 *  properties declares that the contained properties form an alternate key. The name
	 * attribute allows an alternate key to be used as the target of a property-ref. 
	 * </pre>
	 * @return the list of properties children.
	 */
	@Nonnull
        @SubTagList("properties")
        List<HbmProperties> getPropertieses();
	/**
	 * Adds new child to the list of properties children.
	 * @return created child
	 */
	HbmProperties addProperties();


	/**
	 * Returns the list of any children.
	 * Type any documentation
	 * <pre>
	 *  An "any" association is a polymorphic association to any table with
	 * the given identifier type. The first listed column is a VARCHAR column 
	 * holding the name of the class (for that row). 
	 * </pre>
	 * @return the list of any children.
	 */
	@Nonnull
	List<HbmAny> getAnies();
	/**
	 * Adds new child to the list of any children.
	 * @return created child
	 */
	HbmAny addAny();


	/**
	 * Returns the list of map children.
	 * Type map documentation
	 * <pre>
	 *  Collection declarations nested inside a class declaration indicate a foreign key 
	 * relationship from the collection table to the enclosing class. 
	 * </pre>
	 * @return the list of map children.
	 */
	@Nonnull
	List<HbmMap> getMaps();
	/**
	 * Adds new child to the list of map children.
	 * @return created child
	 */
	HbmMap addMap();


	/**
	 * Returns the list of set children.
	 * @return the list of set children.
	 */
	@Nonnull
	List<HbmSet> getSets();
	/**
	 * Adds new child to the list of set children.
	 * @return created child
	 */
	HbmSet addSet();


	/**
	 * Returns the list of list children.
	 * @return the list of list children.
	 */
	@Nonnull
	List<HbmList> getLists();
	/**
	 * Adds new child to the list of list children.
	 * @return created child
	 */
	HbmList addList();


	/**
	 * Returns the list of bag children.
	 * @return the list of bag children.
	 */
	@Nonnull
	List<HbmBag> getBags();
	/**
	 * Adds new child to the list of bag children.
	 * @return created child
	 */
	HbmBag addBag();


	/**
	 * Returns the list of idbag children.
	 * @return the list of idbag children.
	 */
	@Nonnull
	List<HbmIdbag> getIdbags();
	/**
	 * Adds new child to the list of idbag children.
	 * @return created child
	 */
	HbmIdbag addIdbag();


	/**
	 * Returns the list of array children.
	 * @return the list of array children.
	 */
	@Nonnull
	List<HbmArray> getArrays();
	/**
	 * Adds new child to the list of array children.
	 * @return created child
	 */
	HbmArray addArray();


	/**
	 * Returns the list of primitive-array children.
	 * @return the list of primitive-array children.
	 */
	@Nonnull
	List<HbmPrimitiveArray> getPrimitiveArrays();
	/**
	 * Adds new child to the list of primitive-array children.
	 * @return created child
	 */
	HbmPrimitiveArray addPrimitiveArray();


	/**
	 * Returns the list of joined-subclass children.
	 * Type joined-subclass documentation
	 * <pre>
	 * 	Joined subclasses are used for the normalized table-per-subclass mapping strategy
	 * 	See the note on the class element regarding <pojo/> vs. @name usage...
	 * </pre>
	 * @return the list of joined-subclass children.
	 */
	@Nonnull
	List<HbmJoinedSubclass> getJoinedSubclasses();
	/**
	 * Adds new child to the list of joined-subclass children.
	 * @return created child
	 */
	HbmJoinedSubclass addJoinedSubclass();


	/**
	 * Returns the list of union-subclass children.
	 * Type union-subclass documentation
	 * <pre>
	 * 	Union subclasses are used for the table-per-concrete-class mapping strategy
	 * 	See the note on the class element regarding <pojo/> vs. @name usage...
	 * </pre>
	 * @return the list of union-subclass children.
	 */
	@Nonnull
	List<HbmUnionSubclass> getUnionSubclasses();
	/**
	 * Adds new child to the list of union-subclass children.
	 * @return created child
	 */
	HbmUnionSubclass addUnionSubclass();


	/**
	 * Returns the list of query children.
	 * Type query documentation
	 * <pre>
	 *  The query element declares a named Hibernate query string 
	 * </pre>
	 * @return the list of query children.
	 */
	@Nonnull
	List<HbmQuery> getQueries();
	/**
	 * Adds new child to the list of query children.
	 * @return created child
	 */
	HbmQuery addQuery();


	/**
	 * Returns the list of sql-query children.
	 * Type sql-query documentation
	 * <pre>
	 *  The sql-query element declares a named SQL query string 
	 * </pre>
	 * @return the list of sql-query children.
	 */
	@Nonnull
	List<HbmSqlQuery> getSqlQueries();
	/**
	 * Adds new child to the list of sql-query children.
	 * @return created child
	 */
	HbmSqlQuery addSqlQuery();


	/**
	 * Returns the list of join children.
	 * Type join documentation
	 * <pre>
	 *  A join allows some properties of a class to be persisted to a second table 
	 * </pre>
	 * @return the list of join children.
	 */
	@Nonnull
	List<HbmJoin> getJoins();
	/**
	 * Adds new child to the list of join children.
	 * @return created child
	 */
	HbmJoin addJoin();


	/**
	 * Returns the list of subclass children.
	 * Type subclass documentation
	 * <pre>
	 * 	Subclass declarations are nested beneath the root class declaration to achieve
	 * 	polymorphic persistence with the table-per-hierarchy mapping strategy.
	 * 	See the note on the class element regarding <pojo/> vs. @name usage...
	 * </pre>
	 * @return the list of subclass children.
	 */
	@Nonnull
	List<HbmSubclass> getSubclasses();
	/**
	 * Adds new child to the list of subclass children.
	 * @return created child
	 */
	HbmSubclass addSubclass();


}
