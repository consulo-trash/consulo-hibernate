package com.intellij.persistence.database;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.module.Module;
import com.intellij.util.PathsList;

/**
 * @author Gregory.Shrago
 */
public interface DatabaseImplHelper {
  ExtensionPointName<DatabaseImplHelper> EP_NAME = ExtensionPointName.create("com.intellij.persistence.database.implHelper");

  void setupPsiClassField(final Project project, LabeledComponent<TextFieldWithBrowseButton> field);

  void collectModuleClasspath(Module module, PathsList classPath);
}
