// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.hibernate.model.enums.LockModeType;
import com.intellij.javaee.model.xml.CommonDomModelElement;
import javax.annotation.Nonnull;

import java.util.List;

/**
 * hibernate-mapping-3.0.dtd:load-collection interface.
 */
public interface HbmLoadCollection extends CommonDomModelElement {

	/**
	 * Returns the value of the alias child.
	 * Attribute alias
	 * @return the value of the alias child.
	 */
	@Nonnull
	@Required
	GenericAttributeValue<String> getAlias();


	/**
	 * Returns the value of the lock-mode child.
	 * Attribute lock-mode
	 * @return the value of the lock-mode child.
	 */
	@Nonnull
	GenericAttributeValue<LockModeType> getLockMode();


	/**
	 * Returns the value of the role child.
	 * Attribute role
	 * @return the value of the role child.
	 */
	@Nonnull
	@Required
	GenericAttributeValue<String> getRole();


	/**
	 * Returns the list of return-property children.
	 * @return the list of return-property children.
	 */
	@Nonnull
	List<HbmReturnProperty> getReturnProperties();
	/**
	 * Adds new child to the list of return-property children.
	 * @return created child
	 */
	HbmReturnProperty addReturnProperty();


}
