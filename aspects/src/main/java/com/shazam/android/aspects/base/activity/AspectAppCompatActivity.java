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
package com.shazam.android.aspects.base.activity;

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
import com.shazam.android.aspects.aspects.activity.AppCompatActivityAspect;
import com.shazam.android.aspects.dispatchers.activity.AspectAppCompatActivityDispatcher;

/**
 * This is the base {@link AppCompatActivity} for lifecycle delegation. Activities should extend this class
 * and then annotate themselves with the {@link Aspects} annotation to register {@link AppCompatActivityAspect}s
 */
public class AspectAppCompatActivity extends AppCompatActivity {

    private AspectAppCompatActivityDispatcher dispatcher;

    @SuppressWarnings("UnusedDeclaration")
    public AspectAppCompatActivity() {
        this.dispatcher = AspectAppCompatActivityDispatcher.create(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        dispatcher.dispatchOnCreate(this, savedInstanceState, persistentState);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        dispatcher.dispatchOnTrimMemory(this, level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dispatcher.dispatchOnConfigurationChanged(this, newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        dispatcher.dispatchOnLowMemory(this);
    }

    @Override
    protected void onApplyThemeResource(@NonNull Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
        dispatcher.dispatchOnApplyThemeResource(this, theme, resid, first);
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
        dispatcher.dispatchOnChildTitleChanged(this, childActivity, title);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dispatcher.dispatchOnRestart(this);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dispatcher.dispatchOnRestoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        dispatcher.dispatchOnUserLeaveHint(this);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        ActionMode actionMode = super.onWindowStartingActionMode(callback);
        return actionMode != null ? actionMode : dispatcher.dispatchOnWindowStartingActionMode(this, callback);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item) || dispatcher.dispatchOnContextItemSelected(this, item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu) || dispatcher.dispatchOnCreateOptionsMenu(this, menu);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas) || dispatcher.dispatchOnCreateThumbnail(this, outBitmap, canvas);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event) || dispatcher.dispatchOnGenericMotionEvent(this, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event) || dispatcher.dispatchOnKeyLongPress(this, keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event) || dispatcher.dispatchOnKeyMultiple(this, keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event) || dispatcher.dispatchOnKeyShortcut(this, keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, @NonNull KeyEvent event) {
        return super.onKeyUp(keyCode, event) || dispatcher.dispatchOnKeyUp(this, keyCode, event);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu) || dispatcher.dispatchOnMenuOpened(this, featureId, menu);
    }

    @Override
    public boolean onNavigateUp() {
        return super.onNavigateUp() || dispatcher.dispatchOnNavigateUp(this);
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        return super.onNavigateUpFromChild(child) || dispatcher.dispatchOnNavigateUpFromChild(this, child);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item) || dispatcher.dispatchOnOptionsItemSelected(this, item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu) || dispatcher.dispatchOnPrepareOptionsMenu(this, menu);
    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested() || dispatcher.dispatchOnSearchRequested(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event) || dispatcher.dispatchOnTouchEvent(this, event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event) || dispatcher.dispatchOnTrackballEvent(this, event);
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        CharSequence description = super.onCreateDescription();
        return description != null ? description : dispatcher.dispatchOnCreateDescription(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dispatcher.dispatchOnCreate(this, savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        dispatcher.dispatchOnAttachFragment(this, fragment);
    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        dispatcher.dispatchOnAttachFragment(this, fragment);
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        View view = super.onCreatePanelView(featureId);
        return view != null ? view : dispatcher.dispatchOnCreatePanelView(this, featureId);
    }

    @Override
    public View onCreateView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view = super.onCreateView(parent, name, context, attrs);
        return view != null ? view : dispatcher.dispatchOnCreateView(this, parent, name, context, attrs);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        dispatcher.dispatchOnActionModeFinished(this, mode);
    }

    @Nullable
    @Override
    public View onCreateView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view = super.onCreateView(name, context, attrs);
        return view != null ? view : dispatcher.dispatchOnCreateView(this, name, context, attrs);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        dispatcher.dispatchOnActionModeStarted(this, mode);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        dispatcher.dispatchOnActivityReenter(this, resultCode, data);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        dispatcher.dispatchOnAttachedToWindow(this);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        dispatcher.dispatchOnContextMenuClosed(this, menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        dispatcher.dispatchOnCreateContextMenu(this, menu, v, menuInfo);
    }

