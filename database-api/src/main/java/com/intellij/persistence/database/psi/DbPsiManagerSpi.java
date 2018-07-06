package com.intellij.persistence.database.psi;

import com.intellij.openapi.extensions.ExtensionPointName;

/**
 * @author Gregory.Shrago
 */
public interface DbPsiManagerSpi extends DbPsiManager {
  ExtensionPointName<DbPsiManagerSpi> EP_NAME = ExtensionPointName.create("com.intellij.persistence.database.dbPsiManager");

}