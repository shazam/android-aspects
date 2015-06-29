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
    public Animator onCreateAnimator(@NonNull AspectDialogFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public boolean onContextItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public Dialog onCreateDialog(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResult(@NonNull AspectDialogFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onAttach(@NonNull AspectDialogFragment fragment, Activity activity) {
    }

    @Override
    public void onCancel(@NonNull AspectDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onConfigurationChanged(@NonNull AspectDialogFragment fragment, Configuration newConfig) {
    }

    @Override
    public void onCreate(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onCreateContextMenu(@NonNull AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onDestroy(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onDestroyView(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onDetach(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onDismiss(@NonNull AspectDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onSaveInstanceState(@NonNull AspectDialogFragment fragment, @NonNull Bundle outState) {
    }

    @Override
    public void onStart(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onStop(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onHiddenChanged(@NonNull AspectDialogFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(@NonNull AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onInflate(@NonNull AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onOptionsMenuClosed(@NonNull AspectDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(@NonNull AspectDialogFragment fragment) {
    }

    @Override
    public void onTrimMemory(@NonNull AspectDialogFragment fragment, int level) {
    }

    @Override
    public void onViewCreated(@NonNull AspectDialogFragment fragment, View view, Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState) {
    }

    @NonNull
    @Override
    public Class<AspectDialogFragment> classActingOn() {
        return AspectDialogFragment.class;
    }
}
