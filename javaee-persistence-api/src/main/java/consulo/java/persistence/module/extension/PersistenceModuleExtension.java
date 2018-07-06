package consulo.java.persistence.module.extension;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.lang.Language;
import com.intellij.persistence.facet.PersistencePackageDefaults;
import com.intellij.persistence.model.PersistenceMappings;
import com.intellij.persistence.model.PersistencePackage;
import com.intellij.persistence.model.validators.ModelValidator;
import com.intellij.util.descriptors.ConfigFile;
import com.intellij.util.descriptors.ConfigFileContainer;
import com.intellij.util.descriptors.ConfigFileMetaData;
import consulo.module.extension.ModuleExtension;

/**
 * @author VISTALL
 * @since 2018-07-06
 */
public interface PersistenceModuleExtension<T extends PersistenceModuleExtension<T, Unit>, Unit extends PersistencePackage> extends ModuleExtension<T>
{
	public abstract ConfigFile[] getDescriptors();

	public abstract ConfigFileContainer getDescriptorsContainer();

	@Nonnull
	public abstract List<Unit> getPersistenceUnits();

	@Nullable
	public abstract PersistenceMappings getAnnotationEntityMappings();

	@Nonnull
	public abstract PersistenceMappings getEntityMappings(@Nonnull final Unit unit);

	@Nonnull
	public abstract List<? extends PersistenceMappings> getDefaultEntityMappings(@Nonnull final Unit unit);

	@Nonnull
	public abstract Class<? extends PersistencePackage> getPersistenceUnitClass();

	@Nonnull
	public abstract Map<ConfigFileMetaData, Class<? extends PersistenceMappings>> getSupportedDomMappingFormats();

	public abstract String getDataSourceId(@Nonnull final Unit unit);

	public abstract void setDataSourceId(@Nonnull final Unit unit, final String dataSourceId);

	@Nullable
	public abstract Language getQlLanguage();

	@Nonnull
	public abstract ModelValidator getModelValidator(@Nullable final Unit unit);

	@Nonnull
	public abstract Class[] getInspectionToolClasses();

	@Nonnull
	public abstract PersistencePackageDefaults getPersistenceUnitDefaults(@Nonnull final Unit unit);
}
