package com.intellij.persistence.database.psi;

import com.intellij.openapi.actionSystem.Presentation;

import java.util.List;

import javax.annotation.Nullable;

/**
 * @author Gregory.Shrago
 */
public interface DbPsiManager {
  List<DbDataSourceElement> getDataSources();

  void removeDataSource(final DbDataSourceElement element);

  void editDataSource(final DbDataSourceElement element);

  @Nullable
  DbDataSourceElement addDataSource(@Nullable final DbDataSourceElement template);

  void tuneCreateDataSourceAction(final Presentation presentation);
}
