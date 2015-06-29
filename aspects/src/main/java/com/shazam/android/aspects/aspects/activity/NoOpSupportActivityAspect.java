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

import com.shazam.android.aspects.base.activity.AspectFragmentActivity;

/**
 * This class is a no operation implementation of the {@link SupportActivityAspect} interface.
 * It allows classes to extend this instead of implementing {@link SupportActivityAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpSupportActivityAspect implements SupportActivityAspect {

    @Override
    public void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog) {
    }

    @Override
    public void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog, Bundle args) {
    }

    @Override
    public Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id) {
        return null;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id, Bundle args) {
        return null;
    }

    @Override
    public void onApplyThemeResource(@NonNull AspectFragmentActivity activity, @NonNull Resources.Theme theme, int resid, boolean first) {
    }

    @Override
    public void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onChildTitleChanged(@NonNull AspectFragmentActivity activity, Activity childActivity, CharSequence title) {
    }

    @Override
    public void onRestart(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, @NonNull Bundle savedInstanceState) {
    }

    @Override
    public void onTitleChanged(@NonNull AspectFragmentActivity activity, CharSequence title, int color) {
    }

    @Override
    public void onUserLeaveHint(@NonNull AspectFragmentActivity activity) {
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(@NonNull AspectFragmentActivity activity, ActionMode.Callback callback) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateThumbnail(@NonNull AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(@NonNull AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(@NonNull AspectFragmentActivity activity, int keyCode, @NonNull KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuOpened(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onNavigateUp(@NonNull AspectFragmentActivity activity) {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(@NonNull AspectFragmentActivity activity, Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu) {
        return false;
    }

    @Override
    public boolean onSearchRequested(@NonNull AspectFragmentActivity activity) {
        return false;
    }

    @Override
    public boolean onTouchEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(@NonNull AspectFragmentActivity activity, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription(@NonNull AspectFragmentActivity activity) {
        return null;
    }

    @Nullable
    @Override
    public View onCreatePanelView(@NonNull AspectFragmentActivity activity, int featureId) {
        return null;
    }

    @Override
    public View onCreateView(@NonNull AspectFragmentActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeFinished(@NonNull AspectFragmentActivity activity, ActionMode mode) {
    }

    @Override
    public View onCreateView(@NonNull AspectFragmentActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
    }

    @Override
    public void onActionModeStarted(@NonNull AspectFragmentActivity activity, ActionMode mode) {
    }

    @Override
    public void onActivityReenter(@NonNull AspectFragmentActivity activity, int resultCode, Intent data) {
    }

    @Override
    public void onAttachedToWindow(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onAttachFragment(@NonNull AspectFragmentActivity activity, Fragment fragment) {
    }

    @Override
    public void onAttachFragment(@NonNull AspectFragmentActivity activity, android.support.v4.app.Fragment fragment) {
    }

    @Override
    public void onContentChanged(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onContextMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu) {
    }

    @Override
    public void onCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, @NonNull TaskStackBuilder builder) {
    }

    @Override
    public void onDetachedFromWindow(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onEnterAnimationComplete(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu) {
    }

    @Override
    public void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onPrepareNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, TaskStackBuilder builder) {
    }

    @Override
    public void onProvideAssistData(@NonNull AspectFragmentActivity activity, Bundle data) {
    }

    @Override
    public void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState) {
    }

    @Override
    public void onTrimMemory(@NonNull AspectFragmentActivity activity, int level) {
    }

    @Override
    public void onUserInteraction(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onVisibleBehindCanceled(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onWindowAttributesChanged(@NonNull AspectFragmentActivity activity, WindowManager.LayoutParams params) {
    }

    @Override
    public void onWindowFocusChanged(@NonNull AspectFragmentActivity activity, boolean hasFocus) {
    }

    @Override
    public boolean onPrepareOptionsPanel(@NonNull AspectFragmentActivity activity, View view, Menu menu) {
        return false;
    }

    @Override
    public void onActivityResult(@NonNull AspectFragmentActivity activity, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onCreate(@NonNull AspectFragmentActivity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onNewIntent(@NonNull AspectFragmentActivity activity, Intent intent) {
    }

    @Override
    public void onPause(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onPostResume(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onResume(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onResumeFragments(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onStop(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public boolean onCreatePanelMenu(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
        return false;
    }

    @Override
    public boolean onKeyDown(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onMenuItemSelected(@NonNull AspectFragmentActivity activity, int featureId, MenuItem item) {
        return false;
    }

    @Override
    public boolean onPreparePanel(@NonNull AspectFragmentActivity activity, int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance(@NonNull AspectFragmentActivity activity) {
        return null;
    }

    @Override
    public void onBackPressed(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectFragmentActivity activity, Configuration newConfig) {
    }

    @Override
    public void onLowMemory(@NonNull AspectFragmentActivity activity) {
    }

    @Override
    public void onPanelClosed(@NonNull AspectFragmentActivity activity, int featureId, Menu menu) {
    }

    @NonNull
    @Override
    public Class<AspectFragmentActivity> classActingOn() {
        return AspectFragmentActivity.class;
    }
}
