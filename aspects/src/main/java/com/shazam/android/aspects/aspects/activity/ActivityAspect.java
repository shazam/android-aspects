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
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectActivity} when they are listed in the
 * {@link Aspects#aspects()} parameter.
 */
public interface ActivityAspect extends Aspect<AspectActivity> {

    /**
     * @see Activity#onSaveInstanceState(Bundle, PersistableBundle)
     */
    void onSaveInstanceState(@NonNull AspectActivity activity, Bundle outState, PersistableBundle outPersistentState);

    /**
     * @see Activity#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectActivity activity, int requestCode, int resultCode, Intent data);

    /**
     * @see Activity#onApplyThemeResource(Resources.Theme, int, boolean)
     */
    void onApplyThemeResource(@NonNull AspectActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    /**
     * @see Activity#onChildTitleChanged(Activity, CharSequence)
     */
    void onChildTitleChanged(@NonNull AspectActivity activity, Activity childActivity, CharSequence title);

    /**
     * @see Activity#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState);

    /**
     * @see Activity#onDestroy()
     */
    void onDestroy(@NonNull AspectActivity activity);

    /**
     * @see Activity#onNewIntent(Intent)
     */
    void onNewIntent(@NonNull AspectActivity activity, Intent intent);

    /**
     * @see Activity#onPause()
     */
    void onPause(@NonNull AspectActivity activity);

    /**
     * @see Activity#onPostCreate(Bundle)
     */
    void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState);

    /**
     * @see Activity#onPostResume()
     */
    void onPostResume(@NonNull AspectActivity activity);

    /**
     * @see Activity#onRestart()
     */
    void onRestart(@NonNull AspectActivity activity);

    /**
     * @see Activity#onRestoreInstanceState(Bundle)
     */
    void onRestoreInstanceState(@NonNull AspectActivity activity, @NonNull Bundle savedInstanceState);

    /**
     * @see Activity#onResume()
     */
    void onResume(@NonNull AspectActivity activity);

    /**
     * @see Activity#onSaveInstanceState(Bundle, PersistableBundle)
     */
    void onSaveInstanceState(@NonNull AspectActivity activity, @NonNull Bundle outState);

    /**
     * @see Activity#onStart()
     */
    void onStart(@NonNull AspectActivity activity);

    /**
     * @see Activity#onStop()
     */
    void onStop(@NonNull AspectActivity activity);

    /**
     * @see Activity#onTitleChanged(CharSequence, int)
     */
    void onTitleChanged(@NonNull AspectActivity activity, CharSequence title, int color);

    /**
     * @see Activity#onUserLeaveHint()
     */
    void onUserLeaveHint(@NonNull AspectActivity activity);

    /**
     * @see Activity#onWindowStartingActionMode(ActionMode.Callback)
     */
    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectActivity activity, ActionMode.Callback callback);

    /**
     * @see Activity#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectActivity activity, MenuItem item);

    /**
     * @see Activity#onCreateOptionsMenu(Menu)
     */
    boolean onCreateOptionsMenu(@NonNull AspectActivity activity, Menu menu);

    /**
     * @see Activity#onCreatePanelMenu(int, Menu)
     */
    boolean onCreatePanelMenu(@NonNull AspectActivity activity, int featureId, Menu menu);

    /**
     * @see Activity#onCreateThumbnail(Bitmap, Canvas)
     */
    boolean onCreateThumbnail(@NonNull AspectActivity activity, Bitmap outBitmap, Canvas canvas);

    /**
     * @see Activity#onGenericMotionEvent(MotionEvent)
     */
    boolean onGenericMotionEvent(@NonNull AspectActivity activity, MotionEvent event);

    /**
     * @see Activity#onKeyDown(int, KeyEvent)
     */
    boolean onKeyDown(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event);

    /**
     * @see Activity#onKeyLongPress(int, KeyEvent)
     */
    boolean onKeyLongPress(@NonNull AspectActivity activity, int keyCode, KeyEvent event);

    /**
     * @see Activity#onKeyMultiple(int, int, KeyEvent)
     */
    boolean onKeyMultiple(@NonNull AspectActivity activity, int keyCode, int repeatCount, KeyEvent event);

    /**
     * @see Activity#onKeyShortcut(int, KeyEvent)
     */
    boolean onKeyShortcut(@NonNull AspectActivity activity, int keyCode, KeyEvent event);

    /**
     * @see Activity#onKeyUp(int, KeyEvent)
     */
    boolean onKeyUp(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event);

    /**
     * @see Activity#onMenuItemSelected(int, MenuItem)
     */
    boolean onMenuItemSelected(@NonNull AspectActivity activity, int featureId, @NonNull MenuItem item);

    /**
     * @see Activity#onMenuOpened(int, Menu)
     */
    boolean onMenuOpened(@NonNull AspectActivity activity, int featureId, Menu menu);

    /**
     * @see Activity#onNavigateUp()
     */
    boolean onNavigateUp(@NonNull AspectActivity activity);

    /**
     * @see Activity#onNavigateUpFromChild(Activity)
     */
    boolean onNavigateUpFromChild(@NonNull AspectActivity activity, Activity child);

    /**
     * @see Activity#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectActivity activity, MenuItem item);

    /**
     * @see Activity#onPrepareOptionsMenu(Menu)
     */
    boolean onPrepareOptionsMenu(@NonNull AspectActivity activity, Menu menu);

    /**
     * @see Activity#onPreparePanel(int, View, Menu)
     */
    boolean onPreparePanel(@NonNull AspectActivity activity, int featureId, View view, Menu menu);

    /**
     * @see Activity#onSearchRequested()
     */
    boolean onSearchRequested(@NonNull AspectActivity activity);

    /**
     * @see Activity#onTouchEvent(MotionEvent)
     */
    boolean onTouchEvent(@NonNull AspectActivity activity, MotionEvent event);

    /**
     * @see Activity#onTrackballEvent(MotionEvent)
     */
    boolean onTrackballEvent(@NonNull AspectActivity activity, MotionEvent event);

    /**
     * @see Activity#onCreateDescription()
     */
    @Nullable
    CharSequence onCreateDescription(@NonNull AspectActivity activity);

    /**
     * @see Activity#onCreatePanelView(int)
     */
    @Nullable
    View onCreatePanelView(@NonNull AspectActivity activity, int featureId);

    /**
     * @see Activity#onCreateView(String, Context, AttributeSet)
     */
    @Nullable
    View onCreateView(@NonNull AspectActivity activity, String name, Context context, AttributeSet attrs);

    /**
     * @see Activity#onCreateView(View, String, Context, AttributeSet)
     */
    View onCreateView(@NonNull AspectActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    /**
     * @see Activity#onActionModeFinished(ActionMode)
     */
    void onActionModeFinished(@NonNull AspectActivity activity, ActionMode mode);

    /**
     * @see Activity#onActionModeStarted(ActionMode)
     */
    void onActionModeStarted(@NonNull AspectActivity activity, ActionMode mode);

    /**
     * @see Activity#onActivityReenter(int, Intent)
     */
    void onActivityReenter(@NonNull AspectActivity activity, int resultCode, Intent data);

    /**
     * @see Activity#onAttachedToWindow()
     */
    void onAttachedToWindow(@NonNull AspectActivity activity);

    /**
     * @see Activity#onAttachFragment(Fragment)
     */
    void onAttachFragment(@NonNull AspectActivity activity, Fragment fragment);

    /**
     * @see Activity#onBackPressed()
     */
    void onBackPressed(@NonNull AspectActivity activity);

    /**
     * @see Activity#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectActivity activity, Configuration newConfig);

    /**
     * @see Activity#onContentChanged()
     */
    void onContentChanged(@NonNull AspectActivity activity);

    /**
     * @see Activity#onContextMenuClosed(Menu)
     */
    void onContextMenuClosed(@NonNull AspectActivity activity, Menu menu);

    /**
     * @see Activity#onCreate(Bundle, PersistableBundle)
     */
    void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see Activity#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see Activity#onCreateNavigateUpTaskStack(TaskStackBuilder)
     */
    void onCreateNavigateUpTaskStack(@NonNull AspectActivity activity, @NonNull TaskStackBuilder builder);

    /**
     * @see Activity#onDetachedFromWindow()
     */
    void onDetachedFromWindow(@NonNull AspectActivity activity);

    /**
     * @see Activity#onEnterAnimationComplete()
     */
    void onEnterAnimationComplete(@NonNull AspectActivity activity);

    /**
     * @see Activity#onLowMemory()
     */
    void onLowMemory(@NonNull AspectActivity activity);

    /**
     * @see Activity#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectActivity activity, Menu menu);

    /**
     * @see Activity#onPanelClosed(int, Menu)
     */
    void onPanelClosed(@NonNull AspectActivity activity, int featureId, Menu menu);

    /**
     * @see Activity#onPostCreate(Bundle, PersistableBundle)
     */
    void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see Activity#onPrepareNavigateUpTaskStack(TaskStackBuilder)
     */
    void onPrepareNavigateUpTaskStack(@NonNull AspectActivity activity, TaskStackBuilder builder);

    /**
     * @see Activity#onProvideAssistData(Bundle)
     */
    void onProvideAssistData(@NonNull AspectActivity activity, Bundle data);

    /**
     * @see Activity#onRestoreInstanceState(Bundle, PersistableBundle)
     */
    void onRestoreInstanceState(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see Activity#onTrimMemory(int)
     */
    void onTrimMemory(@NonNull AspectActivity activity, int level);

    /**
     * @see Activity#onUserInteraction()
     */
    void onUserInteraction(@NonNull AspectActivity activity);

    /**
     * @see Activity#onVisibleBehindCanceled()
     */
    void onVisibleBehindCanceled(@NonNull AspectActivity activity);

    /**
     * @see Activity#onWindowAttributesChanged(WindowManager.LayoutParams)
     */
    void onWindowAttributesChanged(@NonNull AspectActivity activity, WindowManager.LayoutParams params);

    /**
     * @see Activity#onWindowFocusChanged(boolean)
     */
    void onWindowFocusChanged(@NonNull AspectActivity activity, boolean hasFocus);

    /**
     * @see Activity#onCreateDialog(int)
     */
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectActivity activity, int id);

    /**
     * @see Activity#onCreateDialog(int, Bundle)
     */
    @Nullable
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectActivity activity, int id, Bundle args);

    /**
     * @see Activity#onPrepareDialog(int, Dialog)
     */
    @Deprecated
    void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog);

    /**
     * @see Activity#onPrepareDialog(int, Dialog, Bundle)
     */
    void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog, Bundle args);

    /**
     * @see Activity#onRetainNonConfigurationInstance()
     */
    @Deprecated
    Object onRetainNonConfigurationInstance(@NonNull AspectActivity activity);
}
