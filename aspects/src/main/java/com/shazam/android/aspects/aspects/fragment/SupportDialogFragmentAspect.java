/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (@NonNull AspectSupportDialogFragment fragment, AspectDialogFragment fragment, the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.android.aspects.aspects.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.base.fragment.AspectSupportDialogFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectSupportDialogFragment} when they are listed in the {@link Aspects#aspects()}
 * parameter.
 */
public interface SupportDialogFragmentAspect extends Aspect<AspectSupportDialogFragment> {

    /**
     * @see DialogFragment#onActivityCreated(Bundle)
     */
    void onActivityCreated(@NonNull AspectSupportDialogFragment fragment, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onAttach(Activity)
     */
    void onAttach(@NonNull AspectSupportDialogFragment fragment, Activity activity);

    /**
     * @see DialogFragment#onCancel(DialogInterface)
     */
    void onCancel(@NonNull AspectSupportDialogFragment fragment, DialogInterface dialog);

    /**
     * @see DialogFragment#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState);

    /**
     * @see DialogFragment#onCreateDialog(Bundle)
     */
    Dialog onCreateDialog(@NonNull AspectSupportDialogFragment fragment, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onDestroyView()
     */
    void onDestroyView(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onDetach()
     */
    void onDetach(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onDismiss(DialogInterface)
     */
    void onDismiss(@NonNull AspectSupportDialogFragment fragment, DialogInterface dialog);

    /**
     * @see DialogFragment#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectSupportDialogFragment fragment, Bundle outState);

    /**
     * @see DialogFragment#onStart()
     */
    void onStart(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onStop()
     */
    void onStop(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectSupportDialogFragment fragment, int requestCode, int resultCode, Intent data);

    /**
     * @see DialogFragment#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectSupportDialogFragment fragment, Configuration newConfig);

    /**
     * @see DialogFragment#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectSupportDialogFragment fragment, MenuItem item);

    /**
     * @see DialogFragment#onCreateAnimation(int, boolean, int)
     */
    Animation onCreateAnimation(@NonNull AspectSupportDialogFragment fragment, int transit, boolean enter, int nextAnim);

    /**
     * @see DialogFragment#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectSupportDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see DialogFragment#onCreateOptionsMenu(Menu, MenuInflater)
     */
    void onCreateOptionsMenu(@NonNull AspectSupportDialogFragment fragment, Menu menu, MenuInflater inflater);

    /**
     * @see DialogFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Nullable
    View onCreateView(@NonNull AspectSupportDialogFragment fragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * @see DialogFragment#onDestroy()
     */
    void onDestroy(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onDestroyOptionsMenu()
     */
    void onDestroyOptionsMenu(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onHiddenChanged(boolean)
     */
    void onHiddenChanged(@NonNull AspectSupportDialogFragment fragment, boolean hidden);

    /**
     * @see DialogFragment#onInflate(Activity, AttributeSet, Bundle)
     */
    void onInflate(@NonNull AspectSupportDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see DialogFragment#onLowMemory()
     */
    void onLowMemory(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectSupportDialogFragment fragment, MenuItem item);

    /**
     * @see DialogFragment#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectSupportDialogFragment fragment, Menu menu);

    /**
     * @see DialogFragment#onPause()
     */
    void onPause(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onPrepareOptionsMenu(Menu)
     */
    void onPrepareOptionsMenu(@NonNull AspectSupportDialogFragment fragment, Menu menu);

    /**
     * @see DialogFragment#onResume()
     */
    void onResume(@NonNull AspectSupportDialogFragment fragment);

    /**
     * @see DialogFragment#onViewCreated(View, Bundle)
     */
    void onViewCreated(@NonNull AspectSupportDialogFragment fragment, View view, @Nullable Bundle savedInstanceState);

    /**
     * @see DialogFragment#onViewStateRestored(Bundle)
     */
    void onViewStateRestored(@NonNull AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState);
}