    @Override
    public void onCreateNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);
        dispatcher.dispatchOnCreateNavigateUpTaskStack(this, builder);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispatcher.dispatchOnDetachedFromWindow(this);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        dispatcher.dispatchOnEnterAnimationComplete(this);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        dispatcher.dispatchOnOptionsMenuClosed(this, menu);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        dispatcher.dispatchOnPostCreate(this, savedInstanceState, persistentState);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);
        dispatcher.dispatchOnPrepareNavigateUpTaskStack(this, builder);
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
        dispatcher.dispatchOnProvideAssistData(this, data);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        dispatcher.dispatchOnRestoreInstanceState(this, savedInstanceState, persistentState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        dispatcher.dispatchOnSaveInstanceState(this, outState, outPersistentState);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        dispatcher.dispatchOnUserInteraction(this);
    }

    @Override
    public void onVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
        dispatcher.dispatchOnVisibleBehindCanceled(this);
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
        dispatcher.dispatchOnWindowAttributesChanged(this, params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        dispatcher.dispatchOnWindowFocusChanged(this, hasFocus);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu) || dispatcher.dispatchOnPrepareOptionsPanel(this, view, menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dispatcher.dispatchOnActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatcher.dispatchOnDestroy(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dispatcher.dispatchOnNewIntent(this, intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dispatcher.dispatchOnPause(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        dispatcher.dispatchOnPostCreate(this, savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        dispatcher.dispatchOnPostResume(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dispatcher.dispatchOnResume(this);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        dispatcher.dispatchOnResumeFragments(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        dispatcher.dispatchOnSaveInstanceState(this, outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        dispatcher.dispatchOnStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        dispatcher.dispatchOnStop(this);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        dispatcher.dispatchOnTitleChanged(this, title, color);
    }

    @Nullable
    @Override
    public android.support.v7.view.ActionMode onWindowStartingSupportActionMode(android.support.v7.view.ActionMode.Callback callback) {
        android.support.v7.view.ActionMode actionMode = super.onWindowStartingSupportActionMode(callback);
        return actionMode != null ? actionMode : dispatcher.dispatchOnWindowStartingSupportActionMode(this, callback);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return super.onCreatePanelMenu(featureId, menu) || dispatcher.dispatchOnCreatePanelMenu(this, featureId, menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event) || dispatcher.dispatchOnKeyDown(this, keyCode, event);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu) || dispatcher.dispatchOnPreparePanel(this, featureId, view, menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp() || dispatcher.dispatchOnSupportNavigateUp(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        dispatcher.dispatchOnContentChanged(this);
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
        dispatcher.dispatchOnCreateSupportNavigateUpTaskStack(this, builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {
        super.onPrepareSupportNavigateUpTaskStack(builder);
        dispatcher.dispatchOnPrepareSupportNavigateUpTaskStack(this, builder);
    }

    @Override
    public void onSupportActionModeFinished(android.support.v7.view.ActionMode mode) {
        super.onSupportActionModeFinished(mode);
        dispatcher.dispatchOnSupportActionModeFinished(this, mode);
    }

    @Override
    public void onSupportActionModeStarted(android.support.v7.view.ActionMode mode) {
        super.onSupportActionModeStarted(mode);
        dispatcher.dispatchOnSupportActionModeStarted(this, mode);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();
        dispatcher.dispatchOnSupportContentChanged(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dispatcher.dispatchOnBackPressed(this);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
        dispatcher.dispatchOnPanelClosed(this, featureId, menu);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Object configurationInstance = super.onRetainCustomNonConfigurationInstance();
        return configurationInstance != null ? configurationInstance : dispatcher.dispatchOnRetainCustomNonConfigurationInstance(this);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = super.onCreateDialog(id);
        return dialog != null ? dialog : dispatcher.dispatchOnCreateDialog(this, id);
    }

    @Nullable
    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        Dialog dialog = super.onCreateDialog(id, args);
        return dialog != null ? dialog : dispatcher.dispatchOnCreateDialog(this, id, args);
    }

    @Override
    protected void onPrepareDialog(int id, @NonNull Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        dispatcher.dispatchOnPrepareDialog(this, id, dialog);
    }

    @Override
    protected void onPrepareDialog(int id, @NonNull Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);
        dispatcher.dispatchOnPrepareDialog(this, id, dialog, args);
    }
}
