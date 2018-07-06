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

package com.intellij.persistence;

import com.intellij.util.Icons;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author Gregory.Shrago
 */
public interface PersistenceIcons {
  Icon PROPERTIES_ICON = IconLoader.getIcon("/actions/properties.png");
  Icon RELATIONSHIP_ICON = IconLoader.getIcon("/javaee/persistenceRelationship.png");
  Icon SYNCHRONIZE_ICON = IconLoader.getIcon("/actions/sync.png");
  Icon SELECT_ALL_ICON = IconLoader.getIcon("/actions/selectall.png");
  Icon UNSELECT_ALL_ICON = IconLoader.getIcon("/actions/unselectall.png");


  Icon DATASOURCE_ICON = Icons.DATASOURCE_ICON;
  Icon DATASOURCE_DISABLED_ICON = Icons.DATASOURCE_DISABLED_ICON;
  Icon DATASOURCE_TABLE_ICON = Icons.DATASOURCE_TABLE_ICON;
  Icon DATASOURCE_VIEW_ICON = Icons.DATASOURCE_VIEW_ICON;
  Icon DATASOURCE_SEQUENCE_ICON = Icons.DATASOURCE_SEQUENCE_ICON;
  Icon DATASOURCE_COLUMN_ICON = Icons.DATASOURCE_COLUMN_ICON;
  Icon DATASOURCE_FK_COLUMN_ICON = Icons.DATASOURCE_FK_COLUMN_ICON;
  Icon DATASOURCE_PK_COLUMN_ICON = Icons.DATASOURCE_PK_COLUMN_ICON;

  Icon CONSOLE_ICON = IconLoader.getIcon("/runConfigurations/ql_console.png");
  Icon CONSOLE_OUTPUT_ICON = IconLoader.getIcon("/debugger/console.png");

  Icon OVR_INHERITED_ATTRIBUTE = IconLoader.getIcon("/javaee/inheritedAttributeOverlay.png");
  Icon OVR_EMBEDDED_ATTRIBUTE = IconLoader.getIcon("/javaee/embeddedAttributeOverlay.png");

}
