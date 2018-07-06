// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-configuration-3.0.dtd

package com.intellij.hibernate.model.xml.config;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;

/**
 * hibernate-configuration-3.0.dtd:security interface.
 * Type security documentation
 * <pre>
 *  the JNDI name 
 * </pre>
 */
public interface Security extends CommonDomModelElement
{

	/**
	 * Returns the value of the context child.
	 * Attribute context
	 * @return the value of the context child.
	 */
	@Nonnull
	@Required
	GenericAttributeValue<String> getContext();


	/**
	 * Returns the list of grant children.
	 * Type grant documentation
	 * <pre>
	 * the JACC contextID
	 * </pre>
	 * @return the list of grant children.
	 */
	@Nonnull
	List<Grant> getGrants();
	/**
	 * Adds new child to the list of grant children.
	 * @return created child
	 */
	Grant addGrant();


}
