// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-configuration-3.0.dtd

package com.intellij.hibernate.model.xml.config;

import javax.annotation.Nonnull;

import com.intellij.util.xml.*;
import com.intellij.hibernate.model.converters.ParamNameConverter;
import com.intellij.javaee.model.xml.CommonDomModelElement;

/**
 * hibernate-configuration-3.0.dtd:property interface.
 */
public interface Property<T> extends GenericDomValue<T>, CommonDomModelElement {

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
	@Nonnull
	@Required
        @NameValue
        @Convert(ParamNameConverter.class)
        GenericAttributeValue<String> getName();


}
