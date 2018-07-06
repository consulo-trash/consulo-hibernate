package com.intellij.persistence.database.console;

import javax.annotation.Nullable;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.util.Function;

/**
 * @author Gregory.Shrago
 */
public abstract class ScriptModelFactory {

  public static ExtensionPointName<ScriptModelFactory> EP_NAME = ExtensionPointName.create("com.intellij.persistence.database.consoleScriptModelFactory");

  @Nullable
  public abstract ScriptModel getScriptModel(final PsiFile file);

  @Nullable
  public abstract Function<Document, TextRange[]> getStatementSplitter(final PsiFile file);
}