// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import com.intellij.hibernate.model.converters.CascadeTypeListConverter;
import com.intellij.hibernate.model.converters.MappingClassResolveConverter;
import com.intellij.hibernate.model.converters.LazyTypeConverter;
import com.intellij.hibernate.model.enums.*;
import com.intellij.javaee.model.xml.CommonDomModelElement;
import com.intellij.psi.PsiClass;
import com.intellij.util.xml.*;
import javax.annotation.Nonnull;

import java.util.List;

/**
 * hibernate-mapping-3.0.dtd:bag interface.
 */
public interface HbmBag extends CommonDomModelElement, HbmContainer {

	/**
	 * Returns the value of the persister child.
	 * Attribute persister
	 * @return the value of the persister child.
	 */
	@Nonnull
        @Convert(MappingClassResolveConverter.class)
        GenericAttributeValue<PsiClass> getPersister();


	/**
	 * Returns the value of the inverse child.
	 * Attribute inverse
	 * @return the value of the inverse child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getInverse();


	/**
	 * Returns the value of the collection-type child.
	 * Attribute collection-type
	 * @return the value of the collection-type child.
	 */
	@Nonnull
	GenericAttributeValue<String> getCollectionType();


	/**
	 * Returns the value of the cascade child.
	 * Attribute cascade
	 * @return the value of the cascade child.
	 */
	@Nonnull
        @Convert(CascadeTypeListConverter.class)
        GenericAttributeValue<List<CascadeType>> getCascade();


	/**
	 * Returns the value of the access child.
	 * Attribute access
	 * @return the value of the access child.
	 */
	@Nonnull
	GenericAttributeValue<AccessType> getAccess();


	/**
	 * Returns the value of the order-by child.
	 * Attribute order-by
	 * @return the value of the order-by child.
	 */
	@Nonnull
	GenericAttributeValue<String> getOrderBy();


	/**
	 * Returns the value of the catalog child.
	 * Attribute catalog
	 * @return the value of the catalog child.
	 */
	@Nonnull
	GenericAttributeValue<String> getCatalog();


	/**
	 * Returns the value of the optimistic-lock child.
	 * Attribute optimistic-lock
	 * @return the value of the optimistic-lock child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getOptimisticLock();


	/**
	 * Returns the value of the where child.
	 * Attribute where
	 * @return the value of the where child.
	 */
	@Nonnull
	GenericAttributeValue<String> getWhere();


	/**
	 * Returns the value of the outer-join child.
	 * Attribute outer-join
	 * @return the value of the outer-join child.
	 */
	@Nonnull
	GenericAttributeValue<String> getOuterJoin();


	/**
	 * Returns the value of the subselect child.
	 * Attribute subselect
	 * @return the value of the subselect child.
	 */
	@Nonnull
	@com.intellij.util.xml.Attribute ("subselect")
	GenericAttributeValue<String> getSubselectAttr();


	/**
	 * Returns the value of the embed-xml child.
	 * Attribute embed-xml
	 * @return the value of the embed-xml child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getEmbedXml();


	/**
	 * Returns the value of the schema child.
	 * Attribute schema
	 * @return the value of the schema child.
	 */
	@Nonnull
	GenericAttributeValue<String> getSchema();


	/**
	 * Returns the value of the fetch child.
	 * Attribute fetch
	 * @return the value of the fetch child.
	 */
	@Nonnull
	GenericAttributeValue<CollectionFetchType> getFetch();


	/**
	 * Returns the value of the node child.
	 * Attribute node
	 * @return the value of the node child.
	 */
	@Nonnull
	GenericAttributeValue<String> getNode();


	/**
	 * Returns the value of the mutable child.
	 * Attribute mutable
	 * @return the value of the mutable child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getMutable();


	/**
	 * Returns the value of the lazy child.
	 * Attribute lazy
	 * @return the value of the lazy child.
	 */
	@Nonnull
        @Convert(LazyTypeConverter.class)
        GenericAttributeValue<LazyType> getLazy();


  /**
	 * Returns the value of the table child.
	 * Attribute table
	 * @return the value of the table child.
	 */
	@Nonnull
        @Attribute("table")
        GenericAttributeValue<String> getTableName();


	/**
	 * Returns the value of the check child.
	 * Attribute check
	 * @return the value of the check child.
	 */
	@Nonnull
	GenericAttributeValue<Boolean> getCheck();


	/**
	 * Returns the value of the batch-size child.
	 * Attribute batch-size
	 * @return the value of the batch-size child.
	 */
	@Nonnull
	GenericAttributeValue<Integer> getBatchSize();


	/**
	 * Returns the value of the name child.
	 * Attribute name
	 * @return the value of the name child.
	 */
	//@NotNull
	//@Required
	//GenericAttributeValue<String> getName();


