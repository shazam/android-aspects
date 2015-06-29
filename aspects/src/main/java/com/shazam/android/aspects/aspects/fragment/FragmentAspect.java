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

    Animator onCreateAnimator(@NonNull AspectFragment fragment, int transit, boolean enter, int nextAnim);

    boolean onContextItemSelected(@NonNull AspectFragment fragment, MenuItem item);

    boolean onOptionsItemSelected(@NonNull AspectFragment fragment, MenuItem item);

    @Nullable
    View onCreateView(@NonNull AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onActivityCreated(@NonNull AspectFragment fragment, Bundle savedInstanceState);

    void onActivityResult(@NonNull AspectFragment fragment, int requestCode, int resultCode, Intent data);

    void onAttach(@NonNull AspectFragment fragment, Activity activity);

    void onConfigurationChanged(@NonNull AspectFragment fragment, Configuration newConfig);

    void onCreate(@NonNull AspectFragment fragment, Bundle savedInstanceState);

    void onCreateContextMenu(@NonNull AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(@NonNull AspectFragment fragment, Menu menu, MenuInflater inflater);

    void onDestroy(@NonNull AspectFragment fragment);

    void onDestroyOptionsMenu(@NonNull AspectFragment fragment);

    void onDestroyView(@NonNull AspectFragment fragment);

    void onDetach(@NonNull AspectFragment fragment);

    void onHiddenChanged(@NonNull AspectFragment fragment, boolean hidden);

    void onInflate(@NonNull AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(@NonNull AspectFragment fragment);

    @Deprecated
    void onInflate(@NonNull AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    void onOptionsMenuClosed(@NonNull AspectFragment fragment, Menu menu);

    void onPause(@NonNull AspectFragment fragment);

    void onPrepareOptionsMenu(@NonNull AspectFragment fragment, Menu menu);

    void onResume(@NonNull AspectFragment fragment);

    void onSaveInstanceState(@NonNull AspectFragment fragment, Bundle outState);

    void onStart(@NonNull AspectFragment fragment);

    void onStop(@NonNull AspectFragment fragment);

    void onTrimMemory(@NonNull AspectFragment fragment, int level);

    void onViewCreated(@NonNull AspectFragment fragment, View view, Bundle savedInstanceState);

    void onViewStateRestored(@NonNull AspectFragment fragment, Bundle savedInstanceState);
}
