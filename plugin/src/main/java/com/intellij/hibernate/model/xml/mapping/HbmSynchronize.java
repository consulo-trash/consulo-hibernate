// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import javax.annotation.Nonnull;

import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.Required;
import com.intellij.util.xml.Convert;
import com.intellij.javaee.model.xml.CommonDomModelElement;
import com.intellij.javaee.model.JavaeePersistenceORMResolveConverters;

/**
 * hibernate-mapping-3.0.dtd:synchronize interface.
 */
public interface HbmSynchronize extends CommonDomModelElement {

	/**
	 * Returns the value of the table child.
	 * Attribute table
	 * @return the value of the table child.
	 */
	@Nonnull
	@Required
        @Convert(JavaeePersistenceORMResolveConverters.TableResolver.class)
        GenericAttributeValue<String> getTable();


}