	/**
	 * Returns the list of meta children.
	 * Type meta documentation
	 * <pre>
	 * 	META element definition; used to assign meta-level attributes to a class
	 * 	or property.  Is currently used by codegenerator as a placeholder for
	 * 	values that is not directly related to OR mappings.
	 * </pre>
	 * @return the list of meta children.
	 */
	@Nonnull
	List<HbmMeta> getMetas();
	/**
	 * Adds new child to the list of meta children.
	 * @return created child
	 */
	HbmMeta addMeta();


	/**
	 * Returns the value of the subselect child.
	 * @return the value of the subselect child.
	 */
	@Nonnull
	GenericDomValue<String> getSubselect();


	/**
	 * Returns the value of the cache child.
	 * Type cache documentation
	 * <pre>
	 *  The cache element enables caching of an entity class. 
	 * </pre>
	 * @return the value of the cache child.
	 */
	@Nonnull
	HbmCache getCache();


	/**
	 * Returns the list of synchronize children.
	 * @return the list of synchronize children.
	 */
	@Nonnull
	List<HbmSynchronize> getSynchronizes();
	/**
	 * Adds new child to the list of synchronize children.
	 * @return created child
	 */
	HbmSynchronize addSynchronize();


	/**
	 * Returns the value of the comment child.
	 * Type comment documentation
	 * <pre>
	 *  The comment element allows definition of a database table or column comment. 
	 * </pre>
	 * @return the value of the comment child.
	 */
	@Nonnull
	GenericDomValue<String> getComment();


	/**
	 * Returns the value of the key child.
	 * Type key documentation
	 * <pre>
	 *  Declares the column name of a foreign key. 
	 * </pre>
	 * @return the value of the key child.
	 */
	@Nonnull
	@Required
	HbmKey getKey();


	/**
	 * Returns the value of the loader child.
	 * Type loader documentation
	 * <pre>
	 *  The loader element allows specification of a named query to be used for fetching
	 * an entity or collection 
	 * </pre>
	 * @return the value of the loader child.
	 */
	@Nonnull
	HbmLoader getLoader();


	/**
	 * Returns the value of the sql-insert child.
	 * Type sql-insert documentation
	 * <pre>
	 *  custom sql operations 
	 * </pre>
	 * @return the value of the sql-insert child.
	 */
	@Nonnull
	HbmSqlStatement getSqlInsert();


	/**
	 * Returns the value of the sql-update child.
	 * @return the value of the sql-update child.
	 */
	@Nonnull
	HbmSqlStatement getSqlUpdate();


	/**
	 * Returns the value of the sql-delete child.
	 * @return the value of the sql-delete child.
	 */
	@Nonnull
	HbmSqlStatement getSqlDelete();


	/**
	 * Returns the value of the sql-delete-all child.
	 * @return the value of the sql-delete-all child.
	 */
	@Nonnull
	HbmSqlStatement getSqlDeleteAll();


	/**
	 * Returns the list of filter children.
	 * Type filter documentation
	 * <pre>
	 * 	FILTER element; used to apply a filter.
	 * </pre>
	 * @return the list of filter children.
	 */
	@Nonnull
	List<HbmFilter> getFilters();
	/**
	 * Adds new child to the list of filter children.
	 * @return created child
	 */
	HbmFilter addFilter();


	/**
	 * Returns the value of the element child.
	 * Type element documentation
	 * <pre>
	 *  Declares the element type of a collection of basic type 
	 * </pre>
	 * @return the value of the element child.
	 */
	@Nonnull
	HbmElement getElement();


	/**
	 * Returns the value of the one-to-many child.
	 * Type one-to-many documentation
	 * <pre>
	 *  One to many association. This tag declares the entity-class
	 * element type of a collection and specifies a one-to-many relational model 
	 * </pre>
	 * @return the value of the one-to-many child.
	 */
	@Nonnull
	HbmOneToMany getOneToMany();


	/**
	 * Returns the value of the many-to-many child.
	 * Type many-to-many documentation
	 * <pre>
	 *  Many to many association. This tag declares the entity-class
	 * element type of a collection and specifies a many-to-many relational model 
	 * </pre>
	 * @return the value of the many-to-many child.
	 */
	@Nonnull
	HbmManyToMany getManyToMany();


	/**
	 * Returns the value of the composite-element child.
	 * Type composite-element documentation
	 * <pre>
	 *  A composite element allows a collection to hold instances of an arbitrary 
	 * class, without the requirement of joining to an entity table. Composite elements
	 * have component semantics - no shared references and ad hoc null value semantics. 
	 * Composite elements may not hold nested collections. 
	 * </pre>
	 * @return the value of the composite-element child.
	 */
	@Nonnull
	HbmCompositeElement getCompositeElement();


	/**
	 * Returns the value of the many-to-any child.
	 * Type many-to-any documentation
	 * <pre>
	 *  A "many to any" defines a polymorphic association to any table 
	 * with the given identifier type. The first listed column is a VARCHAR column 
	 * holding the name of the class (for that row). 
	 * </pre>
	 * @return the value of the many-to-any child.
	 */
	@Nonnull
	HbmManyToAny getManyToAny();


}
