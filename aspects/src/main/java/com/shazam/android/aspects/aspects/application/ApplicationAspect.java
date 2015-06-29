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
package com.shazam.android.aspects.aspects.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.shazam.android.aspects.base.application.AspectApplication;
import com.shazam.android.aspects.aspects.Aspect;

public interface ApplicationAspect extends Aspect<AspectApplication> {

    /**
     * @see Application#onCreate()
     */
    void onCreate(AspectApplication application);

    /**
     * @see Application#onLowMemory()
     */
    void onLowMemory(AspectApplication application);

    /**
     * @see Application#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(AspectApplication application, Configuration newConfig);

    /**
     * @see Application#onTerminate()
     */
    void onTerminate(AspectApplication application);

    /**
     * @see Application#onTrimMemory(int)
     */
    void onTrimMemory(AspectApplication application, int level);

    /**
     * @see Application#attachBaseContext(Context)
     */
    void attachBaseContext(AspectApplication application, Context base);
}
