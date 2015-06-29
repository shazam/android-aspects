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
package com.shazam.android.aspects.dispatchers.application;

import android.content.Context;
import android.content.res.Configuration;

import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.base.application.AspectApplication;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.application.ApplicationAspect;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

public class AspectApplicationDispatcher {

    private Collection<ApplicationAspect> applicationAspects;

    public AspectApplicationDispatcher(AspectsProvider<ApplicationAspect> aspectsProvider) {
        this.applicationAspects = aspectsProvider.getAspects();
    }

    public static AspectApplicationDispatcher create(AspectApplication application) {
        return new AspectApplicationDispatcher(providerFor(application));
    }

    private static AspectsProvider<ApplicationAspect> providerFor(AspectApplication application) {
        return annotatedAspectsFrom(application, ApplicationAspect.class, AspectApplication.class);
    }

    public void dispatchOnCreate(AspectApplication application) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.onCreate(application);
        }
    }

    public void dispatchOnLowMemory(AspectApplication application) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.onLowMemory(application);
        }
    }

    public void dispatchOnConfigurationChanged(AspectApplication application, Configuration newConfig) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.onConfigurationChanged(application, newConfig);
        }

    }

    public void dispatchOnTerminate(AspectApplication application) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.onTerminate(application);
        }
    }

    public void dispatchOnTrimMemory(AspectApplication application, int level) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.onTrimMemory(application, level);
        }
    }

    public void dispatchAttachBaseContext(AspectApplication application, Context base) {
        for (ApplicationAspect applicationAspect : applicationAspects) {
            applicationAspect.attachBaseContext(application, base);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, applicationAspects);
    }
}
