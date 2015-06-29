/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.android.aspects.aspects;

import java.util.ArrayList;
import java.util.Collection;

public class FilteredAspectsProvider<A extends Aspect<?>> implements AspectsProvider<A> {
    private final Class<A> aspectClassFilter;
    private final Collection<A> filteredAspects;

    public FilteredAspectsProvider(Class<A> aspectClassFilter, Collection<? extends Aspect<?>> aspects) {
        this.aspectClassFilter = aspectClassFilter;
        filteredAspects = filterAspects(aspects);
    }

    @Override
    public Collection<A> getAspects() {
        return filteredAspects;
    }

    @SuppressWarnings("unchecked")
    private Collection<A> filterAspects(Collection<? extends Aspect<?>> aspects) {
        Collection<A> filteredAspects = new ArrayList<>();
        for (Aspect<?> aspect : aspects) {
            if (aspectClassFilter.isAssignableFrom(aspect.getClass())) {
                filteredAspects.add((A) aspect);
            }
        }
        return filteredAspects;
    }
}
