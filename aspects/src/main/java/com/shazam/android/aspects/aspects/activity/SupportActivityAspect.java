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
import android.support.v4.app.FragmentActivity;
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
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectFragmentActivity} when they are listed in the 
 * {@link Aspects#aspects()} parameter.
 */
public interface SupportActivityAspect extends Aspect<AspectFragmentActivity> {

    /**
     * @see FragmentActivity#onPrepareDialog(int, Dialog)
     */
    @Deprecated
    void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog);

    /**
     * @see FragmentActivity#onPrepareDialog(int, Dialog, Bundle)
     */
    @Deprecated
    void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog, Bundle args);

    /**
     * @see FragmentActivity#onCreateDialog(int)
     */
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id);

    /**
     * @see FragmentActivity#onCreateDialog(int, Bundle)
     */
    @Nullable
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id, Bundle args);

    /**
     * @see FragmentActivity#onApplyThemeResource(Resources.Theme, int, boolean)
     */
    void onApplyThemeResource(@NonNull AspectFragmentActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    /**
     * @see FragmentActivity#onPostCreate(Bundle)
     */
    void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState);

    /**
     * @see FragmentActivity#onChildTitleChanged(Activity, CharSequence)
     */
    void onChildTitleChanged(@NonNull AspectFragmentActivity activity, Activity childActivity, CharSequence title);

    /**
     * @see FragmentActivity#onRestart()
     */
    void onRestart(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onRestoreInstanceState(Bundle)
     */
    void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, @NonNull Bundle savedInstanceState);

    /**
     * @see FragmentActivity#onTitleChanged(CharSequence, int)
     */
    void onTitleChanged(@NonNull AspectFragmentActivity activity, CharSequence title, int color);

    /**
     * @see FragmentActivity#onUserLeaveHint()
     */
    void onUserLeaveHint(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onWindowStartingActionMode(ActionMode.Callback)
     */
    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectFragmentActivity activity, ActionMode.Callback callback);

    /**
     * @see FragmentActivity#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item);

    /**
     * @see FragmentActivity#onCreateOptionsMenu(Menu)
     */
    boolean onCreateOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu);

    /**
     * @see FragmentActivity#onCreateThumbnail(Bitmap, Canvas)
     */
    boolean onCreateThumbnail(@NonNull AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas);

    /**
     * @see FragmentActivity#onGenericMotionEvent(MotionEvent)
     */
    boolean onGenericMotionEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    /**
     * @see FragmentActivity#onKeyLongPress(int, KeyEvent)
     */
    boolean onKeyLongPress(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    /**
     * @see FragmentActivity#onKeyMultiple(int, int, KeyEvent)
     */
    boolean onKeyMultiple(@NonNull AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event);

    /**
     * @see FragmentActivity#onKeyShortcut(int, KeyEvent)
     */
    boolean onKeyShortcut(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    /**
     * @see FragmentActivity#onKeyUp(int, KeyEvent)
     */
    boolean onKeyUp(@NonNull AspectFragmentActivity activity, int keyCode, @NonNull KeyEvent event);

    /**
     * @see FragmentActivity#onMenuOpened(int, Menu)
     */
    boolean onMenuOpened(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);

    /**
     * @see FragmentActivity#onNavigateUp()
     */
    boolean onNavigateUp(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onNavigateUpFromChild(Activity)
     */
    boolean onNavigateUpFromChild(@NonNull AspectFragmentActivity activity, Activity child);

    /**
     * @see FragmentActivity#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item);

    /**
     * @see FragmentActivity#onPrepareOptionsMenu(Menu)
     */
    boolean onPrepareOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu);

    /**
     * @see FragmentActivity#onSearchRequested()
     */
    boolean onSearchRequested(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onTouchEvent(MotionEvent)
     */
    boolean onTouchEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    /**
     * @see FragmentActivity#onTrackballEvent(MotionEvent)
     */
    boolean onTrackballEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    /**
     * @see FragmentActivity#onCreateDescription()
     */
    @Nullable
    CharSequence onCreateDescription(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onCreatePanelView(int)
     */
    @Nullable
    View onCreatePanelView(@NonNull AspectFragmentActivity activity, int featureId);

    /**
     * @see FragmentActivity#onCreateView(View, String, Context, AttributeSet)
     */
    View onCreateView(@NonNull AspectFragmentActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    /**
     * @see FragmentActivity#onActionModeFinished(ActionMode)
     */
    void onActionModeFinished(@NonNull AspectFragmentActivity activity, ActionMode mode);

    /**
     * @see FragmentActivity#onCreateView(String, Context, AttributeSet)
     */
    View onCreateView(@NonNull AspectFragmentActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    /**
     * @see FragmentActivity#onActionModeStarted(ActionMode)
     */
    void onActionModeStarted(@NonNull AspectFragmentActivity activity, ActionMode mode);

    /**
     * @see FragmentActivity#onActivityReenter(int, Intent)
     */
    void onActivityReenter(@NonNull AspectFragmentActivity activity, int resultCode, Intent data);

    /**
     * @see FragmentActivity#onAttachedToWindow()
     */
    void onAttachedToWindow(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onAttachFragment(Fragment)
     */
    void onAttachFragment(@NonNull AspectFragmentActivity activity, Fragment fragment);

    /**
     * @see FragmentActivity#onAttachFragment(android.support.v4.app.Fragment)
     */
    void onAttachFragment(@NonNull AspectFragmentActivity activity, android.support.v4.app.Fragment fragment);

    /**
     * @see FragmentActivity#onContentChanged()
     */
    void onContentChanged(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onContextMenuClosed(Menu)
     */
    void onContextMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu);

    /**
     * @see FragmentActivity#onCreate(Bundle, PersistableBundle)
     */
    void onCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see FragmentActivity#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see FragmentActivity#onCreateNavigateUpTaskStack(TaskStackBuilder)
     */
    void onCreateNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, @NonNull TaskStackBuilder builder);

    /**
     * @see FragmentActivity#onDetachedFromWindow()
     */
    void onDetachedFromWindow(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onEnterAnimationComplete()
     */
    void onEnterAnimationComplete(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu);

    /**
     * @see FragmentActivity#onPostCreate(Bundle, PersistableBundle)
     */
    void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see FragmentActivity#onPrepareNavigateUpTaskStack(TaskStackBuilder)
     */
    void onPrepareNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, TaskStackBuilder builder);

    /**
     * @see FragmentActivity#onProvideAssistData(Bundle)
     */
    void onProvideAssistData(@NonNull AspectFragmentActivity activity, Bundle data);

    /**
     * @see FragmentActivity#onRestoreInstanceState(Bundle, PersistableBundle)
     */
    void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    /**
     * @see FragmentActivity#onSaveInstanceState(Bundle, PersistableBundle)
     */
    void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState);

    /**
     * @see FragmentActivity#onTrimMemory(int)
     */
    void onTrimMemory(@NonNull AspectFragmentActivity activity, int level);

    /**
     * @see FragmentActivity#onUserInteraction()
     */
    void onUserInteraction(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onVisibleBehindCanceled()
     */
    void onVisibleBehindCanceled(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onWindowAttributesChanged(WindowManager.LayoutParams)
     */
    void onWindowAttributesChanged(@NonNull AspectFragmentActivity activity, WindowManager.LayoutParams params);

    /**
     * @see FragmentActivity#onWindowFocusChanged(boolean)
     */
    void onWindowFocusChanged(@NonNull AspectFragmentActivity activity, boolean hasFocus);

    /**
     * @see FragmentActivity#onPrepareOptionsPanel(View, Menu)
     */
    boolean onPrepareOptionsPanel(@NonNull AspectFragmentActivity activity, View view, Menu menu);

    /**
     * @see FragmentActivity#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectFragmentActivity activity, int requestCode, int resultCode, Intent data);

    /**
     * @see FragmentActivity#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectFragmentActivity activity, @Nullable Bundle savedInstanceState);

    /**
     * @see FragmentActivity#onDestroy()
     */
    void onDestroy(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onNewIntent(Intent)
     */
    void onNewIntent(@NonNull AspectFragmentActivity activity, Intent intent);

    /**
     * @see FragmentActivity#onPause()
     */
    void onPause(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onPostResume()
     */
    void onPostResume(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onResume()
     */
    void onResume(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onResumeFragments()
     */
    void onResumeFragments(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState);

    /**
     * @see FragmentActivity#onStart()
     */
    void onStart(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onStop()
     */
    void onStop(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onCreatePanelMenu(int, Menu)
     */
    boolean onCreatePanelMenu(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);

    /**
     * @see FragmentActivity#onKeyDown(int, KeyEvent)
     */
    boolean onKeyDown(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    /**
     * @see FragmentActivity#onMenuItemSelected(int, MenuItem)
     */
    boolean onMenuItemSelected(@NonNull AspectFragmentActivity activity, int featureId, MenuItem item);

    /**
     * @see FragmentActivity#onPreparePanel(int, View, Menu)
     */
    boolean onPreparePanel(@NonNull AspectFragmentActivity activity, int featureId, View view, Menu menu);

    /**
     * @see FragmentActivity#onRetainCustomNonConfigurationInstance()
     */
    Object onRetainCustomNonConfigurationInstance(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onBackPressed()
     */
    void onBackPressed(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectFragmentActivity activity, Configuration newConfig);

    /**
     * @see FragmentActivity#onLowMemory()
     */
    void onLowMemory(@NonNull AspectFragmentActivity activity);

    /**
     * @see FragmentActivity#onPanelClosed(int, Menu)
     */
    void onPanelClosed(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);
}
