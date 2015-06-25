/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (AspectDialogFragment fragment, the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.android.aspects.aspects.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.base.fragment.AspectDialogFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectDialogFragment} when they are listed in the {@link Aspects#aspects()}
 * parameter.
 */
public interface DialogFragmentAspect extends Aspect<AspectDialogFragment> {

    Animator onCreateAnimator(AspectDialogFragment fragment, int transit, boolean enter, int nextAnim);

    boolean onContextItemSelected(AspectDialogFragment fragment, MenuItem item);

    boolean onOptionsItemSelected(AspectDialogFragment fragment, MenuItem item);

    Dialog onCreateDialog(AspectDialogFragment fragment, Bundle savedInstanceState);

    @Nullable
    View onCreateView(AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onActivityCreated(AspectDialogFragment fragment, Bundle savedInstanceState);

    void onActivityResult(AspectDialogFragment fragment, int requestCode, int resultCode, Intent data);

    void onAttach(AspectDialogFragment fragment, Activity activity);

    void onCancel(AspectDialogFragment fragment, DialogInterface dialog);

    void onConfigurationChanged(AspectDialogFragment fragment, Configuration newConfig);

    void onCreate(AspectDialogFragment fragment, Bundle savedInstanceState);

    void onCreateContextMenu(AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(AspectDialogFragment fragment, Menu menu, MenuInflater inflater);

    void onDestroy(AspectDialogFragment fragment);

    void onDestroyOptionsMenu(AspectDialogFragment fragment);

    void onDestroyView(AspectDialogFragment fragment);

    void onDetach(AspectDialogFragment fragment);

    void onDismiss(AspectDialogFragment fragment, DialogInterface dialog);

    void onSaveInstanceState(AspectDialogFragment fragment, Bundle outState);

    void onStart(AspectDialogFragment fragment);

    void onStop(AspectDialogFragment fragment);

    void onHiddenChanged(AspectDialogFragment fragment, boolean hidden);

    void onInflate(AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onInflate(AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(AspectDialogFragment fragment);

    void onOptionsMenuClosed(AspectDialogFragment fragment, Menu menu);

    void onPause(AspectDialogFragment fragment);

    void onPrepareOptionsMenu(AspectDialogFragment fragment, Menu menu);

    void onResume(AspectDialogFragment fragment);

    void onTrimMemory(AspectDialogFragment fragment, int level);

    void onViewCreated(AspectDialogFragment fragment, View view, Bundle savedInstanceState);

    void onViewStateRestored(AspectDialogFragment fragment, Bundle savedInstanceState);
}
