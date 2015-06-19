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
import com.shazam.android.aspects.base.fragment.AspectFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectFragment} when they are listed in the {@link Aspects#aspects()} 
 * parameter.
 */
public interface FragmentAspect extends Aspect<AspectFragment> {

    Animator onCreateAnimator(AspectFragment fragment, int transit, boolean enter, int nextAnim);

    boolean onContextItemSelected(AspectFragment fragment, MenuItem item);

    boolean onOptionsItemSelected(AspectFragment fragment, MenuItem item);

    @Nullable
    View onCreateView(AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onActivityCreated(AspectFragment fragment, Bundle savedInstanceState);

    void onActivityResult(AspectFragment fragment, int requestCode, int resultCode, Intent data);

    void onAttach(AspectFragment fragment, Activity activity);

    void onConfigurationChanged(AspectFragment fragment, Configuration newConfig);

    void onCreate(AspectFragment fragment, Bundle savedInstanceState);

    void onCreateContextMenu(AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(AspectFragment fragment, Menu menu, MenuInflater inflater);

    void onDestroy(AspectFragment fragment);

    void onDestroyOptionsMenu(AspectFragment fragment);

    void onDestroyView(AspectFragment fragment);

    void onDetach(AspectFragment fragment);

    void onHiddenChanged(AspectFragment fragment, boolean hidden);

    void onInflate(AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(AspectFragment fragment);

    void onInflate(AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    void onOptionsMenuClosed(AspectFragment fragment, Menu menu);

    void onPause(AspectFragment fragment);

    void onPrepareOptionsMenu(AspectFragment fragment, Menu menu);

    void onResume(AspectFragment fragment);

    void onSaveInstanceState(AspectFragment fragment, Bundle outState);

    void onStart(AspectFragment fragment);

    void onStop(AspectFragment fragment);

    void onTrimMemory(AspectFragment fragment, int level);

    void onViewCreated(AspectFragment fragment, View view, Bundle savedInstanceState);

    void onViewStateRestored(AspectFragment fragment, Bundle savedInstanceState);
}
