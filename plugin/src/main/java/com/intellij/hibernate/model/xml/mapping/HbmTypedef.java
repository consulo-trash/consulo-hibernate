// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.hibernate.model.converters.MappingClassResolveConverter;
import com.intellij.hibernate.model.converters.ParamValueConverter;
import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.psi.PsiClass;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.NameValue;
import com.intellij.util.xml.Required;

/**
 * hibernate-mapping-3.0.dtd:typedef interface.
 * Type typedef documentation
 * <pre>
 * 	TYPEDEF element definition; defines a new name for a Hibernate type. May
 * 	contain parameters for parameterizable types.
 * </pre>
 */
public interface HbmTypedef extends CommonDomModelElement
{

	/**
	 * Returns the value of the name child.
	 * Attribute name
	 * @return the value of the name child.
	 */
	@Nonnull
        @NameValue
        @Required
	GenericAttributeValue<String> getName();


	/**
	 * Returns the value of the class child.
	 * Attribute class
	 * @return the value of the class child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("class")
	@Required
        @Convert(MappingClassResolveConverter.class)
        GenericAttributeValue<PsiClass> getClazz();


	/**
	 * Returns the list of param children.
	 * @return the list of param children.
	 */
	@Nonnull
        @Convert(ParamValueConverter.class)
        List<HbmParam<Object>> getParams();
	/**
	 * Adds new child to the list of param children.
	 * @return created child
	 */
	HbmParam<Object> addParam();


}
