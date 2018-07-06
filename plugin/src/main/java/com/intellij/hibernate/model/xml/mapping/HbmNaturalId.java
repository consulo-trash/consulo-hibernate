// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.util.xml.GenericAttributeValue;

/**
 * hibernate-mapping-3.0.dtd:natural-id interface.
 * Type natural-id documentation
 * <pre>
 *  A natural-id element allows declaration of the unique business key 
 * </pre>
 */
public interface HbmNaturalId extends CommonDomModelElement
{

	/**
	 * Returns the value of the mutable child.
	 * Attribute mutable
	 * @return the value of the mutable child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getMutable();


	/**
	 * Returns the list of property children.
	 * Type property documentation
	 * <pre>
	 *  Property of an entity class or component, component-element, composite-id, etc. 
	 * JavaBeans style properties are mapped to table columns. 
	 * </pre>
	 * @return the list of property children.
	 */
	@Nonnull
	List<HbmProperty> getProperties();
	/**
	 * Adds new child to the list of property children.
	 * @return created child
	 */
	HbmProperty addProperty();


	/**
	 * Returns the list of many-to-one children.
	 * Type many-to-one documentation
	 * <pre>
	 *  Declares an association between two entities (Or from a component, component element,
	 * etc. to an entity). 
	 * </pre>
	 * @return the list of many-to-one children.
	 */
	@Nonnull
	List<HbmManyToOne> getManyToOnes();
	/**
	 * Adds new child to the list of many-to-one children.
	 * @return created child
	 */
	HbmManyToOne addManyToOne();


	/**
	 * Returns the list of component children.
	 * Type component documentation
	 * <pre>
	 *  A component is a user-defined class, persisted along with its containing entity
	 * to the table of the entity class. JavaBeans style properties of the component are
	 * mapped to columns of the table of the containing entity. A null component reference
	 * is mapped to null values in all columns and vice versa. Components do not support
	 * shared reference semantics. 
	 * </pre>
	 * @return the list of component children.
	 */
	@Nonnull
	List<HbmComponent> getComponents();
	/**
	 * Adds new child to the list of component children.
	 * @return created child
	 */
	HbmComponent addComponent();


	/**
	 * Returns the list of dynamic-component children.
	 * Type dynamic-component documentation
	 * <pre>
	 *  A dynamic-component maps columns of the database entity to a java.util.Map 
	 * at the Java level 
	 * </pre>
	 * @return the list of dynamic-component children.
	 */
	@Nonnull
	List<HbmDynamicComponent> getDynamicComponents();
	/**
	 * Adds new child to the list of dynamic-component children.
	 * @return created child
	 */
	HbmDynamicComponent addDynamicComponent();


	/**
	 * Returns the list of any children.
	 * Type any documentation
	 * <pre>
	 *  An "any" association is a polymorphic association to any table with
	 * the given identifier type. The first listed column is a VARCHAR column 
	 * holding the name of the class (for that row). 
	 * </pre>
	 * @return the list of any children.
	 */
	@Nonnull
	List<HbmAny> getAnies();
	/**
	 * Adds new child to the list of any children.
	 * @return created child
	 */
	HbmAny addAny();


}
