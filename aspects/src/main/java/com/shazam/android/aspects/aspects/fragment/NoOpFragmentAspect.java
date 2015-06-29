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

import com.shazam.android.aspects.base.fragment.AspectFragment;

/**
 * This class is a no operation implementation of the {@link FragmentAspect} interface.
 * It allows classes to extend this instead of implementing {@link FragmentAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpFragmentAspect implements FragmentAspect {

    @Override
    public Animator onCreateAnimator(@NonNull AspectFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectFragment fragment, MenuItem item) {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResult(@NonNull AspectFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onAttach(@NonNull AspectFragment fragment, Activity activity) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectFragment fragment, Configuration newConfig) {
    }

    @Override
    public void onCreate(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(@NonNull AspectFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onDestroy(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onDestroyView(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onDetach(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onHiddenChanged(@NonNull AspectFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(@NonNull AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(@NonNull AspectFragment fragment) {
    }

    @Override
    @Deprecated
    public void onInflate(@NonNull AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull AspectFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectFragment fragment, Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onStop(@NonNull AspectFragment fragment) {
    }

    @Override
    public void onTrimMemory(@NonNull AspectFragment fragment, int level) {
    }

    @Override
    public void onViewCreated(@NonNull AspectFragment fragment, View view, Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
    }

    @NonNull
    @Override
    public Class<AspectFragment> classActingOn() {
        return AspectFragment.class;
    }
}
