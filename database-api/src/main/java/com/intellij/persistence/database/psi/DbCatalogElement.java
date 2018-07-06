package com.intellij.persistence.database.psi;

/**
 * @author Gregory.Shrago
 */
public interface DbCatalogElement extends DbElement{
  DbDataSourceElement getDbParent();
  DbSchemaElement[] getSchemas();
}
