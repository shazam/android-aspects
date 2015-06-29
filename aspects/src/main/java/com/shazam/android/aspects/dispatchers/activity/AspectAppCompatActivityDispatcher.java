/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (@NonNull AspectAppCompatActivity activity, the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.android.aspects.dispatchers.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.aspects.activity.AppCompatActivityAspect;
import com.shazam.android.aspects.base.activity.AspectAppCompatActivity;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

/**
 * This dispatcher holds a list of {@link AppCompatActivityAspect}s and delegates all the lifecycle calls
 * to them.
 */
public class AspectAppCompatActivityDispatcher {

    private Collection<AppCompatActivityAspect> activityAspects;

    public AspectAppCompatActivityDispatcher(AspectsProvider<AppCompatActivityAspect> aspectsProvider) {
        this.activityAspects = aspectsProvider.getAspects();
    }

    public static AspectAppCompatActivityDispatcher create(@NonNull AspectAppCompatActivity activity) {
        return new AspectAppCompatActivityDispatcher(providerFor(activity));
    }

    private static AspectsProvider<AppCompatActivityAspect> providerFor(@NonNull AspectAppCompatActivity activity) {
        return annotatedAspectsFrom(activity, AppCompatActivityAspect.class, AspectAppCompatActivity.class);
    }

    public void dispatchOnCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnTrimMemory(@NonNull AspectAppCompatActivity activity, int level) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onTrimMemory(activity, level);
        }
    }

    public void dispatchOnConfigurationChanged(@NonNull AspectAppCompatActivity activity, Configuration newConfig) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onConfigurationChanged(activity, newConfig);
        }
    }

    public void dispatchOnLowMemory(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onLowMemory(activity);
        }
    }

    public void dispatchOnApplyThemeResource(@NonNull AspectAppCompatActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onApplyThemeResource(activity, theme, resid, first);
        }
    }

    public void dispatchOnChildTitleChanged(@NonNull AspectAppCompatActivity activity, Activity childActivity, CharSequence title) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onChildTitleChanged(activity, childActivity, title);
        }
    }

    public void dispatchOnRestart(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onRestart(activity);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectAppCompatActivity activity, @NonNull Bundle savedInstanceState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState);
        }
    }

    public void dispatchOnUserLeaveHint(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onUserLeaveHint(activity);
        }
    }

    @Nullable
    public ActionMode dispatchOnWindowStartingActionMode(@NonNull AspectAppCompatActivity activity, ActionMode.Callback callback) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            ActionMode actionMode = aspect.onWindowStartingActionMode(activity, callback);
            if (actionMode != null) {
                return actionMode;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onContextItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onCreateOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateThumbnail(@NonNull AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onCreateThumbnail(activity, outBitmap, canvas)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnGenericMotionEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onGenericMotionEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyLongPress(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onKeyLongPress(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyMultiple(@NonNull AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onKeyMultiple(activity, keyCode, repeatCount, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyShortcut(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onKeyShortcut(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyUp(@NonNull AspectAppCompatActivity activity, int keyCode, @NonNull KeyEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onKeyUp(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuOpened(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onMenuOpened(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUp(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUp(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUpFromChild(@NonNull AspectAppCompatActivity activity, Activity child) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUpFromChild(activity, child)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onOptionsItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPrepareOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnSearchRequested(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onSearchRequested(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTouchEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onTouchEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTrackballEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onTrackballEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public CharSequence dispatchOnCreateDescription(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            CharSequence description = aspect.onCreateDescription(activity);
            if (description != null) {
                return description;
            }
        }
        return null;
    }

    public void dispatchOnCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnAttachFragment(@NonNull AspectAppCompatActivity activity, Fragment fragment) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnAttachFragment(@NonNull AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    @Nullable
    public View dispatchOnCreatePanelView(@NonNull AspectAppCompatActivity activity, int featureId) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            View panelView = aspect.onCreatePanelView(activity, featureId);
            if (panelView != null) {
                return panelView;
            }
        }
        return null;
    }

    public View dispatchOnCreateView(@NonNull AspectAppCompatActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, parent, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeFinished(@NonNull AspectAppCompatActivity activity, ActionMode mode) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onActionModeFinished(activity, mode);
        }
    }

    @Nullable
    public View dispatchOnCreateView(@NonNull AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeStarted(@NonNull AspectAppCompatActivity activity, ActionMode mode) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onActionModeStarted(activity, mode);
        }
    }

    public void dispatchOnActivityReenter(@NonNull AspectAppCompatActivity activity, int resultCode, Intent data) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onActivityReenter(activity, resultCode, data);
        }
    }

    public void dispatchOnAttachedToWindow(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onAttachedToWindow(activity);
        }
    }

    public void dispatchOnContextMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onContextMenuClosed(activity, menu);
        }
    }

    public void dispatchOnCreateContextMenu(@NonNull AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onCreateContextMenu(activity, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, @NonNull TaskStackBuilder builder) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onCreateNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnDetachedFromWindow(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onDetachedFromWindow(activity);
        }
    }

    public void dispatchOnEnterAnimationComplete(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onEnterAnimationComplete(activity);
        }
    }

    public void dispatchOnOptionsMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onOptionsMenuClosed(activity, menu);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnPrepareNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, TaskStackBuilder builder) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPrepareNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnProvideAssistData(@NonNull AspectAppCompatActivity activity, Bundle data) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onProvideAssistData(activity, data);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState, outPersistentState);
        }
    }

    public void dispatchOnUserInteraction(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onUserInteraction(activity);
        }
    }

    public void dispatchOnVisibleBehindCanceled(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onVisibleBehindCanceled(activity);
        }
    }

    public void dispatchOnWindowAttributesChanged(@NonNull AspectAppCompatActivity activity, WindowManager.LayoutParams params) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onWindowAttributesChanged(activity, params);
        }
    }

    public void dispatchOnWindowFocusChanged(@NonNull AspectAppCompatActivity activity, boolean hasFocus) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onWindowFocusChanged(activity, hasFocus);
        }
    }

    public boolean dispatchOnPrepareOptionsPanel(@NonNull AspectAppCompatActivity activity, View view, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsPanel(activity, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOnActivityResult(@NonNull AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    public void dispatchOnDestroy(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onDestroy(activity);
        }
    }

    public void dispatchOnNewIntent(@NonNull AspectAppCompatActivity activity, Intent intent) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onNewIntent(activity, intent);
        }
    }

    public void dispatchOnPause(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPause(activity);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnPostResume(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPostResume(activity);
        }
    }

    public void dispatchOnResume(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onResume(activity);
        }
    }

    public void dispatchOnResumeFragments(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onResumeFragments(activity);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState);
        }
    }

    public void dispatchOnStart(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onStart(activity);
        }
    }

    public void dispatchOnStop(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onStop(activity);
        }
    }

    public void dispatchOnTitleChanged(@NonNull AspectAppCompatActivity activity, CharSequence title, int color) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onTitleChanged(activity, title, color);
        }
    }

    @Nullable
    public android.support.v7.view.ActionMode dispatchOnWindowStartingSupportActionMode(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            android.support.v7.view.ActionMode actionMode = aspect.onWindowStartingSupportActionMode(activity, callback);
            if (actionMode != null) {
                return actionMode;
            }
        }
        return null;
    }

    public boolean dispatchOnCreatePanelMenu(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onCreatePanelMenu(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyDown(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onKeyDown(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPreparePanel(@NonNull AspectAppCompatActivity activity, int featureId, View view, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onPreparePanel(activity, featureId, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnSupportNavigateUp(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            if (aspect.onSupportNavigateUp(activity)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOnContentChanged(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onContentChanged(activity);
        }
    }

    public void dispatchOnCreateSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onCreateSupportNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnPrepareSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPrepareSupportNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnSupportActionModeFinished(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onSupportActionModeFinished(activity, mode);
        }
    }

    public void dispatchOnSupportActionModeStarted(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onSupportActionModeStarted(activity, mode);
        }
    }

    public void dispatchOnSupportContentChanged(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onSupportContentChanged(activity);
        }
    }

    public void dispatchOnBackPressed(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onBackPressed(activity);
        }
    }

    public void dispatchOnPanelClosed(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPanelClosed(activity, featureId, menu);
        }
    }

    public Object dispatchOnRetainCustomNonConfigurationInstance(@NonNull AspectAppCompatActivity activity) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            Object configurationInstance = aspect.onRetainCustomNonConfigurationInstance(activity);
            if (configurationInstance != null) {
                return configurationInstance;
            }
        }
        return null;
    }

    public Dialog dispatchOnCreateDialog(@NonNull AspectAppCompatActivity activity, int id) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    @Nullable
    public Dialog dispatchOnCreateDialog(@NonNull AspectAppCompatActivity activity, int id, Bundle args) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id, args);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    public void dispatchOnPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog);
        }
    }

    public void dispatchOnPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
        for (AppCompatActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog, args);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, activityAspects);
    }
}
