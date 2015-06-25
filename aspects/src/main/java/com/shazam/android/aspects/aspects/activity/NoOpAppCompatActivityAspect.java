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

import com.shazam.android.aspects.base.activity.AspectAppCompatActivity;

/**
 * This class is a no operation implementation of the {@link AppCompatActivityAspect} interface.
 * It allows classes to extend this instead of implementing {@link AppCompatActivityAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpAppCompatActivityAspect implements AppCompatActivityAspect {
    @Override
    public void onCreate(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onTrimMemory(AspectAppCompatActivity activity, int level) {
    }

    @Override
    public void onConfigurationChanged(AspectAppCompatActivity activity, Configuration newConfig) {
    }

    @Override
    public void onLowMemory(AspectAppCompatActivity activity) {
    }

    @Override
    public void onApplyThemeResource(AspectAppCompatActivity activity, Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onChildTitleChanged(AspectAppCompatActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onRestart(AspectAppCompatActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(AspectAppCompatActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onUserLeaveHint(AspectAppCompatActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(AspectAppCompatActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(AspectAppCompatActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(AspectAppCompatActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuOpened(AspectAppCompatActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(AspectAppCompatActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(AspectAppCompatActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(AspectAppCompatActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(AspectAppCompatActivity activity) {
        return null;
    }

    @Override
    public void onCreate(AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onAttachFragment(AspectAppCompatActivity activity, Fragment fragment) {
    }

    @Override
    public void onAttachFragment(AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment) {
    }

    @Nullable
    @Override
    public View onCreatePanelView(AspectAppCompatActivity activity, int featureId) {
        return null;
    }

    @Override
    public View onCreateView(AspectAppCompatActivity activity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(AspectAppCompatActivity activity, ActionMode mode) {
    }

    @Nullable
    @Override
    public View onCreateView(AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeStarted(AspectAppCompatActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(AspectAppCompatActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(AspectAppCompatActivity activity) {
    }

    @Override
    public void onContextMenuClosed(AspectAppCompatActivity activity, Menu menu) {
    }

    @Override
    public void onCreateContextMenu(AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(AspectAppCompatActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(AspectAppCompatActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(AspectAppCompatActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(AspectAppCompatActivity activity, Menu menu) {
    }

    @Override
    public void onPostCreate(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(AspectAppCompatActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(AspectAppCompatActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onSaveInstanceState(AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onUserInteraction(AspectAppCompatActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(AspectAppCompatActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(AspectAppCompatActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(AspectAppCompatActivity activity, boolean hasFocus) {
    }

    @Override
    public boolean onPrepareOptionsPanel(AspectAppCompatActivity activity, View view, Menu menu) {
        return false;
    }

    @Override
    public void onActivityResult(AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onDestroy(AspectAppCompatActivity activity) {
    }

    @Override
    public void onNewIntent(AspectAppCompatActivity activity, Intent intent) {
    }

    @Override
    public void onPause(AspectAppCompatActivity activity) {
    }

    @Override
    public void onPostCreate(AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onPostResume(AspectAppCompatActivity activity) {
    }

    @Override
    public void onResume(AspectAppCompatActivity activity) {
    }

    @Override
    public void onResumeFragments(AspectAppCompatActivity activity) {
    }

    @Override
    public void onSaveInstanceState(AspectAppCompatActivity activity, Bundle outState) {
    }

    @Override
    public void onStart(AspectAppCompatActivity activity) {
    }

    @Override
    public void onStop(AspectAppCompatActivity activity) {
    }

    @Override
    public void onTitleChanged(AspectAppCompatActivity activity, CharSequence title, int color) {
    }

    @Nullable
    @Override
    public android.support.v7.view.ActionMode onWindowStartingSupportActionMode(AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onCreatePanelMenu(AspectAppCompatActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onKeyDown(AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onPreparePanel(AspectAppCompatActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public boolean onSupportNavigateUp(AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public void onContentChanged(AspectAppCompatActivity activity) {
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
    }

    @Override
    public void onSupportActionModeFinished(AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
    }

    @Override
    public void onSupportActionModeStarted(AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
    }

    @Override
    public void onSupportContentChanged(AspectAppCompatActivity activity) {
    }

    @Override
    public void onBackPressed(AspectAppCompatActivity activity) {
    }

    @Override
    public void onPanelClosed(AspectAppCompatActivity activity, int featureId, Menu menu) {
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(AspectAppCompatActivity activity) {
        return null;
    }

    @Override
    public Dialog onCreateDialog(AspectAppCompatActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(AspectAppCompatActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onPrepareDialog(AspectAppCompatActivity activity, int id, Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(AspectAppCompatActivity activity, int id, Dialog dialog, Bundle args) {
    }

    @Override
    public Class<AspectAppCompatActivity> classActingOn() {
        return AspectAppCompatActivity.class;
    }
}
