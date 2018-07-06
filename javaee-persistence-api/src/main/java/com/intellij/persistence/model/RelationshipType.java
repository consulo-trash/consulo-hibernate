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

package com.intellij.persistence.model;

/**
 * @author Gregory.Shrago
 */
public enum RelationshipType {
  ONE_TO_ONE, ONE_TO_MANY, MANY_TO_ONE, MANY_TO_MANY;

  public boolean isMany(boolean thisSide) {
    switch (this) {
      case MANY_TO_MANY: return true;
      case MANY_TO_ONE: return thisSide;
      case ONE_TO_MANY: return !thisSide;
      case ONE_TO_ONE: return false;
    }
    return false;
  }

  public RelationshipType getInverseType() {
    switch (this) {
      case MANY_TO_MANY: return this;
      case MANY_TO_ONE: return ONE_TO_MANY;
      case ONE_TO_MANY: return MANY_TO_ONE;
      case ONE_TO_ONE: return this;
    }
    return null;
  }

  public boolean corresponds(final RelationshipType otherSideType) {
    return getInverseType() == otherSideType;
  }

  public static RelationshipType getRelationshipType(final boolean thatSideMany, final boolean thisSideMany) {
    return thisSideMany? (thatSideMany? MANY_TO_MANY : MANY_TO_ONE) : (thatSideMany ? ONE_TO_MANY : ONE_TO_ONE);
  }
}
