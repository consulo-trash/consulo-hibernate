/*
 * Copyright 2000-2007 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.persistence.model.manipulators;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.psi.PsiElement;
import com.intellij.util.xml.NameValue;
import com.intellij.util.xml.PrimaryKey;
import com.intellij.util.IncorrectOperationException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NonNls;

import java.util.Collection;
import java.util.Map;

/**
 * @author Gregory.Shrago
 */
public interface PersistenceAction {

  @NonNls int GROUP_UNIT = 10;
  @NonNls int GROUP_MAPPING = 20;
  @NonNls int GROUP_LISTENER = 30;
  @NonNls int GROUP_OBJECT = 40;
  @NonNls int GROUP_ATTRIBUTE = 50;
  @NonNls int GROUP_OTHER = 60;

  int getGroupId();

  @PrimaryKey
  Object getActionKey();

  @NameValue
  String getActionName();

  @Nonnull
  Presentation getPresentation();

  @Nullable
  PersistenceManipulator getActiveManipulator();

  void update(final AnActionEvent e);

  boolean preInvoke(final UserResponse response);

  void putTargetElement(Map<PersistenceAction, PsiElement> targetMap);

  void addAffectedElements(@Nonnull final Collection<PsiElement> affectedElements);

  void invokeAction(@Nonnull final Collection<PsiElement> result) throws IncorrectOperationException;

  boolean postInvoke(final PersistenceAction action, final UserResponse response);
}
