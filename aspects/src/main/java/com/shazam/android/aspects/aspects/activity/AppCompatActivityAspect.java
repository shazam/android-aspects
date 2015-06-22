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

import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.base.activity.AspectAppCompatActivity;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectAppCompatActivity} when they are listed in the
 * {@link Aspects#aspects()} parameter.
 */
public interface AppCompatActivityAspect extends Aspect<AspectAppCompatActivity> {

    void onCreate(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onTrimMemory(AspectAppCompatActivity activity, int level);

    void onConfigurationChanged(AspectAppCompatActivity activity, Configuration newConfig);

    void onLowMemory(AspectAppCompatActivity activity);

    void onApplyThemeResource(AspectAppCompatActivity activity, Resources.Theme theme, int resid, boolean first);

    void onChildTitleChanged(AspectAppCompatActivity activity, Activity childActivity, CharSequence title);

    void onRestart(AspectAppCompatActivity activity);

    void onRestoreInstanceState(AspectAppCompatActivity activity, Bundle savedInstanceState);

    void onUserLeaveHint(AspectAppCompatActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(AspectAppCompatActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(AspectAppCompatActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(AspectAppCompatActivity activity, Menu menu);

    boolean onCreateThumbnail(AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(AspectAppCompatActivity activity, MotionEvent event);

    boolean onKeyLongPress(AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onMenuOpened(AspectAppCompatActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(AspectAppCompatActivity activity);

    boolean onNavigateUpFromChild(AspectAppCompatActivity activity, Activity child);

    boolean onOptionsItemSelected(AspectAppCompatActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(AspectAppCompatActivity activity, Menu menu);

    boolean onSearchRequested(AspectAppCompatActivity activity);

    boolean onTouchEvent(AspectAppCompatActivity activity, MotionEvent event);

    boolean onTrackballEvent(AspectAppCompatActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(AspectAppCompatActivity activity);

    void onCreate(AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    void onAttachFragment(AspectAppCompatActivity activity, Fragment fragment);

    void onAttachFragment(AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment);

    @Nullable
    View onCreatePanelView(AspectAppCompatActivity activity, int featureId);

    View onCreateView(AspectAppCompatActivity activity, View parent, String name, Context context, AttributeSet attrs);

    void onActionModeFinished(AspectAppCompatActivity activity, ActionMode mode);

    @Nullable
    View onCreateView(AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeStarted(AspectAppCompatActivity activity, ActionMode mode);

    void onActivityReenter(AspectAppCompatActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(AspectAppCompatActivity activity);

    void onContextMenuClosed(AspectAppCompatActivity activity, Menu menu);

    void onCreateContextMenu(AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(AspectAppCompatActivity activity, TaskStackBuilder builder);

    void onDetachedFromWindow(AspectAppCompatActivity activity);

    void onEnterAnimationComplete(AspectAppCompatActivity activity);

    void onOptionsMenuClosed(AspectAppCompatActivity activity, Menu menu);

    void onPostCreate(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(AspectAppCompatActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(AspectAppCompatActivity activity, Bundle data);

    void onRestoreInstanceState(AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onSaveInstanceState(AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onUserInteraction(AspectAppCompatActivity activity);

    void onVisibleBehindCanceled(AspectAppCompatActivity activity);

    void onWindowAttributesChanged(AspectAppCompatActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(AspectAppCompatActivity activity, boolean hasFocus);

    boolean onPrepareOptionsPanel(AspectAppCompatActivity activity, View view, Menu menu);

    void onActivityResult(AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data);

    void onDestroy(AspectAppCompatActivity activity);

    void onNewIntent(AspectAppCompatActivity activity, Intent intent);

    void onPause(AspectAppCompatActivity activity);

    void onPostCreate(AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    void onPostResume(AspectAppCompatActivity activity);

    void onResume(AspectAppCompatActivity activity);

    void onResumeFragments(AspectAppCompatActivity activity);

    void onSaveInstanceState(AspectAppCompatActivity activity, Bundle outState);

    void onStart(AspectAppCompatActivity activity);

    void onStop(AspectAppCompatActivity activity);

    void onTitleChanged(AspectAppCompatActivity activity, CharSequence title, int color);

    @Nullable
    android.support.v7.view.ActionMode onWindowStartingSupportActionMode(AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback);

    boolean onCreatePanelMenu(AspectAppCompatActivity activity, int featureId, Menu menu);

    boolean onKeyDown(AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onPreparePanel(AspectAppCompatActivity activity, int featureId, View view, Menu menu);

    boolean onSupportNavigateUp(AspectAppCompatActivity activity);

    void onContentChanged(AspectAppCompatActivity activity);

    void onCreateSupportNavigateUpTaskStack(AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    void onPrepareSupportNavigateUpTaskStack(AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    void onSupportActionModeFinished(AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    void onSupportActionModeStarted(AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    void onSupportContentChanged(AspectAppCompatActivity activity);

    void onBackPressed(AspectAppCompatActivity activity);

    void onPanelClosed(AspectAppCompatActivity activity, int featureId, Menu menu);

    Object onRetainCustomNonConfigurationInstance(AspectAppCompatActivity activity);

    Dialog onCreateDialog(AspectAppCompatActivity activity, int id);

    @Nullable
    Dialog onCreateDialog(AspectAppCompatActivity activity, int id, Bundle args);

    void onPrepareDialog(AspectAppCompatActivity activity, int id, Dialog dialog);

    void onPrepareDialog(AspectAppCompatActivity activity, int id, Dialog dialog, Bundle args);
}
