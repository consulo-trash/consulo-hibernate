// Generated on Fri Nov 17 19:09:29 MSK 2006
// DTD/Schema  :    hibernate-configuration-3.0.dtd

package com.intellij.hibernate.model.xml.config;

import javax.annotation.Nonnull;

import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.hibernate.model.enums.CacheUsageType;
import com.intellij.hibernate.model.enums.CacheIncludeType;
import com.intellij.psi.PsiClass;
import com.intellij.javaee.model.xml.CommonDomModelElement;

/**
 * hibernate-configuration-3.0.dtd:class-cache interface.
 */
public interface ClassCache extends CommonDomModelElement {

	/**
	 * Returns the value of the include child.
	 * Attribute include
	 * @return the value of the include child.
	 */
	@Nonnull
	GenericAttributeValue<CacheIncludeType> getInclude();


	/**
	 * Returns the value of the usage child.
	 * Attribute usage
	 * @return the value of the usage child.
	 */
	@Nonnull
	@Required
	GenericAttributeValue<CacheUsageType> getUsage();


	/**
	 * Returns the value of the class child.
	 * Attribute class
	 * @return the value of the class child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("class")
	@Required
	GenericAttributeValue<PsiClass> getClazz();


	/**
	 * Returns the value of the region child.
	 * Attribute region
	 * @return the value of the region child.
	 */
	@Nonnull
	GenericAttributeValue<String> getRegion();


}
