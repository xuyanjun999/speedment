/**
 *
 * Copyright (c) 2006-2019, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.common.codegen.model.modifier;

import com.speedment.common.codegen.model.Class;
import com.speedment.common.codegen.model.modifier.Keyword.Abstract;
import com.speedment.common.codegen.model.modifier.Keyword.Final;
import com.speedment.common.codegen.model.modifier.Keyword.Private;
import com.speedment.common.codegen.model.modifier.Keyword.Protected;
import com.speedment.common.codegen.model.modifier.Keyword.Public;
import com.speedment.common.codegen.model.modifier.Keyword.Static;
import com.speedment.common.codegen.model.modifier.Keyword.Strictfp;
import com.speedment.common.codegen.model.trait.HasModifiers;

/**
 * Composed trait of all the {@link HasModifiers modifiers} that can be added to
 * a {@link Class}.
 *
 * @param <T>  the extending type
 *
 * @author Emil Forslund
 * @since  2.0
 */
public interface ClassModifier<T extends ClassModifier<T>> extends Public<T>, 
Protected<T>, Private<T>, Abstract<T>, Static<T>, Final<T>, Strictfp<T> {}