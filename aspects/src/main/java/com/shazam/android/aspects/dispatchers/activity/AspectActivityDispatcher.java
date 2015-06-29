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
import com.shazam.android.aspects.base.activity.AspectActivity;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.activity.ActivityAspect;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

/**
 * This dispatcher holds a list of {@link ActivityAspect}s and delegates all the lifecycle calls 
 * to them.
 */
public class AspectActivityDispatcher {

    private Collection<ActivityAspect> activityAspects;

    public AspectActivityDispatcher(AspectsProvider<ActivityAspect> aspectsProvider) {
        this.activityAspects = aspectsProvider.getAspects();
    }

    public static AspectActivityDispatcher create(@NonNull AspectActivity activity) {
        return new AspectActivityDispatcher(providerFor(activity));
    }

    private static AspectsProvider<ActivityAspect> providerFor(@NonNull AspectActivity activity) {
        return annotatedAspectsFrom(activity, ActivityAspect.class, AspectActivity.class);
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectActivity activity, Bundle outState, PersistableBundle outPersistentState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState, outPersistentState);
        }
    }

    public void dispatchOnActivityResult(@NonNull AspectActivity activity, int requestCode, int resultCode, Intent data) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    public void dispatchOnApplyThemeResource(@NonNull AspectActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onApplyThemeResource(activity, theme, resid, first);
        }
    }

    public void dispatchOnChildTitleChanged(@NonNull AspectActivity activity, Activity childActivity, CharSequence title) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onChildTitleChanged(activity, childActivity, title);
        }
    }

    public void dispatchOnCreate(@NonNull AspectActivity activity, Bundle savedInstanceState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnDestroy(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onDestroy(activity);
        }
    }

    public void dispatchOnNewIntent(@NonNull AspectActivity activity, Intent intent) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onNewIntent(activity, intent);
        }
    }

    public void dispatchOnPause(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPause(activity);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState);
        }
    }

    public void dispatchOnPostResume(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPostResume(activity);
        }
    }

    public void dispatchOnRestart(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onRestart(activity);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectActivity activity, @NonNull Bundle savedInstanceState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState);
        }
    }

    public void dispatchOnResume(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onResume(activity);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectActivity activity, @NonNull Bundle outState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onSaveInstanceState(activity, outState);
        }
    }

    public void dispatchOnStart(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onStart(activity);
        }
    }

    public void dispatchOnStop(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onStop(activity);
        }
    }

    public void dispatchOnTitleChanged(@NonNull AspectActivity activity, CharSequence title, int color) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onTitleChanged(activity, title, color);
        }
    }

    public void dispatchOnUserLeaveHint(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onUserLeaveHint(activity);
        }
    }

    @Nullable
    public ActionMode dispatchOnWindowStartingActionMode(@NonNull AspectActivity activity, ActionMode.Callback callback) {
        for (ActivityAspect aspect : activityAspects) {
            ActionMode actionMode = aspect.onWindowStartingActionMode(activity, callback);
            if (actionMode != null) {
                return actionMode;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(@NonNull AspectActivity activity, MenuItem item) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onContextItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateOptionsMenu(@NonNull AspectActivity activity, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onCreateOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreatePanelMenu(@NonNull AspectActivity activity, int featureId, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onCreatePanelMenu(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnCreateThumbnail(@NonNull AspectActivity activity, Bitmap outBitmap, Canvas canvas) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onCreateThumbnail(activity, outBitmap, canvas)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnGenericMotionEvent(@NonNull AspectActivity activity, MotionEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onGenericMotionEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyDown(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onKeyDown(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyLongPress(@NonNull AspectActivity activity, int keyCode, KeyEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onKeyLongPress(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyMultiple(@NonNull AspectActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onKeyMultiple(activity, keyCode, repeatCount, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyShortcut(@NonNull AspectActivity activity, int keyCode, KeyEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onKeyShortcut(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnKeyUp(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onKeyUp(activity, keyCode, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuItemSelected(@NonNull AspectActivity activity, int featureId, @NonNull MenuItem item) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onMenuItemSelected(activity, featureId, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnMenuOpened(@NonNull AspectActivity activity, int featureId, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onMenuOpened(activity, featureId, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUp(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUp(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnNavigateUpFromChild(@NonNull AspectActivity activity, Activity child) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onNavigateUpFromChild(activity, child)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(@NonNull AspectActivity activity, MenuItem item) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onOptionsItemSelected(activity, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPrepareOptionsMenu(@NonNull AspectActivity activity, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onPrepareOptionsMenu(activity, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnPreparePanel(@NonNull AspectActivity activity, int featureId, View view, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onPreparePanel(activity, featureId, view, menu)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnSearchRequested(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onSearchRequested(activity)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTouchEvent(@NonNull AspectActivity activity, MotionEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onTouchEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnTrackballEvent(@NonNull AspectActivity activity, MotionEvent event) {
        for (ActivityAspect aspect : activityAspects) {
            if (aspect.onTrackballEvent(activity, event)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public CharSequence dispatchOnCreateDescription(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            CharSequence description = aspect.onCreateDescription(activity);
            if (description != null) {
                return description;
            }
        }
        return null;
    }

    @Nullable
    public View dispatchOnCreatePanelView(@NonNull AspectActivity activity, int featureId) {
        for (ActivityAspect aspect : activityAspects) {
            View panelView = aspect.onCreatePanelView(activity, featureId);
            if (panelView != null) {
                return panelView;
            }
        }
        return null;
    }

    @Nullable
    public View dispatchOnCreateView(@NonNull AspectActivity activity, String name, Context context, AttributeSet attrs) {
        for (ActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public View dispatchOnCreateView(@NonNull AspectActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        for (ActivityAspect aspect : activityAspects) {
            View view = aspect.onCreateView(activity, parent, name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActionModeFinished(@NonNull AspectActivity activity, ActionMode mode) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onActionModeFinished(activity, mode);
        }
    }

    public void dispatchOnActionModeStarted(@NonNull AspectActivity activity, ActionMode mode) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onActionModeStarted(activity, mode);
        }
    }

    public void dispatchOnActivityReenter(@NonNull AspectActivity activity, int resultCode, Intent data) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onActivityReenter(activity, resultCode, data);
        }
    }

    public void dispatchOnAttachedToWindow(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onAttachedToWindow(activity);
        }
    }

    public void dispatchOnAttachFragment(@NonNull AspectActivity activity, Fragment fragment) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onAttachFragment(activity, fragment);
        }
    }

    public void dispatchOnBackPressed(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onBackPressed(activity);
        }
    }

    public void dispatchOnConfigurationChanged(@NonNull AspectActivity activity, Configuration newConfig) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onConfigurationChanged(activity, newConfig);
        }
    }

    public void dispatchOnContentChanged(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onContentChanged(activity);
        }
    }

    public void dispatchOnContextMenuClosed(@NonNull AspectActivity activity, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onContextMenuClosed(activity, menu);
        }
    }

    public void dispatchOnCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnCreateContextMenu(@NonNull AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onCreateContextMenu(activity, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateNavigateUpTaskStack(@NonNull AspectActivity activity, @NonNull TaskStackBuilder builder) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onCreateNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnDetachedFromWindow(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onDetachedFromWindow(activity);
        }
    }

    public void dispatchOnEnterAnimationComplete(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onEnterAnimationComplete(activity);
        }
    }

    public void dispatchOnLowMemory(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onLowMemory(activity);
        }
    }

    public void dispatchOnOptionsMenuClosed(@NonNull AspectActivity activity, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onOptionsMenuClosed(activity, menu);
        }
    }

    public void dispatchOnPanelClosed(@NonNull AspectActivity activity, int featureId, Menu menu) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPanelClosed(activity, featureId, menu);
        }
    }

    public void dispatchOnPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPostCreate(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnPrepareNavigateUpTaskStack(@NonNull AspectActivity activity, TaskStackBuilder builder) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPrepareNavigateUpTaskStack(activity, builder);
        }
    }

    public void dispatchOnProvideAssistData(@NonNull AspectActivity activity, Bundle data) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onProvideAssistData(activity, data);
        }
    }

    public void dispatchOnRestoreInstanceState(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    public void dispatchOnTrimMemory(@NonNull AspectActivity activity, int level) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onTrimMemory(activity, level);
        }
    }

    public void dispatchOnUserInteraction(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onUserInteraction(activity);
        }
    }

    public void dispatchOnVisibleBehindCanceled(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onVisibleBehindCanceled(activity);
        }
    }

    public void dispatchOnWindowAttributesChanged(@NonNull AspectActivity activity, WindowManager.LayoutParams params) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onWindowAttributesChanged(activity, params);
        }
    }

    public void dispatchOnWindowFocusChanged(@NonNull AspectActivity activity, boolean hasFocus) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onWindowFocusChanged(activity, hasFocus);
        }
    }

    public Dialog dispatchOnCreateDialog(@NonNull AspectActivity activity, int id) {
        for (ActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    @Nullable
    public Dialog dispatchOnCreateDialog(@NonNull AspectActivity activity, int id, Bundle args) {
        for (ActivityAspect aspect : activityAspects) {
            Dialog dialog = aspect.onCreateDialog(activity, id, args);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    public void dispatchOnPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog);
        }
    }

    public void dispatchOnPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
        for (ActivityAspect aspect : activityAspects) {
            aspect.onPrepareDialog(activity, id, dialog, args);
        }
    }

    public Object dispatchOnRetainNonConfigurationInstance(@NonNull AspectActivity activity) {
        for (ActivityAspect aspect : activityAspects) {
            Object instance = aspect.onRetainNonConfigurationInstance(activity);
            if (instance != null) {
                return instance;
            }
        }
        return null;
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, activityAspects);
    }
}
