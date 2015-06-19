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
package com.shazam.android.aspects.base.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
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
import com.shazam.android.aspects.dispatchers.fragment.AspectFragmentDispatcher;
import com.shazam.android.aspects.aspects.fragment.FragmentAspect;

/**
 * This is the base fragment for lifecycle delegation. Fragments should extend this class and then
 * annotate themselves with the {@link Aspects} annotation to register
 * {@link FragmentAspect}s
 */
public class AspectFragment extends Fragment {
    private AspectFragmentDispatcher dispatcher;

    @SuppressWarnings("UnusedDeclaration")
    public AspectFragment() {
        this.dispatcher = AspectFragmentDispatcher.create(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        dispatcher.dispatchOnLowMemory(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dispatcher.dispatchOnConfigurationChanged(this, newConfig);
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Animator animator = super.onCreateAnimator(transit, enter, nextAnim);
        return animator != null ? animator : dispatcher.dispatchOnCreateAnimator(this, transit, enter, nextAnim);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item) || dispatcher.dispatchOnContextItemSelected(this, item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item) || dispatcher.dispatchOnOptionsItemSelected(this, item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view != null ? view : dispatcher.dispatchOnCreateView(this, inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dispatcher.dispatchOnActivityCreated(this, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dispatcher.dispatchOnActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dispatcher.dispatchOnAttach(this, activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dispatcher.dispatchOnCreate(this, savedInstanceState);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        dispatcher.dispatchOnCreateContextMenu(this, menu, v, menuInfo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        dispatcher.dispatchOnCreateOptionsMenu(this, menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dispatcher.dispatchOnDestroy(this);
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        dispatcher.dispatchOnDestroyOptionsMenu(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dispatcher.dispatchOnDestroyView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dispatcher.dispatchOnDetach(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        dispatcher.dispatchOnHiddenChanged(this, hidden);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        dispatcher.dispatchOnInflate(this, activity, attrs, savedInstanceState);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        dispatcher.dispatchOnOptionsMenuClosed(this, menu);
    }

    @Override
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(attrs, savedInstanceState);
        dispatcher.dispatchOnInflate(this, attrs, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        dispatcher.dispatchOnPause(this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        dispatcher.dispatchOnPrepareOptionsMenu(this, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        dispatcher.dispatchOnResume(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        dispatcher.dispatchOnSaveInstanceState(this, outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        dispatcher.dispatchOnStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        dispatcher.dispatchOnStop(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        dispatcher.dispatchOnTrimMemory(this, level);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dispatcher.dispatchOnViewCreated(this, view, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        dispatcher.dispatchOnViewStateRestored(this, savedInstanceState);
    }
}
