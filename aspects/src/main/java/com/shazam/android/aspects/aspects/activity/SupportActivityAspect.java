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
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectFragmentActivity} when they are listed in the 
 * {@link Aspects#aspects()} parameter.
 */
public interface SupportActivityAspect extends Aspect<AspectFragmentActivity> {

    void onPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog);

    void onPrepareDialog(AspectFragmentActivity activity, int id, Dialog dialog, Bundle args);

    Dialog onCreateDialog(AspectFragmentActivity activity, int id);

    @Nullable
    Dialog onCreateDialog(AspectFragmentActivity activity, int id, Bundle args);

    void onApplyThemeResource(AspectFragmentActivity activity, Resources.Theme theme, int resid, boolean first);

    void onPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState);

    void onChildTitleChanged(AspectFragmentActivity activity, Activity childActivity, CharSequence title);

    void onRestart(AspectFragmentActivity activity);

    void onRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState);

    void onTitleChanged(AspectFragmentActivity activity, CharSequence title, int color);

    void onUserLeaveHint(AspectFragmentActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(AspectFragmentActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(AspectFragmentActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(AspectFragmentActivity activity, Menu menu);

    boolean onCreateThumbnail(AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(AspectFragmentActivity activity, MotionEvent event);

    boolean onKeyLongPress(AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onMenuOpened(AspectFragmentActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(AspectFragmentActivity activity);

    boolean onNavigateUpFromChild(AspectFragmentActivity activity, Activity child);

    boolean onOptionsItemSelected(AspectFragmentActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(AspectFragmentActivity activity, Menu menu);

    boolean onSearchRequested(AspectFragmentActivity activity);

    boolean onTouchEvent(AspectFragmentActivity activity, MotionEvent event);

    boolean onTrackballEvent(AspectFragmentActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(AspectFragmentActivity activity);

    @Nullable
    View onCreatePanelView(AspectFragmentActivity activity, int featureId);

    View onCreateView(AspectFragmentActivity activity, View parent, String name, Context context, AttributeSet attrs);

    void onActionModeFinished(AspectFragmentActivity activity, ActionMode mode);

    View onCreateView(AspectFragmentActivity activity, String name, Context context, AttributeSet attrs);

    void onActionModeStarted(AspectFragmentActivity activity, ActionMode mode);

    void onActivityReenter(AspectFragmentActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(AspectFragmentActivity activity);

    void onAttachFragment(AspectFragmentActivity activity, Fragment fragment);

    void onAttachFragment(AspectFragmentActivity activity, android.support.v4.app.Fragment fragment);

    void onContentChanged(AspectFragmentActivity activity);

    void onContextMenuClosed(AspectFragmentActivity activity, Menu menu);

    void onCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onCreateContextMenu(AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder);

    void onDetachedFromWindow(AspectFragmentActivity activity);

    void onEnterAnimationComplete(AspectFragmentActivity activity);

    void onOptionsMenuClosed(AspectFragmentActivity activity, Menu menu);

    void onPostCreate(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(AspectFragmentActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(AspectFragmentActivity activity, Bundle data);

    void onRestoreInstanceState(AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onSaveInstanceState(AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onTrimMemory(AspectFragmentActivity activity, int level);

    void onUserInteraction(AspectFragmentActivity activity);

    void onVisibleBehindCanceled(AspectFragmentActivity activity);

    void onWindowAttributesChanged(AspectFragmentActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(AspectFragmentActivity activity, boolean hasFocus);

    boolean onPrepareOptionsPanel(AspectFragmentActivity activity, View view, Menu menu);

    void onActivityResult(AspectFragmentActivity activity, int requestCode, int resultCode, Intent data);

    void onCreate(AspectFragmentActivity activity, Bundle savedInstanceState);

    void onDestroy(AspectFragmentActivity activity);

    void onNewIntent(AspectFragmentActivity activity, Intent intent);

    void onPause(AspectFragmentActivity activity);

    void onPostResume(AspectFragmentActivity activity);

    void onResume(AspectFragmentActivity activity);

    void onResumeFragments(AspectFragmentActivity activity);

    void onSaveInstanceState(AspectFragmentActivity activity, Bundle outState);

    void onStart(AspectFragmentActivity activity);

    void onStop(AspectFragmentActivity activity);

    boolean onCreatePanelMenu(AspectFragmentActivity activity, int featureId, Menu menu);

    boolean onKeyDown(AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onMenuItemSelected(AspectFragmentActivity activity, int featureId, MenuItem item);

    boolean onPreparePanel(AspectFragmentActivity activity, int featureId, View view, Menu menu);

    Object onRetainCustomNonConfigurationInstance(AspectFragmentActivity activity);

    void onBackPressed(AspectFragmentActivity activity);

    void onConfigurationChanged(AspectFragmentActivity activity, Configuration newConfig);

    void onLowMemory(AspectFragmentActivity activity);

    void onPanelClosed(AspectFragmentActivity activity, int featureId, Menu menu);
}
