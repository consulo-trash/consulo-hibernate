package com.intellij.persistence.database.psi;

import com.intellij.persistence.database.DatabaseColumnInfo;

/**
 * @author Gregory.Shrago
 */
public interface DbColumnElement extends DbElement, DatabaseColumnInfo{
  DbColumnElement[] EMPTY_ARRAY = new DbColumnElement[0];

  DbTableElement getDbParent();

}
