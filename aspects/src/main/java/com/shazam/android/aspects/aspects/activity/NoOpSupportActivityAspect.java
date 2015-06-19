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

import com.shazam.android.aspects.base.activity.AspectFragmentActivity;

/**
 * This class is a no operation implementation of the {@link SupportActivityAspect} interface.
 * It allows classes to extend this instead of implementing {@link SupportActivityAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpSupportActivityAspect implements SupportActivityAspect {

    @Override
    public void onPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog, Bundle args) {
    }

    @Override
    public Dialog onCreateDialog(AspectFragmentActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(AspectFragmentActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onApplyThemeResource(AspectFragmentActivity activity, Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onChildTitleChanged(AspectFragmentActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onRestart(AspectFragmentActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onTitleChanged(AspectFragmentActivity activity, CharSequence title, int color) {
    }

    @Override
    public void onUserLeaveHint(AspectFragmentActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(AspectFragmentActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(AspectFragmentActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(AspectFragmentActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuOpened(AspectFragmentActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(AspectFragmentActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(AspectFragmentActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(AspectFragmentActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(AspectFragmentActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(AspectFragmentActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(AspectFragmentActivity activity) {
        return null;
    }

    @Nullable
    @Override
    public View onCreatePanelView(AspectFragmentActivity activity, int featureId) {
        return null;
    }

    @Override
    public View onCreateView(AspectFragmentActivity activity, View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(AspectFragmentActivity activity, ActionMode mode) {
    }

    @Override
    public View onCreateView(AspectFragmentActivity activity, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeStarted(AspectFragmentActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(AspectFragmentActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(AspectFragmentActivity activity) {
    }

    @Override
    public void onAttachFragment(AspectFragmentActivity activity, Fragment fragment) {
    }

    @Override
    public void onAttachFragment(AspectFragmentActivity activity, android.support.v4.app.Fragment fragment) {
    }

    @Override
    public void onContentChanged(AspectFragmentActivity activity) {
    }

    @Override
    public void onContextMenuClosed(AspectFragmentActivity activity, Menu menu) {
    }

    @Override
    public void onCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onCreateContextMenu(AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(AspectFragmentActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(AspectFragmentActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(AspectFragmentActivity activity, Menu menu) {
    }

    @Override
    public void onPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(AspectFragmentActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onSaveInstanceState(AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onTrimMemory(AspectFragmentActivity activity, int level) {
    }

    @Override
    public void onUserInteraction(AspectFragmentActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(AspectFragmentActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(AspectFragmentActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(AspectFragmentActivity activity, boolean hasFocus) {
    }

    @Override
    public boolean onPrepareOptionsPanel(AspectFragmentActivity activity, View view, Menu menu) {
        return false;
    }

    @Override
    public void onActivityResult(AspectFragmentActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onCreate(AspectFragmentActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy(AspectFragmentActivity activity) {
    }

    @Override
    public void onNewIntent(AspectFragmentActivity activity, Intent intent) {
    }

    @Override
    public void onPause(AspectFragmentActivity activity) {
    }

    @Override
    public void onPostResume(AspectFragmentActivity activity) {
    }

    @Override
    public void onResume(AspectFragmentActivity activity) {
    }

    @Override
    public void onResumeFragments(AspectFragmentActivity activity) {
    }

    @Override
    public void onSaveInstanceState(AspectFragmentActivity activity, Bundle outState) {
    }

    @Override
    public void onStart(AspectFragmentActivity activity) {
    }

    @Override
    public void onStop(AspectFragmentActivity activity) {
    }

    @Override
    public boolean onCreatePanelMenu(AspectFragmentActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onKeyDown(AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuItemSelected(AspectFragmentActivity activity, int featureId, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPreparePanel(AspectFragmentActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(AspectFragmentActivity activity) {
        return null;
    }

    @Override
    public void onBackPressed(AspectFragmentActivity activity) {
    }

    @Override
    public void onConfigurationChanged(AspectFragmentActivity activity, Configuration newConfig) {
    }

    @Override
    public void onLowMemory(AspectFragmentActivity activity) {
    }

    @Override
    public void onPanelClosed(AspectFragmentActivity activity, int featureId, Menu menu) {
    }

    @Override
    public Class<AspectFragmentActivity> classActingOn() {
        return AspectFragmentActivity.class;
    }
}
