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

package com.intellij.persistence.model.helpers;

import com.intellij.persistence.model.RelationshipType;
import com.intellij.persistence.model.TableInfoProvider;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Collection;

/**
 * @author Gregory.Shrago
*/
public interface PersistentRelationshipAttributeModelHelper extends PersistentAttributeModelHelper {
  @Nonnull
  RelationshipType getRelationshipType();

  boolean isRelationshipSideOptional(final boolean thisSide);

  @Nullable
  String getMappedByAttributeName();

  @Nullable
  TableInfoProvider getTableInfoProvider();

  boolean isInverseSide();

  String getFetchType();

  Collection<String> getCascadeTypes();
}
