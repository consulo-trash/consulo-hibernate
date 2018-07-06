package com.intellij.persistence.database;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Gregory.Shrago
 */
public interface DataSourceInfo {

  String getName();

  String getUniqueId();

  @Nullable
  String getDatabaseProductName();

  @Nullable
  String getDatabaseProductVersion();

  @Nonnull
  DatabaseTableLongInfo[] getMyTables();


}
