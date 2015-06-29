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
package com.shazam.android.aspects.base.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.dispatchers.application.AspectApplicationDispatcher;

public class AspectApplication extends Application {

    private final AspectApplicationDispatcher dispatcher;

    public AspectApplication() {
        dispatcher = AspectApplicationDispatcher.create(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dispatcher.dispatchOnCreate(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        dispatcher.dispatchOnLowMemory(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dispatcher.dispatchOnConfigurationChanged(this, newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        dispatcher.dispatchOnTerminate(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        dispatcher.dispatchOnTrimMemory(this, level);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        dispatcher.dispatchAttachBaseContext(this, base);
    }

    protected <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(Class<A> aspectClass) {
        return dispatcher.getAspectProvider(aspectClass);
    }
}
