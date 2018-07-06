// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import com.intellij.hibernate.model.converters.GeneratorClassResolvingConverter;
import com.intellij.hibernate.model.converters.ParamValueConverter;
import com.intellij.javaee.model.xml.CommonDomModelElement;
import com.intellij.psi.PsiClass;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.persistence.model.TableInfoProvider;
import javax.annotation.Nonnull;

import java.util.List;

/**
 * hibernate-mapping-3.0.dtd:generator interface.
 * Type generator documentation
 * <pre>
 *  Generators generate unique identifiers. The class attribute specifies a Java 
 * class implementing an id generation algorithm. 
 * </pre>
 */
public interface HbmGenerator extends CommonDomModelElement, TableInfoProvider {

	/**
	 * Returns the value of the class child.
	 * Attribute class
	 * @return the value of the class child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("class")
	@Required
        @Convert(GeneratorClassResolvingConverter.class)
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
