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

import android.support.annotation.NonNull;

import com.shazam.android.aspects.annotations.Aspects;

/**
 * This is the common interface for all the aspects. Only classes that implement this
 * interface (directly or indirectly) can be listed in the {@link Aspects#aspects()} parameter.
 */
public interface Aspect<C> {
    @NonNull
    Class<C> classActingOn();
}
