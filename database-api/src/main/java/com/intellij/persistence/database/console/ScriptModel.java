package com.intellij.persistence.database.console;

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.editor.event.DocumentEvent;
import javax.annotation.Nullable;

/**
 * @author Gregory.Shrago
 */
public interface ScriptModel {

  void documentChanged(final DocumentEvent e);

  int getStatementsCount();

  @Nullable
  String getParameterAt(int offset);

  int getStatementAt(int offset);

  String[] getParameterNames(int queryIndex);

  @Nullable
  String getParameterValue(int queryIndex, String parameter);

  void setParameterValue(int queryIndex, String parameter, String value);

  String getStatementText(int index, boolean applyParameters);

  TextRange[] getParameterRanges(int queryIndex, String parameterName);

  TextRange getStatementRange(int queryIdx);
}
