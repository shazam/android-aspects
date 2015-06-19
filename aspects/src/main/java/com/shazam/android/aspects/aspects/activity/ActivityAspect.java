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

import com.shazam.android.aspects.base.activity.AspectActivity;
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectActivity} when they are listed in the
 * {@link Aspects#aspects()} parameter.
 */
public interface ActivityAspect extends Aspect<AspectActivity> {

    void onSaveInstanceState(AspectActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onActivityResult(AspectActivity activity, int requestCode, int resultCode, Intent data);

    void onApplyThemeResource(AspectActivity activity, Resources.Theme theme, int resid, boolean first);

    void onChildTitleChanged(AspectActivity activity, Activity childActivity, CharSequence title);

    void onCreate(AspectActivity activity, Bundle savedInstanceState);

    void onDestroy(AspectActivity activity);

    void onNewIntent(AspectActivity activity, Intent intent);

    void onPause(AspectActivity activity);

    void onPostCreate(AspectActivity activity, Bundle savedInstanceState);

    void onPostResume(AspectActivity activity);

    void onRestart(AspectActivity activity);

    void onRestoreInstanceState(AspectActivity activity, Bundle savedInstanceState);

    void onResume(AspectActivity activity);

    void onSaveInstanceState(AspectActivity activity, Bundle outState);

    void onStart(AspectActivity activity);

    void onStop(AspectActivity activity);

    void onTitleChanged(AspectActivity activity, CharSequence title, int color);

    void onUserLeaveHint(AspectActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(AspectActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(AspectActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(AspectActivity activity, Menu menu);

    boolean onCreatePanelMenu(AspectActivity activity, int featureId, Menu menu);

    boolean onCreateThumbnail(AspectActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(AspectActivity activity, MotionEvent event);

    boolean onKeyDown(AspectActivity activity, int keyCode, KeyEvent event);

    boolean onKeyLongPress(AspectActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(AspectActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(AspectActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(AspectActivity activity, int keyCode, KeyEvent event);

    boolean onMenuItemSelected(AspectActivity activity, int featureId, MenuItem item);

    boolean onMenuOpened(AspectActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(AspectActivity activity);

    boolean onNavigateUpFromChild(AspectActivity activity, Activity child);

    boolean onOptionsItemSelected(AspectActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(AspectActivity activity, Menu menu);

    boolean onPreparePanel(AspectActivity activity, int featureId, View view, Menu menu);

    boolean onSearchRequested(AspectActivity activity);

    boolean onTouchEvent(AspectActivity activity, MotionEvent event);

    boolean onTrackballEvent(AspectActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(AspectActivity activity);

    @Nullable
    View onCreatePanelView(AspectActivity activity, int featureId);

    @Nullable
    View onCreateView(AspectActivity activity, String name, Context context, AttributeSet attrs);

    View onCreateView(AspectActivity activity, View parent, String name, Context context, AttributeSet attrs);

    void onActionModeFinished(AspectActivity activity, ActionMode mode);

    void onActionModeStarted(AspectActivity activity, ActionMode mode);

    void onActivityReenter(AspectActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(AspectActivity activity);

    void onAttachFragment(AspectActivity activity, Fragment fragment);

    void onBackPressed(AspectActivity activity);

    void onConfigurationChanged(AspectActivity activity, Configuration newConfig);

    void onContentChanged(AspectActivity activity);

    void onContextMenuClosed(AspectActivity activity, Menu menu);

    void onCreate(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onCreateContextMenu(AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(AspectActivity activity, TaskStackBuilder builder);

    void onDetachedFromWindow(AspectActivity activity);

    void onEnterAnimationComplete(AspectActivity activity);

    void onLowMemory(AspectActivity activity);

    void onOptionsMenuClosed(AspectActivity activity, Menu menu);

    void onPanelClosed(AspectActivity activity, int featureId, Menu menu);

    void onPostCreate(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(AspectActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(AspectActivity activity, Bundle data);

    void onRestoreInstanceState(AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onTrimMemory(AspectActivity activity, int level);

    void onUserInteraction(AspectActivity activity);

    void onVisibleBehindCanceled(AspectActivity activity);

    void onWindowAttributesChanged(AspectActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(AspectActivity activity, boolean hasFocus);

    Dialog onCreateDialog(AspectActivity activity, int id);

    @Nullable
    Dialog onCreateDialog(AspectActivity activity, int id, Bundle args);

    void onPrepareDialog(AspectActivity activity, int id, Dialog dialog);

    void onPrepareDialog(AspectActivity activity, int id, Dialog dialog, Bundle args);

    Object onRetainNonConfigurationInstance(AspectActivity activity);
}
