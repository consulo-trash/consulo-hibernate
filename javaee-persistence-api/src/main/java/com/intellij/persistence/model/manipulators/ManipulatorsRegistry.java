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

import javax.annotation.Nullable;

import java.util.Collection;

/**
 * @author Gregory.Shrago
 */
public interface ManipulatorsRegistry {
  @Nullable
  <T, V extends T, M extends PersistenceManipulator<T>, N extends M> M getManipulator(final V element, final Class<N> manipulatorClass);

  <T> void registerManipulator(final Class<? extends T> targetClass, final Class<? extends PersistenceManipulator<T>> manipulatorClass);

  PersistenceAction getMergedPersistenceAction(final Collection<PersistenceAction> actions);
}
