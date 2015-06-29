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

import com.shazam.android.aspects.base.activity.AspectActivity;

/**
 * This class is a no operation implementation of the {@link ActivityAspect} interface.
 * It allows classes to extend this instead of implementing {@link ActivityAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpActivityAspect implements ActivityAspect {

    @Override
    public void onSaveInstanceState(@NonNull AspectActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onActivityResult(@NonNull AspectActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onApplyThemeResource(@NonNull AspectActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onChildTitleChanged(@NonNull AspectActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy(@NonNull AspectActivity activity) {
    }

    @Override
    public void onNewIntent(@NonNull AspectActivity activity, Intent intent) {
    }

    @Override
    public void onPause(@NonNull AspectActivity activity) {
    }

    @Override
    public void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onPostResume(@NonNull AspectActivity activity) {
    }

    @Override
    public void onRestart(@NonNull AspectActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectActivity activity, @NonNull Bundle savedInstanceState) {
    }

    @Override
    public void onResume(@NonNull AspectActivity activity) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectActivity activity, @NonNull Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectActivity activity) {
    }

    @Override
    public void onStop(@NonNull AspectActivity activity) {
    }

    @Override
    public void onTitleChanged(@NonNull AspectActivity activity, CharSequence title, int color) {
    }

    @Override
    public void onUserLeaveHint(@NonNull AspectActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(@NonNull AspectActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull AspectActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreatePanelMenu(@NonNull AspectActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(@NonNull AspectActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(@NonNull AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyDown(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(@NonNull AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(@NonNull AspectActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(@NonNull AspectActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuItemSelected(@NonNull AspectActivity activity, int featureId, @NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuOpened(@NonNull AspectActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(@NonNull AspectActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(@NonNull AspectActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(@NonNull AspectActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onPreparePanel(@NonNull AspectActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(@NonNull AspectActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(@NonNull AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(@NonNull AspectActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(@NonNull AspectActivity activity) {
        return null;
    }

    @Nullable
    @Override
    public View onCreatePanelView(@NonNull AspectActivity activity, int featureId) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull AspectActivity activity, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(@NonNull AspectActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(@NonNull AspectActivity activity, ActionMode mode) {
    }

    @Override
    public void onActionModeStarted(@NonNull AspectActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(@NonNull AspectActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(@NonNull AspectActivity activity) {
    }

    @Override
    public void onAttachFragment(@NonNull AspectActivity activity, Fragment fragment) {
    }

    @Override
    public void onBackPressed(@NonNull AspectActivity activity) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectActivity activity, Configuration newConfig) {
    }

    @Override
    public void onContentChanged(@NonNull AspectActivity activity) {
    }

    @Override
    public void onContextMenuClosed(@NonNull AspectActivity activity, Menu menu) {
    }

    @Override
    public void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(@NonNull AspectActivity activity, @NonNull TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(@NonNull AspectActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(@NonNull AspectActivity activity) {
    }

    @Override
    public void onLowMemory(@NonNull AspectActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectActivity activity, Menu menu) {
    }

    @Override
    public void onPanelClosed(@NonNull AspectActivity activity, int featureId, Menu menu) {
    }

    @Override
    public void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(@NonNull AspectActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(@NonNull AspectActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onTrimMemory(@NonNull AspectActivity activity, int level) {
    }

    @Override
    public void onUserInteraction(@NonNull AspectActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(@NonNull AspectActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(@NonNull AspectActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(@NonNull AspectActivity activity, boolean hasFocus) {
    }

    @Override
    @Deprecated
    public Dialog onCreateDialog(@NonNull AspectActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    @Deprecated
    public Dialog onCreateDialog(@NonNull AspectActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    @Deprecated
    public void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
    }

    @Override
    @Deprecated
    public Object onRetainNonConfigurationInstance(@NonNull AspectActivity activity) {
        return null;
    }

    @NonNull
    @Override
    public Class<AspectActivity> classActingOn() {
        return AspectActivity.class;
    }
}
