package com.intellij.persistence.database;

/**
 * @author Gregory.Shrago
 */
public interface DatabaseConnectionInfo {
  String getName();
  String getDriverClass();
  String getUrl();
  String getUsername();
  String getPassword();
}
