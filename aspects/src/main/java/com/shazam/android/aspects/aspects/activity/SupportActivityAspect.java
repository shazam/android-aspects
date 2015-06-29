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
import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectFragmentActivity} when they are listed in the 
 * {@link Aspects#aspects()} parameter.
 */
public interface SupportActivityAspect extends Aspect<AspectFragmentActivity> {

    void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog);

    void onPrepareDialog(@NonNull AspectFragmentActivity activity, int id, @NonNull Dialog dialog, Bundle args);

    Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id);

    @Nullable
    Dialog onCreateDialog(@NonNull AspectFragmentActivity activity, int id, Bundle args);

    void onApplyThemeResource(@NonNull AspectFragmentActivity activity, @NonNull Resources.Theme theme, int resid, boolean first);

    void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState);

    void onChildTitleChanged(@NonNull AspectFragmentActivity activity, Activity childActivity, CharSequence title);

    void onRestart(@NonNull AspectFragmentActivity activity);

    void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, @NonNull Bundle savedInstanceState);

    void onTitleChanged(@NonNull AspectFragmentActivity activity, CharSequence title, int color);

    void onUserLeaveHint(@NonNull AspectFragmentActivity activity);

    @Nullable
    ActionMode onWindowStartingActionMode(@NonNull AspectFragmentActivity activity, ActionMode.Callback callback);

    boolean onContextItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item);

    boolean onCreateOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu);

    boolean onCreateThumbnail(@NonNull AspectFragmentActivity activity, Bitmap outBitmap, Canvas canvas);

    boolean onGenericMotionEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    boolean onKeyLongPress(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onKeyMultiple(@NonNull AspectFragmentActivity activity, int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onKeyUp(@NonNull AspectFragmentActivity activity, int keyCode, @NonNull KeyEvent event);

    boolean onMenuOpened(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);

    boolean onNavigateUp(@NonNull AspectFragmentActivity activity);

    boolean onNavigateUpFromChild(@NonNull AspectFragmentActivity activity, Activity child);

    boolean onOptionsItemSelected(@NonNull AspectFragmentActivity activity, MenuItem item);

    boolean onPrepareOptionsMenu(@NonNull AspectFragmentActivity activity, Menu menu);

    boolean onSearchRequested(@NonNull AspectFragmentActivity activity);

    boolean onTouchEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    boolean onTrackballEvent(@NonNull AspectFragmentActivity activity, MotionEvent event);

    @Nullable
    CharSequence onCreateDescription(@NonNull AspectFragmentActivity activity);

    @Nullable
    View onCreatePanelView(@NonNull AspectFragmentActivity activity, int featureId);

    View onCreateView(@NonNull AspectFragmentActivity activity, View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeFinished(@NonNull AspectFragmentActivity activity, ActionMode mode);

    View onCreateView(@NonNull AspectFragmentActivity activity, String name, @NonNull Context context, @NonNull AttributeSet attrs);

    void onActionModeStarted(@NonNull AspectFragmentActivity activity, ActionMode mode);

    void onActivityReenter(@NonNull AspectFragmentActivity activity, int resultCode, Intent data);

    void onAttachedToWindow(@NonNull AspectFragmentActivity activity);

    void onAttachFragment(@NonNull AspectFragmentActivity activity, Fragment fragment);

    void onAttachFragment(@NonNull AspectFragmentActivity activity, android.support.v4.app.Fragment fragment);

    void onContentChanged(@NonNull AspectFragmentActivity activity);

    void onContextMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu);

    void onCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onCreateContextMenu(@NonNull AspectFragmentActivity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, @NonNull TaskStackBuilder builder);

    void onDetachedFromWindow(@NonNull AspectFragmentActivity activity);

    void onEnterAnimationComplete(@NonNull AspectFragmentActivity activity);

    void onOptionsMenuClosed(@NonNull AspectFragmentActivity activity, Menu menu);

    void onPostCreate(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onPrepareNavigateUpTaskStack(@NonNull AspectFragmentActivity activity, TaskStackBuilder builder);

    void onProvideAssistData(@NonNull AspectFragmentActivity activity, Bundle data);

    void onRestoreInstanceState(@NonNull AspectFragmentActivity activity, Bundle savedInstanceState, PersistableBundle persistentState);

    void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState, PersistableBundle outPersistentState);

    void onTrimMemory(@NonNull AspectFragmentActivity activity, int level);

    void onUserInteraction(@NonNull AspectFragmentActivity activity);

    void onVisibleBehindCanceled(@NonNull AspectFragmentActivity activity);

    void onWindowAttributesChanged(@NonNull AspectFragmentActivity activity, WindowManager.LayoutParams params);

    void onWindowFocusChanged(@NonNull AspectFragmentActivity activity, boolean hasFocus);

    boolean onPrepareOptionsPanel(@NonNull AspectFragmentActivity activity, View view, Menu menu);

    void onActivityResult(@NonNull AspectFragmentActivity activity, int requestCode, int resultCode, Intent data);

    void onCreate(@NonNull AspectFragmentActivity activity, @Nullable Bundle savedInstanceState);

    void onDestroy(@NonNull AspectFragmentActivity activity);

    void onNewIntent(@NonNull AspectFragmentActivity activity, Intent intent);

    void onPause(@NonNull AspectFragmentActivity activity);

    void onPostResume(@NonNull AspectFragmentActivity activity);

    void onResume(@NonNull AspectFragmentActivity activity);

    void onResumeFragments(@NonNull AspectFragmentActivity activity);

    void onSaveInstanceState(@NonNull AspectFragmentActivity activity, Bundle outState);

    void onStart(@NonNull AspectFragmentActivity activity);

    void onStop(@NonNull AspectFragmentActivity activity);

    boolean onCreatePanelMenu(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);

    boolean onKeyDown(@NonNull AspectFragmentActivity activity, int keyCode, KeyEvent event);

    boolean onMenuItemSelected(@NonNull AspectFragmentActivity activity, int featureId, MenuItem item);

    boolean onPreparePanel(@NonNull AspectFragmentActivity activity, int featureId, View view, Menu menu);

    Object onRetainCustomNonConfigurationInstance(@NonNull AspectFragmentActivity activity);

    void onBackPressed(@NonNull AspectFragmentActivity activity);

    void onConfigurationChanged(@NonNull AspectFragmentActivity activity, Configuration newConfig);

    void onLowMemory(@NonNull AspectFragmentActivity activity);

    void onPanelClosed(@NonNull AspectFragmentActivity activity, int featureId, Menu menu);
}
