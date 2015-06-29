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
import android.support.v7.app.AppCompatActivity;
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

    /**
     * @see AppCompatActivity#onCreate(Bundle, PersistableBundle)
     */
    void onCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see AppCompatActivity#onTrimMemory(int)
     */
    void onTrimMemory(@NonNull AspectAppCompatActivity activity, int level);

    /**
     * @see AppCompatActivity#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectAppCompatActivity activity, Configuration newConfig);

    /**
     * @see AppCompatActivity#onLowMemory()
     */
    void onLowMemory(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onApplyThemeResource(Resources.Theme, int, boolean)
     */
    void onApplyThemeResource(@NonNull AspectAppCompatActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    /**
     * @see AppCompatActivity#onChildTitleChanged(Activity, CharSequence)
     */
    void onChildTitleChanged(@NonNull AspectAppCompatActivity activity, Activity childActivity, CharSequence title);

    /**
     * @see AppCompatActivity#onRestart()
     */
    void onRestart(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onRestoreInstanceState(Bundle)
     */
    void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, @NonNull Bundle savedInstanceState);

    /**
     * @see AppCompatActivity#onUserLeaveHint()
     */
    void onUserLeaveHint(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onWindowStartingActionMode(ActionMode.Callback)
     */
    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectAppCompatActivity activity, ActionMode.Callback callback);

    /**
     * @see AppCompatActivity#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item);

    /**
     * @see AppCompatActivity#onCreateOptionsMenu(Menu)
     */
    boolean onCreateOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu);

    /**
     * @see AppCompatActivity#onCreateThumbnail(Bitmap, Canvas)
     */
    boolean onCreateThumbnail(@NonNull AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas);

    /**
     * @see AppCompatActivity#onGenericMotionEvent(MotionEvent)
     */
    boolean onGenericMotionEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    /**
     * @see AppCompatActivity#onKeyLongPress(int, KeyEvent)
     */
    boolean onKeyLongPress(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    /**
     * @see AppCompatActivity#onKeyMultiple(int, int, KeyEvent)
     */
    boolean onKeyMultiple(@NonNull AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event);

    /**
     * @see AppCompatActivity#onKeyShortcut(int, KeyEvent)
     */
    boolean onKeyShortcut(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    /**
     * @see AppCompatActivity#onKeyUp(int, KeyEvent)
     */
    boolean onKeyUp(@NonNull AspectAppCompatActivity activity, int keyCode, @NonNull KeyEvent event);

    /**
     * @see AppCompatActivity#onMenuOpened(int, Menu)
     */
    boolean onMenuOpened(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    /**
     * @see AppCompatActivity#onNavigateUp()
     */
    boolean onNavigateUp(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onNavigateUpFromChild(Activity)
     */
    boolean onNavigateUpFromChild(@NonNull AspectAppCompatActivity activity, Activity child);

    /**
     * @see AppCompatActivity#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item);

    /**
     * @see AppCompatActivity#onPrepareOptionsMenu(Menu)
     */
    boolean onPrepareOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu);

    /**
     * @see AppCompatActivity#onSearchRequested()
     */
    boolean onSearchRequested(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onTouchEvent(MotionEvent)
     */
    boolean onTouchEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    /**
     * @see AppCompatActivity#onTrackballEvent(MotionEvent)
     */
    boolean onTrackballEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    /**
     * @see AppCompatActivity#onCreateDescription()
     */
    @Nullable
    CharSequence onCreateDescription(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    /**
     * @see AppCompatActivity#onAttachFragment(android.support.v4.app.Fragment)
     */
    void onAttachFragment(@NonNull AspectAppCompatActivity activity, Fragment fragment);

    /**
     * @see AppCompatActivity#onAttachFragment(Fragment)
     */
    void onAttachFragment(@NonNull AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment);

    /**
     * @see AppCompatActivity#onCreatePanelView(int)
     */
    @Nullable
    View onCreatePanelView(@NonNull AspectAppCompatActivity activity, int featureId);

    /**
     * @see AppCompatActivity#onCreateView(View, String, Context, AttributeSet)
     */
    View onCreateView(@NonNull AspectAppCompatActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    /**
     * @see AppCompatActivity#onActionModeFinished(ActionMode)
     */
    void onActionModeFinished(@NonNull AspectAppCompatActivity activity, ActionMode mode);

    /**
     * @see AppCompatActivity#onCreateView(String, Context, AttributeSet)
     */
    @Nullable
    View onCreateView(@NonNull AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    /**
     * @see AppCompatActivity#onActionModeStarted(ActionMode)
     */
    void onActionModeStarted(@NonNull AspectAppCompatActivity activity, ActionMode mode);

    /**
     * @see AppCompatActivity#onActivityReenter(int, Intent)
     */
    void onActivityReenter(@NonNull AspectAppCompatActivity activity, int resultCode, Intent data);

    /**
     * @see AppCompatActivity#onAttachedToWindow()
     */
    void onAttachedToWindow(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onContextMenuClosed(Menu)
     */
    void onContextMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu);

    /**
     * @see AppCompatActivity#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see AppCompatActivity#onCreateNavigateUpTaskStack(TaskStackBuilder)
     */
    void onCreateNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, @NonNull TaskStackBuilder builder);

    /**
     * @see AppCompatActivity#onDetachedFromWindow()
     */
    void onDetachedFromWindow(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onEnterAnimationComplete()
     */
    void onEnterAnimationComplete(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu);

    /**
     * @see AppCompatActivity#onPostCreate(Bundle, PersistableBundle)
     */
    void onPostCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see AppCompatActivity#onPrepareNavigateUpTaskStack(TaskStackBuilder)
     */
    void onPrepareNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, TaskStackBuilder builder);

    /**
     * @see AppCompatActivity#onProvideAssistData(Bundle)
     */
    void onProvideAssistData(@NonNull AspectAppCompatActivity activity, Bundle data);

    /**
     * @see AppCompatActivity#onRestoreInstanceState(Bundle, PersistableBundle)
     */
    void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see AppCompatActivity#onSaveInstanceState(Bundle, PersistableBundle)
     */
    void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState);

    /**
     * @see AppCompatActivity#onUserInteraction()
     */
    void onUserInteraction(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onVisibleBehindCanceled()
     */
    void onVisibleBehindCanceled(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onWindowAttributesChanged(WindowManager.LayoutParams)
     */
    void onWindowAttributesChanged(@NonNull AspectAppCompatActivity activity, WindowManager.LayoutParams params);

    /**
     * @see AppCompatActivity#onWindowFocusChanged(boolean)
     */
    void onWindowFocusChanged(@NonNull AspectAppCompatActivity activity, boolean hasFocus);

    /**
     * @see AppCompatActivity#onPrepareOptionsPanel(View, Menu)
     */
    boolean onPrepareOptionsPanel(@NonNull AspectAppCompatActivity activity, View view, Menu menu);

    /**
     * @see AppCompatActivity#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data);

    /**
     * @see AppCompatActivity#onDestroy()
     */
    void onDestroy(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onNewIntent(Intent)
     */
    void onNewIntent(@NonNull AspectAppCompatActivity activity, Intent intent);

    /**
     * @see AppCompatActivity#onPause()
     */
    void onPause(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onPostCreate(Bundle)
     */
    void onPostCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    /**
     * @see AppCompatActivity#onPostResume()
     */
    void onPostResume(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onResume()
     */
    void onResume(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onResumeFragments()
     */
    void onResumeFragments(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState);

    /**
     * @see AppCompatActivity#onStart()
     */
    void onStart(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onStop()
     */
    void onStop(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onTitleChanged(CharSequence, int)
     */
    void onTitleChanged(@NonNull AspectAppCompatActivity activity, CharSequence title, int color);

    /**
     * @see AppCompatActivity#onWindowStartingSupportActionMode(android.support.v7.view.ActionMode.Callback)
     */
    @Nullable
    android.support.v7.view.ActionMode onWindowStartingSupportActionMode(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback);

    /**
     * @see AppCompatActivity#onCreatePanelMenu(int, Menu)
     */
    boolean onCreatePanelMenu(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    /**
     * @see AppCompatActivity#onKeyDown(int, KeyEvent)
     */
    boolean onKeyDown(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    /**
     * @see AppCompatActivity#onPreparePanel(int, View, Menu)
     */
    boolean onPreparePanel(@NonNull AspectAppCompatActivity activity, int featureId, View view, Menu menu);

    /**
     * @see AppCompatActivity#onSupportNavigateUp()
     */
    boolean onSupportNavigateUp(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onContentChanged()
     */
    void onContentChanged(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onCreateSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder)
     */
    void onCreateSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    /**
     * @see AppCompatActivity#onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder)
     */
    void onPrepareSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    /**
     * @see AppCompatActivity#onSupportActionModeFinished(android.support.v7.view.ActionMode)
     */
    void onSupportActionModeFinished(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    /**
     * @see AppCompatActivity#onSupportActionModeStarted(android.support.v7.view.ActionMode)
     */
    void onSupportActionModeStarted(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    /**
     * @see AppCompatActivity#onSupportContentChanged()
     */
    @Deprecated
    void onSupportContentChanged(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onBackPressed()
     */
    void onBackPressed(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onPanelClosed(int, Menu)
     */
    void onPanelClosed(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    /**
     * @see AppCompatActivity#onRetainCustomNonConfigurationInstance()
     */
    Object onRetainCustomNonConfigurationInstance(@NonNull AspectAppCompatActivity activity);

    /**
     * @see AppCompatActivity#onCreateDialog(int)
     */
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id);

    /**
     * @see AppCompatActivity#onCreateDialog(int, Bundle)
     */
    @Nullable
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id, Bundle args);

    /**
     * @see AppCompatActivity#onPrepareDialog(int, Dialog)
     */
    @Deprecated
    void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog);

    /**
     * @see AppCompatActivity#onPrepareDialog(int, Dialog, Bundle)
     */
    @Deprecated
    void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog, Bundle args);
}
