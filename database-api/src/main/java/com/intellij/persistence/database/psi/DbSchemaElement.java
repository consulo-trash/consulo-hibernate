package com.intellij.persistence.database.psi;

/**
 * @author Gregory.Shrago
 */
public interface DbSchemaElement extends DbElement {
  DbCatalogElement getDbParent();
  DbTableElement[] getTables();
}
