// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-configuration-3.0.dtd

package com.intellij.hibernate.model.xml.config;

import javax.annotation.Nonnull;

import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.hibernate.model.enums.ListenerType;
import com.intellij.psi.PsiClass;
import com.intellij.javaee.model.xml.CommonDomModelElement;

/**
 * hibernate-configuration-3.0.dtd:listener interface.
 */
public interface Listener extends CommonDomModelElement {

	/**
	 * Returns the value of the type child.
	 * Attribute type
	 * @return the value of the type child.
	 */
	@Nonnull
	GenericAttributeValue<ListenerType> getType();


	/**
	 * Returns the value of the class child.
	 * Attribute class
	 * @return the value of the class child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("class")
	@Required
	GenericAttributeValue<PsiClass> getClazz();


}
