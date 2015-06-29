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

    void onSaveInstanceState(@NonNull AspectActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onActivityResult(@NonNull AspectActivity activity, int requestCode, int resultCode, Intent data);

    void onApplyThemeResource(@NonNull AspectActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    void onChildTitleChanged(@NonNull AspectActivity activity, Activity childActivity, CharSequence title);

    void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState);

    void onDestroy(@NonNull AspectActivity activity);

    void onNewIntent(@NonNull AspectActivity activity, Intent intent);

    void onPause(@NonNull AspectActivity activity);

    void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState);

    void onPostResume(@NonNull AspectActivity activity);

    void onRestart(@NonNull AspectActivity activity);

    void onRestoreInstanceState(@NonNull AspectActivity activity, @NonNull Bundle savedInstanceState);

    void onResume(@NonNull AspectActivity activity);

    void onSaveInstanceState(@NonNull AspectActivity activity, @NonNull Bundle outState);

    void onStart(@NonNull AspectActivity activity);

    void onStop(@NonNull AspectActivity activity);

    void onTitleChanged(@NonNull AspectActivity activity, CharSequence title, int color);

    void onUserLeaveHint(@NonNull AspectActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(@NonNull AspectActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(@NonNull AspectActivity activity, Menu menu);

    boolean onCreatePanelMenu(@NonNull AspectActivity activity, int featureId, Menu menu);

    boolean onCreateThumbnail(@NonNull AspectActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(@NonNull AspectActivity activity, MotionEvent event);

    boolean onKeyDown(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event);

    boolean onKeyLongPress(@NonNull AspectActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(@NonNull AspectActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(@NonNull AspectActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(@NonNull AspectActivity activity, int keyCode, @NonNull KeyEvent event);

    boolean onMenuItemSelected(@NonNull AspectActivity activity, int featureId, @NonNull MenuItem item);

    boolean onMenuOpened(@NonNull AspectActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(@NonNull AspectActivity activity);

    boolean onNavigateUpFromChild(@NonNull AspectActivity activity, Activity child);

    boolean onOptionsItemSelected(@NonNull AspectActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(@NonNull AspectActivity activity, Menu menu);

    boolean onPreparePanel(@NonNull AspectActivity activity, int featureId, View view, Menu menu);

    boolean onSearchRequested(@NonNull AspectActivity activity);

    boolean onTouchEvent(@NonNull AspectActivity activity, MotionEvent event);

    boolean onTrackballEvent(@NonNull AspectActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(@NonNull AspectActivity activity);

    @Nullable
    View onCreatePanelView(@NonNull AspectActivity activity, int featureId);

    @Nullable
    View onCreateView(@NonNull AspectActivity activity, String name, Context context, AttributeSet attrs);

    View onCreateView(@NonNull AspectActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeFinished(@NonNull AspectActivity activity, ActionMode mode);

    void onActionModeStarted(@NonNull AspectActivity activity, ActionMode mode);

    void onActivityReenter(@NonNull AspectActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(@NonNull AspectActivity activity);

    void onAttachFragment(@NonNull AspectActivity activity, Fragment fragment);

    void onBackPressed(@NonNull AspectActivity activity);

    void onConfigurationChanged(@NonNull AspectActivity activity, Configuration newConfig);

    void onContentChanged(@NonNull AspectActivity activity);

    void onContextMenuClosed(@NonNull AspectActivity activity, Menu menu);

    void onCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onCreateContextMenu(@NonNull AspectActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(@NonNull AspectActivity activity, @NonNull TaskStackBuilder builder);

    void onDetachedFromWindow(@NonNull AspectActivity activity);

    void onEnterAnimationComplete(@NonNull AspectActivity activity);

    void onLowMemory(@NonNull AspectActivity activity);

    void onOptionsMenuClosed(@NonNull AspectActivity activity, Menu menu);

    void onPanelClosed(@NonNull AspectActivity activity, int featureId, Menu menu);

    void onPostCreate(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(@NonNull AspectActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(@NonNull AspectActivity activity, Bundle data);

    void onRestoreInstanceState(@NonNull AspectActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onTrimMemory(@NonNull AspectActivity activity, int level);

    void onUserInteraction(@NonNull AspectActivity activity);

    void onVisibleBehindCanceled(@NonNull AspectActivity activity);

    void onWindowAttributesChanged(@NonNull AspectActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(@NonNull AspectActivity activity, boolean hasFocus);

    Dialog onCreateDialog(@NonNull AspectActivity activity, int id);

    @Nullable
    Dialog onCreateDialog(@NonNull AspectActivity activity, int id, Bundle args);

    void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog);

    void onPrepareDialog(@NonNull AspectActivity activity, int id, @NonNull Dialog dialog, Bundle args);

    Object onRetainNonConfigurationInstance(@NonNull AspectActivity activity);
}
