// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import javax.annotation.Nonnull;

import com.intellij.hibernate.model.converters.ParamNameConverter;
import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.NameValue;
import com.intellij.util.xml.Required;

/**
 * hibernate-mapping-3.0.dtd:param interface.
 */
public interface HbmParam<T> extends CommonDomModelElement, GenericDomValue<T> {

	/**
	 * Returns the value of the simple content.
	 * @return the value of the simple content.
	 */
	@Nonnull
	T getValue();
	/**
	 * Sets the value of the simple content.
	 * @param value the new value to set
	 */
	void setValue(T value);


	/**
	 * Returns the value of the name child.
	 * Attribute name
	 * @return the value of the name child.
	 */
        @NameValue
        @Nonnull
	@Required
        @Convert(ParamNameConverter.class)
        GenericAttributeValue<String> getName();


}
