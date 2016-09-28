/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
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
package com.speedment.runtime.internal.field.streamer;

import com.speedment.runtime.field.Field;
import com.speedment.runtime.field.trait.HasComparableOperators;
import com.speedment.runtime.field.trait.HasFinder;
import com.speedment.runtime.manager.Manager;
import java.util.stream.Stream;
import com.speedment.runtime.field.method.BackwardFinder;
import static java.util.Objects.requireNonNull;

/**
 *
 * @param <ENTITY>     the source entity
 * @param <FK_ENTITY>  the target entity
 * @param <T>          the column type
 * 
 * @author  Emil Forslund
 * @since   3.0.0
 */
public class BackwardFinderImpl<ENTITY, FK_ENTITY, T extends Comparable<? super T>, FIELD extends Field<FK_ENTITY, T> & HasComparableOperators<FK_ENTITY, T> & HasFinder<FK_ENTITY, ENTITY, T>>
    implements BackwardFinder<ENTITY, FK_ENTITY, T> {

    private final FIELD target;
    private final Manager<FK_ENTITY> manager;
    
    public BackwardFinderImpl(FIELD target, Manager<FK_ENTITY> manager) {
        this.target  = requireNonNull(target);
        this.manager = requireNonNull(manager);
    }
    
    @Override
    public final FIELD getField() {
        return target;
    }

    @Override
    public final Manager<FK_ENTITY> getTargetManager() {
        return manager;
    }

    @Override
    public Stream<FK_ENTITY> apply(ENTITY entity) {
        final T value = getField().getReferencedField().getter().apply(entity);
        if (value == null) {
            return null;
        } else {
            return getTargetManager().stream().filter(getField().equal(value));
        }
    }
}