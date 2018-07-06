package com.intellij.hibernate.model.xml.mapping;

import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.javaee.model.JavaeePersistenceORMResolveConverters;
import com.intellij.persistence.model.TableInfoProvider;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;

/**
 * @author Gregory.Shrago
 */
public interface HbmTableInfoProvider extends TableInfoProvider, CommonDomModelElement
{
  @Convert(JavaeePersistenceORMResolveConverters.TableResolver.class)
  GenericAttributeValue<String> getTableName();

  @Convert(JavaeePersistenceORMResolveConverters.CatalogResolver.class)
  GenericAttributeValue<String> getCatalog();

  @Convert(JavaeePersistenceORMResolveConverters.SchemaResolver.class)
  GenericAttributeValue<String> getSchema();
}
