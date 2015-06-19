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

import android.content.Context;
import android.content.res.Configuration;

import com.shazam.android.aspects.base.application.AspectApplication;
import com.shazam.android.aspects.aspects.Aspect;

public interface ApplicationAspect extends Aspect<AspectApplication> {

    void onCreate(AspectApplication application);

    void onLowMemory(AspectApplication application);

    void onConfigurationChanged(AspectApplication application, Configuration newConfig);

    void onTerminate(AspectApplication application);

    void onTrimMemory(AspectApplication application, int level);

    void attachBaseContext(AspectApplication application, Context base);
}
