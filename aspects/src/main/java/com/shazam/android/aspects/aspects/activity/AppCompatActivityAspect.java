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

    void onCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onTrimMemory(@NonNull AspectAppCompatActivity activity, int level);

    void onConfigurationChanged(@NonNull AspectAppCompatActivity activity, Configuration newConfig);

    void onLowMemory(@NonNull AspectAppCompatActivity activity);

    void onApplyThemeResource(@NonNull AspectAppCompatActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    void onChildTitleChanged(@NonNull AspectAppCompatActivity activity, Activity childActivity, CharSequence title);

    void onRestart(@NonNull AspectAppCompatActivity activity);

    void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, @NonNull Bundle savedInstanceState);

    void onUserLeaveHint(@NonNull AspectAppCompatActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectAppCompatActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu);

    boolean onCreateThumbnail(@NonNull AspectAppCompatActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    boolean onKeyLongPress(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(@NonNull AspectAppCompatActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(@NonNull AspectAppCompatActivity activity, int keyCode, @NonNull KeyEvent event);

    boolean onMenuOpened(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(@NonNull AspectAppCompatActivity activity);

    boolean onNavigateUpFromChild(@NonNull AspectAppCompatActivity activity, Activity child);

    boolean onOptionsItemSelected(@NonNull AspectAppCompatActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(@NonNull AspectAppCompatActivity activity, Menu menu);

    boolean onSearchRequested(@NonNull AspectAppCompatActivity activity);

    boolean onTouchEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    boolean onTrackballEvent(@NonNull AspectAppCompatActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(@NonNull AspectAppCompatActivity activity);

    void onCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    void onAttachFragment(@NonNull AspectAppCompatActivity activity, Fragment fragment);

    void onAttachFragment(@NonNull AspectAppCompatActivity activity, android.support.v4.app.Fragment fragment);

    @Nullable
    View onCreatePanelView(@NonNull AspectAppCompatActivity activity, int featureId);

    View onCreateView(@NonNull AspectAppCompatActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeFinished(@NonNull AspectAppCompatActivity activity, ActionMode mode);

    @Nullable
    View onCreateView(@NonNull AspectAppCompatActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeStarted(@NonNull AspectAppCompatActivity activity, ActionMode mode);

    void onActivityReenter(@NonNull AspectAppCompatActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(@NonNull AspectAppCompatActivity activity);

    void onContextMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu);

    void onCreateContextMenu(@NonNull AspectAppCompatActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, @NonNull TaskStackBuilder builder);

    void onDetachedFromWindow(@NonNull AspectAppCompatActivity activity);

    void onEnterAnimationComplete(@NonNull AspectAppCompatActivity activity);

    void onOptionsMenuClosed(@NonNull AspectAppCompatActivity activity, Menu menu);

    void onPostCreate(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(@NonNull AspectAppCompatActivity activity, Bundle data);

    void onRestoreInstanceState(@NonNull AspectAppCompatActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onUserInteraction(@NonNull AspectAppCompatActivity activity);

    void onVisibleBehindCanceled(@NonNull AspectAppCompatActivity activity);

    void onWindowAttributesChanged(@NonNull AspectAppCompatActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(@NonNull AspectAppCompatActivity activity, boolean hasFocus);

    boolean onPrepareOptionsPanel(@NonNull AspectAppCompatActivity activity, View view, Menu menu);

    void onActivityResult(@NonNull AspectAppCompatActivity activity, int requestCode, int resultCode, Intent data);

    void onDestroy(@NonNull AspectAppCompatActivity activity);

    void onNewIntent(@NonNull AspectAppCompatActivity activity, Intent intent);

    void onPause(@NonNull AspectAppCompatActivity activity);

    void onPostCreate(@NonNull AspectAppCompatActivity activity, @Nullable Bundle savedInstanceState);

    void onPostResume(@NonNull AspectAppCompatActivity activity);

    void onResume(@NonNull AspectAppCompatActivity activity);

    void onResumeFragments(@NonNull AspectAppCompatActivity activity);

    void onSaveInstanceState(@NonNull AspectAppCompatActivity activity, Bundle outState);

    void onStart(@NonNull AspectAppCompatActivity activity);

    void onStop(@NonNull AspectAppCompatActivity activity);

    void onTitleChanged(@NonNull AspectAppCompatActivity activity, CharSequence title, int color);

    @Nullable
    android.support.v7.view.ActionMode onWindowStartingSupportActionMode(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode.Callback callback);

    boolean onCreatePanelMenu(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    boolean onKeyDown(@NonNull AspectAppCompatActivity activity, int keyCode, KeyEvent event);

    boolean onPreparePanel(@NonNull AspectAppCompatActivity activity, int featureId, View view, Menu menu);

    boolean onSupportNavigateUp(@NonNull AspectAppCompatActivity activity);

    void onContentChanged(@NonNull AspectAppCompatActivity activity);

    void onCreateSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    void onPrepareSupportNavigateUpTaskStack(@NonNull AspectAppCompatActivity activity, android.support.v4.app.TaskStackBuilder builder);

    void onSupportActionModeFinished(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    void onSupportActionModeStarted(@NonNull AspectAppCompatActivity activity, android.support.v7.view.ActionMode mode);

    @Deprecated
    void onSupportContentChanged(@NonNull AspectAppCompatActivity activity);

    void onBackPressed(@NonNull AspectAppCompatActivity activity);

    void onPanelClosed(@NonNull AspectAppCompatActivity activity, int featureId, Menu menu);

    Object onRetainCustomNonConfigurationInstance(@NonNull AspectAppCompatActivity activity);

    @Deprecated
    Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id);

    @Nullable
    @Deprecated
    Dialog onCreateDialog(@NonNull AspectAppCompatActivity activity, int id, Bundle args);

    @Deprecated
    void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog);

    @Deprecated
    void onPrepareDialog(@NonNull AspectAppCompatActivity activity, int id, @NonNull Dialog dialog, Bundle args);
}
