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
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.base.activity.AspectFragmentActivity;
import com.shazam.android.aspects.aspects.AnnotatedAspectsProvider;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.activity.SupportActivityAspect;

import java.util.Collection;

/**
 * This dispatcher holds a list of {@link SupportActivityAspect}s and delegates all the lifecycle 
 * calls to them.
 */
public class AspectSupportActivityDispatcher {
    
    private Collection<SupportActivityAspect> activityAspects;

    public AspectSupportActivityDispatcher(AspectsProvider<SupportActivityAspect> aspectsProvider) {
        this.activityAspects = aspectsProvider.getAspects();
    }

    public static AspectSupportActivityDispatcher create(AspectFragmentActivity activity) {
        return new AspectSupportActivityDispatcher(providerFor(activity));
    }

    private static AspectsProvider<SupportActivityAspect> providerFor(AspectFragmentActivity activity) {
        return AnnotatedAspectsProvider.annotatedAspectsFrom(activity, SupportActivityAspect.class, AspectFragmentActivity.class);
    }

    public void dispatchOnPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog);
        }
    }

    public void dispatchOnPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog, Bundle args) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog, args);
        }
    }

    public Dialog dispatchOnCreateDialog(AspectFragmentActivity activity, int id) {
        for (SupportActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    @Nullable
    public Dialog dispatchOnCreateDialog(AspectFragmentActivity activity, int id, Bundle args) {
        for (SupportActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id, args);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    public void dispatchOnApplyThemeResource(AspectFragmentActivity activity, Resources.Theme theme, int resid, boolean first) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onApplyThemeResource(activity, theme, resid, first);
        }
    }

    public void dispatchOnPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnChildTitleChanged(AspectFragmentActivity activity, Activity childActivity, CharSequence title) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onChildTitleChanged(activity, childActivity, title);
        }
    }

    public void dispatchOnRestart(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestart(activity);
        }
    }

    public void dispatchOnRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState);
        }
    }

    public void dispatchOnTitleChanged(AspectFragmentActivity activity, CharSequence title, int color) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onTitleChanged(activity, title, color);
        }
    }

    public void dispatchOnUserLeaveHint(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onUserLeaveHint(activity);
        }
    }

    @Nullable
    public ActionMode dispatchOnWindowStartingActionMode(AspectFragmentActivity activity, ActionMode.Callback callback) {
        for (SupportActivityAspect aspect : activityAspects) {
            ActionMode actionMode = aspect.onWindowStartingActionMode(activity, callback);
            if (actionMode != null) {
                return actionMode;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(AspectFragmentActivity activity, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onContextItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateOptionsMenu(AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreateOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateThumbnail(AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreateThumbnail(activity, outBitmap, canvas)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnGenericMotionEvent(AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onGenericMotionEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyLongPress(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyLongPress(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyMultiple(AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyMultiple(activity, keyCode, repeatCount, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyShortcut(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyShortcut(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyUp(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyUp(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuOpened(AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onMenuOpened(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUp(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUp(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUpFromChild(AspectFragmentActivity activity, Activity child) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUpFromChild(activity, child)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(AspectFragmentActivity activity, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onOptionsItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPrepareOptionsMenu(AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnSearchRequested(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onSearchRequested(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTouchEvent(AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onTouchEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTrackballEvent(AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onTrackballEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public CharSequence dispatchOnCreateDescription(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            CharSequence description = aspect.onCreateDescription(activity);
            if (description != null) {
                return description;
            }
        }
        return null;
    }

    @Nullable
    public View dispatchOnCreatePanelView(AspectFragmentActivity activity, int featureId) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreatePanelView(activity, featureId);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public View dispatchOnCreateView(AspectFragmentActivity activity, View parent, String name, Context context, AttributeSet attrs) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, parent, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeFinished(AspectFragmentActivity activity, ActionMode mode) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActionModeFinished(activity, mode);
        }
    }

    public View dispatchOnCreateView(AspectFragmentActivity activity, String name, Context context, AttributeSet attrs) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeStarted(AspectFragmentActivity activity, ActionMode mode) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActionModeStarted(activity, mode);
        }
    }

    public void dispatchOnActivityReenter(AspectFragmentActivity activity, int resultCode, Intent data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActivityReenter(activity, resultCode, data);
        }
    }

    public void dispatchOnAttachedToWindow(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachedToWindow(activity);
        }
    }

    public void dispatchOnAttachFragment(AspectFragmentActivity activity, Fragment fragment) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnAttachFragment(AspectFragmentActivity activity, android.support.v4.app.Fragment fragment) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnContentChanged(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onContentChanged(activity);
        }
    }

    public void dispatchOnContextMenuClosed(AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onContextMenuClosed(activity, menu);
        }
    }

    public void dispatchOnCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnCreateContextMenu(AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreateContextMenu(activity, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreateNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnDetachedFromWindow(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onDetachedFromWindow(activity);
        }
    }

    public void dispatchOnEnterAnimationComplete(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onEnterAnimationComplete(activity);
        }
    }

    public void dispatchOnOptionsMenuClosed(AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onOptionsMenuClosed(activity, menu);
        }
    }

    public void dispatchOnPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnPrepareNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnProvideAssistData(AspectFragmentActivity activity, Bundle data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onProvideAssistData(activity, data);
        }
    }

    public void dispatchOnRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnSaveInstanceState(AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState, outPersistentState);
        }
    }

    public void dispatchOnTrimMemory(AspectFragmentActivity activity, int level) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onTrimMemory(activity, level);
        }
    }

    public void dispatchOnUserInteraction(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onUserInteraction(activity);
        }
    }

    public void dispatchOnVisibleBehindCanceled(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onVisibleBehindCanceled(activity);
        }
    }

    public void dispatchOnWindowAttributesChanged(AspectFragmentActivity activity, WindowManager.LayoutParams params) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onWindowAttributesChanged(activity, params);
        }
    }

    public void dispatchOnWindowFocusChanged(AspectFragmentActivity activity, boolean hasFocus) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onWindowFocusChanged(activity, hasFocus);
        }
    }

    public boolean dispatchOnPrepareOptionsPanel(AspectFragmentActivity activity, View view, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsPanel(activity, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOnActivityResult(AspectFragmentActivity activity, int requestCode, int resultCode, Intent data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    public void dispatchOnCreate(AspectFragmentActivity activity, Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnDestroy(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onDestroy(activity);
        }
    }

    public void dispatchOnNewIntent(AspectFragmentActivity activity, Intent intent) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onNewIntent(activity, intent);
        }
    }

    public void dispatchOnPause(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPause(activity);
        }
    }

    public void dispatchOnPostResume(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostResume(activity);
        }
    }

    public void dispatchOnResume(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onResume(activity);
        }
    }

    public void dispatchOnResumeFragments(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onResumeFragments(activity);
        }
    }

    public void dispatchOnSaveInstanceState(AspectFragmentActivity activity, Bundle outState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState);
        }
    }

    public void dispatchOnStart(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onStart(activity);
        }
    }

    public void dispatchOnStop(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onStop(activity);
        }
    }

    public boolean dispatchOnCreatePanelMenu(AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreatePanelMenu(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyDown(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyDown(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuItemSelected(AspectFragmentActivity activity, int featureId, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onMenuItemSelected(activity, featureId, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPreparePanel(AspectFragmentActivity activity, int featureId, View view, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPreparePanel(activity, featureId, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public Object dispatchOnRetainCustomNonConfigurationInstance(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            Object instance = aspect.onRetainCustomNonConfigurationInstance(activity);
            if (instance != null) {
                return instance;
            }
        }
        return null;
    }

    public void dispatchOnBackPressed(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onBackPressed(activity);
        }
    }

    public void dispatchOnConfigurationChanged(AspectFragmentActivity activity, Configuration newConfig) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onConfigurationChanged(activity, newConfig);
        }
    }

    public void dispatchOnLowMemory(AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onLowMemory(activity);
        }
    }

    public void dispatchOnPanelClosed(AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPanelClosed(activity, featureId, menu);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, activityAspects);
    }
}
