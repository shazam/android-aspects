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
package com.shazam.android.aspects.aspects.activity;

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

import com.shazam.android.aspects.base.activity.AspectActivity;

/**
 * This class is a no operation implementation of the {@link ActivityAspect} interface.
 * It allows classes to extend this instead of implementing {@link ActivityAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpActivityAspect implements ActivityAspect {

    @Override
    public void onSaveInstanceState(AspectActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onActivityResult(AspectActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onApplyThemeResource(AspectActivity activity, Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onChildTitleChanged(AspectActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onCreate(AspectActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy(AspectActivity activity) {
    }

    @Override
    public void onNewIntent(AspectActivity activity, Intent intent) {
    }

    @Override
    public void onPause(AspectActivity activity) {
    }

    @Override
    public void onPostCreate(AspectActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onPostResume(AspectActivity activity) {
    }

    @Override
    public void onRestart(AspectActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(AspectActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onResume(AspectActivity activity) {
    }

    @Override
    public void onSaveInstanceState(AspectActivity activity, Bundle outState) {
    }

    @Override
    public void onStart(AspectActivity activity) {
    }

    @Override
    public void onStop(AspectActivity activity) {
    }

    @Override
    public void onTitleChanged(AspectActivity activity, CharSequence title, int color) {
    }

    @Override
    public void onUserLeaveHint(AspectActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(AspectActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(AspectActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(AspectActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreatePanelMenu(AspectActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(AspectActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyDown(AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(AspectActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuItemSelected(AspectActivity activity, int featureId, MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuOpened(AspectActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(AspectActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(AspectActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(AspectActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(AspectActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onPreparePanel(AspectActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(AspectActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(AspectActivity activity) {
        return null;
    }

    @Nullable
    @Override
    public View onCreatePanelView(AspectActivity activity, int featureId) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(AspectActivity activity, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(AspectActivity activity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(AspectActivity activity, ActionMode mode) {
    }

    @Override
    public void onActionModeStarted(AspectActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(AspectActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(AspectActivity activity) {
    }

    @Override
    public void onAttachFragment(AspectActivity activity, Fragment fragment) {
    }

    @Override
    public void onBackPressed(AspectActivity activity) {
    }

    @Override
    public void onConfigurationChanged(AspectActivity activity, Configuration newConfig) {
    }

    @Override
    public void onContentChanged(AspectActivity activity) {
    }

    @Override
    public void onContextMenuClosed(AspectActivity activity, Menu menu) {
    }

    @Override
    public void onCreate(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onCreateContextMenu(AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(AspectActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(AspectActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(AspectActivity activity) {
    }

    @Override
    public void onLowMemory(AspectActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(AspectActivity activity, Menu menu) {
    }

    @Override
    public void onPanelClosed(AspectActivity activity, int featureId, Menu menu) {
    }

    @Override
    public void onPostCreate(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(AspectActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(AspectActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onTrimMemory(AspectActivity activity, int level) {
    }

    @Override
    public void onUserInteraction(AspectActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(AspectActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(AspectActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(AspectActivity activity, boolean hasFocus) {
    }

    @Override
    public Dialog onCreateDialog(AspectActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(AspectActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onPrepareDialog(AspectActivity activity, int id, Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(AspectActivity activity, int id, Dialog dialog, Bundle args) {
    }

    @Override
    public Object onRetainNonConfigurationInstance(AspectActivity activity) {
        return null;
    }

    @Override
    public Class<AspectActivity> classActingOn() {
        return AspectActivity.class;
    }
}
