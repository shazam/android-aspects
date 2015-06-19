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

import com.shazam.android.aspects.base.fragment.AspectFragment;

/**
 * This class is a no operation implementation of the {@link FragmentAspect} interface.
 * It allows classes to extend this instead of implementing {@link FragmentAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpFragmentAspect implements FragmentAspect {

    @Override
    public Animator onCreateAnimator(AspectFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(AspectFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(AspectFragment fragment, MenuItem item) {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(AspectFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResult(AspectFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onAttach(AspectFragment fragment, Activity activity) {
    }

    @Override
    public void onConfigurationChanged(AspectFragment fragment, Configuration newConfig) {
    }

    @Override
    public void onCreate(AspectFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onCreateContextMenu(AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(AspectFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onDestroy(AspectFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(AspectFragment fragment) {
    }

    @Override
    public void onDestroyView(AspectFragment fragment) {
    }

    @Override
    public void onDetach(AspectFragment fragment) {
    }

    @Override
    public void onHiddenChanged(AspectFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(AspectFragment fragment) {
    }

    @Override
    public void onInflate(AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onOptionsMenuClosed(AspectFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(AspectFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(AspectFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(AspectFragment fragment) {
    }

    @Override
    public void onSaveInstanceState(AspectFragment fragment, Bundle outState) {
    }

    @Override
    public void onStart(AspectFragment fragment) {
    }

    @Override
    public void onStop(AspectFragment fragment) {
    }

    @Override
    public void onTrimMemory(AspectFragment fragment, int level) {
    }

    @Override
    public void onViewCreated(AspectFragment fragment, View view, Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(AspectFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public Class<AspectFragment> classActingOn() {
        return AspectFragment.class;
    }
}
