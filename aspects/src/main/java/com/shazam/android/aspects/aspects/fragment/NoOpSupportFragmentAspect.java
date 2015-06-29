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
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.shazam.android.aspects.base.fragment.AspectSupportFragment;

/**
 * This class is a no operation implementation of the {@link FragmentAspect} interface.
 * It allows classes to extend this instead of implementing {@link FragmentAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpSupportFragmentAspect implements SupportFragmentAspect {

    @Override
    public Animation onCreateAnimation(@NonNull AspectSupportFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item) {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull AspectSupportFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResult(@NonNull AspectSupportFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onAttach(@NonNull AspectSupportFragment fragment, Activity activity) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectSupportFragment fragment, Configuration newConfig) {
    }

    @Override
    public void onCreate(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectSupportFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onDestroy(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onDestroyView(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onDetach(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onHiddenChanged(@NonNull AspectSupportFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(@NonNull AspectSupportFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectSupportFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectSupportFragment fragment, Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onStop(@NonNull AspectSupportFragment fragment) {
    }

    @Override
    public void onViewCreated(@NonNull AspectSupportFragment fragment, View view, Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(@NonNull AspectSupportFragment fragment, Bundle savedInstanceState) {
    }

    @NonNull
    @Override
    public Class<AspectSupportFragment> classActingOn() {
        return AspectSupportFragment.class;
    }
}
