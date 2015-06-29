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
package com.shazam.android.aspects.aspects.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
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
import com.shazam.android.aspects.base.fragment.AspectFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectFragment} when they are listed in the {@link Aspects#aspects()} 
 * parameter.
 */
public interface FragmentAspect extends Aspect<AspectFragment> {

    /**
     * @see Fragment#onCreateAnimator(int, boolean, int)
     */
    Animator onCreateAnimator(@NonNull AspectFragment fragment, int transit, boolean enter, int nextAnim);

    /**
     * @see Fragment#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectFragment fragment, MenuItem item);

    /**
     * @see Fragment#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectFragment fragment, MenuItem item);

    /**
     * @see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Nullable
    View onCreateView(@NonNull AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * @see Fragment#onActivityCreated(Bundle)
     */
    void onActivityCreated(@NonNull AspectFragment fragment, Bundle savedInstanceState);

    /**
     * @see Fragment#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectFragment fragment, int requestCode, int resultCode, Intent data);

    /**
     * @see Fragment#onAttach(Activity)
     */
    void onAttach(@NonNull AspectFragment fragment, Activity activity);

    /**
     * @see Fragment#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectFragment fragment, Configuration newConfig);

    /**
     * @see Fragment#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectFragment fragment, Bundle savedInstanceState);

    /**
     * @see Fragment#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see Fragment#onCreateOptionsMenu(Menu, MenuInflater)
     */
    void onCreateOptionsMenu(@NonNull AspectFragment fragment, Menu menu, MenuInflater inflater);

    /**
     * @see Fragment#onDestroy()
     */
    void onDestroy(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onDestroyOptionsMenu()
     */
    void onDestroyOptionsMenu(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onDestroyView()
     */
    void onDestroyView(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onDetach()
     */
    void onDetach(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onHiddenChanged(boolean)
     */
    void onHiddenChanged(@NonNull AspectFragment fragment, boolean hidden);

    /**
     * @see Fragment#onInflate(Activity, AttributeSet, Bundle)
     */
    void onInflate(@NonNull AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see Fragment#onLowMemory()
     */
    void onLowMemory(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onInflate(AttributeSet, Bundle)
     */
    @Deprecated
    void onInflate(@NonNull AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see Fragment#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectFragment fragment, Menu menu);

    /**
     * @see Fragment#onPause()
     */
    void onPause(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onPrepareOptionsMenu(Menu)
     */
    void onPrepareOptionsMenu(@NonNull AspectFragment fragment, Menu menu);

    /**
     * @see Fragment#onResume()
     */
    void onResume(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectFragment fragment, Bundle outState);

    /**
     * @see Fragment#onStart()
     */
    void onStart(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onStop()
     */
    void onStop(@NonNull AspectFragment fragment);

    /**
     * @see Fragment#onTrimMemory(int)
     */
    void onTrimMemory(@NonNull AspectFragment fragment, int level);

    /**
     * @see Fragment#onViewCreated(View, Bundle)
     */
    void onViewCreated(@NonNull AspectFragment fragment, View view, Bundle savedInstanceState);

    /**
     * @see Fragment#onViewStateRestored(Bundle)
     */
    void onViewStateRestored(@NonNull AspectFragment fragment, Bundle savedInstanceState);
}
