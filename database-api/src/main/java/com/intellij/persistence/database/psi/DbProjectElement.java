package com.intellij.persistence.database.psi;

/**
 * @author Gregory.Shrago
 */
public interface DbProjectElement extends DbElement{

  DbDataSourceElement[] getDataSources();
}