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
import android.app.Dialog;
import android.content.DialogInterface;
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

import com.shazam.android.aspects.base.fragment.AspectDialogFragment;

/**
 * This class is a no operation implementation of the {@link DialogFragmentAspect} interface.
 * It allows classes to extend this instead of implementing {@link DialogFragmentAspect} when
 * they only need to implement only specific methods.
 */
public class NoOpDialogFragmentAspect implements DialogFragmentAspect {
    
    @Override
    public Animator onCreateAnimator(AspectDialogFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(AspectDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(AspectDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public Dialog onCreateDialog(AspectDialogFragment fragment, Bundle savedInstanceState) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResult(AspectDialogFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onAttach(AspectDialogFragment fragment, Activity activity) {
    }

    @Override
    public void onCancel(AspectDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onConfigurationChanged(AspectDialogFragment fragment, Configuration newConfig) {
    }

    @Override
    public void onCreate(AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onCreateContextMenu(AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(AspectDialogFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onDestroy(AspectDialogFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(AspectDialogFragment fragment) {
    }

    @Override
    public void onDestroyView(AspectDialogFragment fragment) {
    }

    @Override
    public void onDetach(AspectDialogFragment fragment) {
    }

    @Override
    public void onDismiss(AspectDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onSaveInstanceState(AspectDialogFragment fragment, Bundle outState) {
    }

    @Override
    public void onStart(AspectDialogFragment fragment) {
    }

    @Override
    public void onStop(AspectDialogFragment fragment) {
    }

    @Override
    public void onHiddenChanged(AspectDialogFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onInflate(AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(AspectDialogFragment fragment) {
    }

    @Override
    public void onOptionsMenuClosed(AspectDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(AspectDialogFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(AspectDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(AspectDialogFragment fragment) {
    }

    @Override
    public void onTrimMemory(AspectDialogFragment fragment, int level) {
    }

    @Override
    public void onViewCreated(AspectDialogFragment fragment, View view, Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @NonNull
    @Override
    public Class<AspectDialogFragment> classActingOn() {
        return AspectDialogFragment.class;
    }
}
