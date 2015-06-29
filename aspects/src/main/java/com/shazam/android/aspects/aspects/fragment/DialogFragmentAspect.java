/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (@NonNull AspectDialogFragment fragment, the "License"); you may not use this file except in compliance with
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
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

    /**
     * @see DialogFragment#onCreateAnimator(int, boolean, int)
     */
    Animator onCreateAnimator(@NonNull AspectDialogFragment fragment, int transit, boolean enter, int nextAnim);

    /**
     * @see DialogFragment#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item);

    /**
     * @see DialogFragment#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item);

    /**
     * @see DialogFragment#onCreateDialog(Bundle)
     */
    Dialog onCreateDialog(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Nullable
    View onCreateView(@NonNull AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onActivityCreated(Bundle)
     */
    void onActivityCreated(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectDialogFragment fragment, int requestCode, int resultCode, Intent data);

    /**
     * @see DialogFragment#onAttach(Activity)
     */
    void onAttach(@NonNull AspectDialogFragment fragment, Activity activity);

    /**
     * @see DialogFragment#onCancel(DialogInterface)
     */
    void onCancel(@NonNull AspectDialogFragment fragment, DialogInterface dialog);

    /**
     * @see DialogFragment#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectDialogFragment fragment, Configuration newConfig);

    /**
     * @see DialogFragment#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see DialogFragment#onCreateOptionsMenu(Menu, MenuInflater)
     */
    void onCreateOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu, MenuInflater inflater);

    /**
     * @see DialogFragment#onDestroy()
     */
    void onDestroy(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onDestroyOptionsMenu()
     */
    void onDestroyOptionsMenu(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onDestroyView()
     */
    void onDestroyView(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onDetach()
     */
    void onDetach(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onDismiss(DialogInterface)
     */
    void onDismiss(@NonNull AspectDialogFragment fragment, DialogInterface dialog);

    /**
     * @see DialogFragment#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectDialogFragment fragment, @NonNull Bundle outState);

    /**
     * @see DialogFragment#onStart()
     */
    void onStart(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onStop()
     */
    void onStop(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onHiddenChanged(boolean)
     */
    void onHiddenChanged(@NonNull AspectDialogFragment fragment, boolean hidden);

    /**
     * @see DialogFragment#onInflate(Activity, AttributeSet, Bundle)
     */
    void onInflate(@NonNull AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onInflate(AttributeSet, Bundle)
     */
    @Deprecated
    void onInflate(@NonNull AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onLowMemory()
     */
    void onLowMemory(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectDialogFragment fragment, Menu menu);

    /**
     * @see DialogFragment#onPause()
     */
    void onPause(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onPrepareOptionsMenu(Menu)
     */
    void onPrepareOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu);

    /**
     * @see DialogFragment#onResume()
     */
    void onResume(@NonNull AspectDialogFragment fragment);

    /**
     * @see DialogFragment#onTrimMemory(int)
     */
    void onTrimMemory(@NonNull AspectDialogFragment fragment, int level);

    /**
     * @see DialogFragment#onViewCreated(View, Bundle)
     */
    void onViewCreated(@NonNull AspectDialogFragment fragment, View view, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onViewStateRestored(Bundle)
     */
    void onViewStateRestored(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);
}
