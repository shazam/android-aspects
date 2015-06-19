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
import android.support.annotation.Nullable;
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

    Animation onCreateAnimation(AspectSupportFragment fragment, int transit, boolean enter, int nextAnim);

    boolean onContextItemSelected(AspectSupportFragment fragment, MenuItem item);

    boolean onOptionsItemSelected(AspectSupportFragment fragment, MenuItem item);

    @Nullable
    View onCreateView(AspectSupportFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onActivityCreated(AspectSupportFragment fragment, Bundle savedInstanceState);

    void onActivityResult(AspectSupportFragment fragment, int requestCode, int resultCode, Intent data);

    void onAttach(AspectSupportFragment fragment, Activity activity);

    void onConfigurationChanged(AspectSupportFragment fragment, Configuration newConfig);

    void onCreate(AspectSupportFragment fragment, Bundle savedInstanceState);

    void onCreateContextMenu(AspectSupportFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(AspectSupportFragment fragment, Menu menu, MenuInflater inflater);

    void onDestroy(AspectSupportFragment fragment);

    void onDestroyOptionsMenu(AspectSupportFragment fragment);

    void onDestroyView(AspectSupportFragment fragment);

    void onDetach(AspectSupportFragment fragment);

    void onHiddenChanged(AspectSupportFragment fragment, boolean hidden);

    void onInflate(AspectSupportFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(AspectSupportFragment fragment);

    void onOptionsMenuClosed(AspectSupportFragment fragment, Menu menu);

    void onPause(AspectSupportFragment fragment);

    void onPrepareOptionsMenu(AspectSupportFragment fragment, Menu menu);

    void onResume(AspectSupportFragment fragment);

    void onSaveInstanceState(AspectSupportFragment fragment, Bundle outState);

    void onStart(AspectSupportFragment fragment);

    void onStop(AspectSupportFragment fragment);

    void onViewCreated(AspectSupportFragment fragment, View view, Bundle savedInstanceState);

    void onViewStateRestored(AspectSupportFragment fragment, Bundle savedInstanceState);
}
