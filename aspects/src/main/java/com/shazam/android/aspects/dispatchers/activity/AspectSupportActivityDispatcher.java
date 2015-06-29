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

    public static AspectSupportActivityDispatcher create(@NonNull AspectFragmentActivity activity) {
        return new AspectSupportActivityDispatcher(providerFor(activity));
    }

    private static AspectsProvider<SupportActivityAspect> providerFor(@NonNull AspectFragmentActivity activity) {
        return AnnotatedAspectsProvider.annotatedAspectsFrom(activity, SupportActivityAspect.class, AspectFragmentActivity.class);
    }

    public void dispatchOnPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog);
        }
    }

    public void dispatchOnPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog, args);
        }
    }

    public Dialog dispatchOnCreateDialog(@NonNull AspectFragmentActivity activity, int id) {
        for (SupportActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    @Nullable
    public Dialog dispatchOnCreateDialog(@NonNull AspectFragmentActivity activity, int id, Bundle args) {
        for (SupportActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id, args);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    public void dispatchOnApplyThemeResource(@NonNull AspectFragmentActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onApplyThemeResource(activity, theme, resid, first);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnChildTitleChanged(@NonNull AspectFragmentActivity activity, Activity childActivity, CharSequence title) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onChildTitleChanged(activity, childActivity, title);
        }
    }

    public void dispatchOnRestart(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestart(activity);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectFragmentActivity activity, @NonNull Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState);
        }
    }

    public void dispatchOnTitleChanged(@NonNull AspectFragmentActivity activity, CharSequence title, int color) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onTitleChanged(activity, title, color);
        }
    }

    public void dispatchOnUserLeaveHint(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onUserLeaveHint(activity);
        }
    }

    @Nullable
    public ActionMode dispatchOnWindowStartingActionMode(@NonNull AspectFragmentActivity activity, ActionMode.Callback callback) {
        for (SupportActivityAspect aspect : activityAspects) {
            ActionMode actionMode = aspect.onWindowStartingActionMode(activity, callback);
            if (actionMode != null) {
                return actionMode;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onContextItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreateOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateThumbnail(@NonNull AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreateThumbnail(activity, outBitmap, canvas)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnGenericMotionEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onGenericMotionEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyLongPress(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyLongPress(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyMultiple(@NonNull AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyMultiple(activity, keyCode, repeatCount, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyShortcut(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyShortcut(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyUp(@NonNull AspectFragmentActivity activity, int keyCode, @NonNull KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyUp(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuOpened(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onMenuOpened(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUp(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUp(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUpFromChild(@NonNull AspectFragmentActivity activity, Activity child) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUpFromChild(activity, child)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onOptionsItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPrepareOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnSearchRequested(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onSearchRequested(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTouchEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onTouchEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTrackballEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onTrackballEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public CharSequence dispatchOnCreateDescription(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            CharSequence description = aspect.onCreateDescription(activity);
            if (description != null) {
                return description;
            }
        }
        return null;
    }

    @Nullable
    public View dispatchOnCreatePanelView(@NonNull AspectFragmentActivity activity, int featureId) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreatePanelView(activity, featureId);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public View dispatchOnCreateView(@NonNull AspectFragmentActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, parent, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeFinished(@NonNull AspectFragmentActivity activity, ActionMode mode) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActionModeFinished(activity, mode);
        }
    }

    public View dispatchOnCreateView(@NonNull AspectFragmentActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        for (SupportActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeStarted(@NonNull AspectFragmentActivity activity, ActionMode mode) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActionModeStarted(activity, mode);
        }
    }

    public void dispatchOnActivityReenter(@NonNull AspectFragmentActivity activity, int resultCode, Intent data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActivityReenter(activity, resultCode, data);
        }
    }

    public void dispatchOnAttachedToWindow(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachedToWindow(activity);
        }
    }

    public void dispatchOnAttachFragment(@NonNull AspectFragmentActivity activity, Fragment fragment) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnAttachFragment(@NonNull AspectFragmentActivity activity, android.support.v4.app.Fragment fragment) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnContentChanged(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onContentChanged(activity);
        }
    }

    public void dispatchOnContextMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onContextMenuClosed(activity, menu);
        }
    }

    public void dispatchOnCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnCreateContextMenu(@NonNull AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreateContextMenu(activity, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, @NonNull TaskStackBuilder builder) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreateNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnDetachedFromWindow(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onDetachedFromWindow(activity);
        }
    }

    public void dispatchOnEnterAnimationComplete(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onEnterAnimationComplete(activity);
        }
    }

    public void dispatchOnOptionsMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onOptionsMenuClosed(activity, menu);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnPrepareNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, TaskStackBuilder builder) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPrepareNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnProvideAssistData(@NonNull AspectFragmentActivity activity, Bundle data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onProvideAssistData(activity, data);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState, outPersistentState);
        }
    }

    public void dispatchOnTrimMemory(@NonNull AspectFragmentActivity activity, int level) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onTrimMemory(activity, level);
        }
    }

    public void dispatchOnUserInteraction(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onUserInteraction(activity);
        }
    }

    public void dispatchOnVisibleBehindCanceled(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onVisibleBehindCanceled(activity);
        }
    }

    public void dispatchOnWindowAttributesChanged(@NonNull AspectFragmentActivity activity, WindowManager.LayoutParams params) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onWindowAttributesChanged(activity, params);
        }
    }

    public void dispatchOnWindowFocusChanged(@NonNull AspectFragmentActivity activity, boolean hasFocus) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onWindowFocusChanged(activity, hasFocus);
        }
    }

    public boolean dispatchOnPrepareOptionsPanel(@NonNull AspectFragmentActivity activity, View view, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsPanel(activity, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOnActivityResult(@NonNull AspectFragmentActivity activity, int requestCode, int resultCode, Intent data) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    public void dispatchOnCreate(@NonNull AspectFragmentActivity activity, @Nullable Bundle savedInstanceState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnDestroy(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onDestroy(activity);
        }
    }

    public void dispatchOnNewIntent(@NonNull AspectFragmentActivity activity, Intent intent) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onNewIntent(activity, intent);
        }
    }

    public void dispatchOnPause(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPause(activity);
        }
    }

    public void dispatchOnPostResume(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPostResume(activity);
        }
    }

    public void dispatchOnResume(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onResume(activity);
        }
    }

    public void dispatchOnResumeFragments(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onResumeFragments(activity);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState);
        }
    }

    public void dispatchOnStart(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onStart(activity);
        }
    }

    public void dispatchOnStop(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onStop(activity);
        }
    }

    public boolean dispatchOnCreatePanelMenu(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onCreatePanelMenu(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyDown(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onKeyDown(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuItemSelected(@NonNull AspectFragmentActivity activity, int featureId, MenuItem item) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onMenuItemSelected(activity, featureId, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPreparePanel(@NonNull AspectFragmentActivity activity, int featureId, View view, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            if (aspect.onPreparePanel(activity, featureId, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public Object dispatchOnRetainCustomNonConfigurationInstance(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            Object instance = aspect.onRetainCustomNonConfigurationInstance(activity);
            if (instance != null) {
                return instance;
            }
        }
        return null;
    }

    public void dispatchOnBackPressed(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onBackPressed(activity);
        }
    }

    public void dispatchOnConfigurationChanged(@NonNull AspectFragmentActivity activity, Configuration newConfig) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onConfigurationChanged(activity, newConfig);
        }
    }

    public void dispatchOnLowMemory(@NonNull AspectFragmentActivity activity) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onLowMemory(activity);
        }
    }

    public void dispatchOnPanelClosed(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
        for (SupportActivityAspect aspect : activityAspects) {
            aspect.onPanelClosed(activity, featureId, menu);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, activityAspects);
    }
}
