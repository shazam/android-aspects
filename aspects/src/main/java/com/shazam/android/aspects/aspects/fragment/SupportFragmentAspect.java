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

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.shazam.android.aspects.base.fragment.AspectSupportFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectSupportFragment} when they are listed in the
 * {@link Aspects#aspects()} parameter.
 */
public interface SupportFragmentAspect extends Aspect<AspectSupportFragment> {

    /**
     * @see Fragment#onCreateAnimation(int, boolean, int)
     */
    Animation onCreateAnimation(@NonNull AspectSupportFragment fragment, int transit, boolean enter, int nextAnim);

    /**
     * @see Fragment#onContextItemSelected(MenuItem)
     */
    boolean onContextItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item);

    /**
     * @see Fragment#onOptionsItemSelected(MenuItem)
     */
    boolean onOptionsItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item);

    /**
     * @see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Nullable
    View onCreateView(@NonNull AspectSupportFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * @see Fragment#onActivityCreated(Bundle)
     */
    void onActivityCreated(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState);

    /**
     * @see Fragment#onActivityResult(int, int, Intent)
     */
    void onActivityResult(@NonNull AspectSupportFragment fragment, int requestCode, int resultCode, Intent data);

    /**
     * @see Fragment#onAttach(Activity)
     */
    void onAttach(@NonNull AspectSupportFragment fragment, Activity activity);

    /**
     * @see Fragment#onConfigurationChanged(Configuration)
     */
    void onConfigurationChanged(@NonNull AspectSupportFragment fragment, Configuration newConfig);

    /**
     * @see Fragment#onCreate(Bundle)
     */
    void onCreate(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState);

    /**
     * @see Fragment#onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)
     */
    void onCreateContextMenu(@NonNull AspectSupportFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    /**
     * @see Fragment#onCreateOptionsMenu(Menu, MenuInflater)
     */
    void onCreateOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu, MenuInflater inflater);

    /**
     * @see Fragment#onDestroy()
     */
    void onDestroy(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onDestroyOptionsMenu()
     */
    void onDestroyOptionsMenu(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onDestroyView()
     */
    void onDestroyView(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onDetach()
     */
    void onDetach(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onHiddenChanged(boolean)
     */
    void onHiddenChanged(@NonNull AspectSupportFragment fragment, boolean hidden);

    /**
     * @see Fragment#onInflate(Activity, AttributeSet, Bundle)
     */
    void onInflate(@NonNull AspectSupportFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    /**
     * @see Fragment#onLowMemory()
     */
    void onLowMemory(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onOptionsMenuClosed(Menu)
     */
    void onOptionsMenuClosed(@NonNull AspectSupportFragment fragment, Menu menu);

    /**
     * @see Fragment#onPause()
     */
    void onPause(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onPrepareOptionsMenu(Menu)
     */
    void onPrepareOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu);

    /**
     * @see Fragment#onResume()
     */
    void onResume(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onSaveInstanceState(Bundle)
     */
    void onSaveInstanceState(@NonNull AspectSupportFragment fragment, Bundle outState);

    /**
     * @see Fragment#onStart()
     */
    void onStart(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onStop()
     */
    void onStop(@NonNull AspectSupportFragment fragment);

    /**
     * @see Fragment#onViewCreated(View, Bundle)
     */
    void onViewCreated(@NonNull AspectSupportFragment fragment, View view, Bundle savedInstanceState);

    /**
     * @see Fragment#onViewStateRestored(Bundle)
     */
    void onViewStateRestored(@NonNull AspectSupportFragment fragment, Bundle savedInstanceState);
}
