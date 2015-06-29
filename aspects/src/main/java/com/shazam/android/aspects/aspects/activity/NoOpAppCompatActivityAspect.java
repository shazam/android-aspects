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
    public void onCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onTrimMemory(@NonNull AspectAppCompatActivity activity, int level) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectAppCompatActivity activity, Configuration newConfig) {
    }

    @Override
    public void onLowMemory(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onApplyThemeResource(@NonNull AspectAppCompatActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onChildTitleChanged(@NonNull AspectAppCompatActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onRestart(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, @NonNull Bundle savedInstanceState) {
    }

    @Override
    public void onUserLeaveHint(@NonNull AspectAppCompatActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(@NonNull AspectAppCompatActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(@NonNull AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(@NonNull AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(@NonNull AspectAppCompatActivity activity, int keyCode, @NonNull KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuOpened(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(@NonNull AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(@NonNull AspectAppCompatActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(@NonNull AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(@NonNull AspectAppCompatActivity activity) {
        return null;
    }

    @Override
    public void onCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onAttachFragment(@NonNull AspectAppCompatActivity activity, Fragment fragment) {
    }

    @Override
    public void onAttachFragment(@NonNull AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment) {
    }

    @Nullable
    @Override
    public View onCreatePanelView(@NonNull AspectAppCompatActivity activity, int featureId) {
        return null;
    }

    @Override
    public View onCreateView(@NonNull AspectAppCompatActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(@NonNull AspectAppCompatActivity activity, ActionMode mode) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeStarted(@NonNull AspectAppCompatActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(@NonNull AspectAppCompatActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onContextMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, @NonNull TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu) {
    }

    @Override
    public void onPostCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(@NonNull AspectAppCompatActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onUserInteraction(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(@NonNull AspectAppCompatActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(@NonNull AspectAppCompatActivity activity, boolean hasFocus) {
    }

    @Override
    public boolean onPrepareOptionsPanel(@NonNull AspectAppCompatActivity activity, View view, Menu menu) {
        return false;
    }

    @Override
    public void onActivityResult(@NonNull AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onDestroy(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onNewIntent(@NonNull AspectAppCompatActivity activity, Intent intent) {
    }

    @Override
    public void onPause(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onPostCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onPostResume(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onResume(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onResumeFragments(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onStop(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onTitleChanged(@NonNull AspectAppCompatActivity activity, CharSequence title, int color) {
    }

    @Nullable
    @Override
    public android.support.v7.view.ActionMode onWindowStartingSupportActionMode(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onCreatePanelMenu(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onKeyDown(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onPreparePanel(@NonNull AspectAppCompatActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public boolean onSupportNavigateUp(@NonNull AspectAppCompatActivity activity) {
        return false;
    }

    @Override
    public void onContentChanged(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder) {
    }

    @Override
    public void onSupportActionModeFinished(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
    }

    @Override
    public void onSupportActionModeStarted(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode) {
    }

    @Override
    public void onSupportContentChanged(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onBackPressed(@NonNull AspectAppCompatActivity activity) {
    }

    @Override
    public void onPanelClosed(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu) {
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(@NonNull AspectAppCompatActivity activity) {
        return null;
    }

    @Override
    public Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
    }

    @NonNull
    @Override
    public Class<AspectAppCompatActivity> classActingOn() {
        return AspectAppCompatActivity.class;
    }
}
