package com.intellij.persistence.database.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.ide.util.treeView.WeighedItem;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.meta.PsiPresentableMetaData;

/**
 * @author Gregory.Shrago
 */
public interface DbElement extends PsiNamedElement, NavigationItem, PsiPresentableMetaData, WeighedItem {
  DbElement[] EMPTY_ARRAY = new DbElement[0];

  Object getDelegate();

  @Nonnull
  DbElementType getType();

  String getDocumentation();

  @Nullable
  DbElement getDbParent();

  DbPsiManager getDbManager();

  DbDataSourceElement getDataSource();

  @Nonnull
  DbElement[] getDbChildren();
}
