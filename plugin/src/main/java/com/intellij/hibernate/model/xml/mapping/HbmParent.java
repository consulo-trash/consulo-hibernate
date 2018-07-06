// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import javax.annotation.Nonnull;

import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.javaee.model.xml.CommonDomModelElement;

/**
 * hibernate-mapping-3.0.dtd:parent interface.
 * Type parent documentation
 * <pre>
 *  The parent element maps a property of the component class as a pointer back to
 * the owning entity. 
 * </pre>
 */
public interface HbmParent extends CommonDomModelElement {

	/**
	 * Returns the value of the name child.
	 * Attribute name
	 * @return the value of the name child.
	 */
	@Nonnull
	@Required
	GenericAttributeValue<String> getName();


}
