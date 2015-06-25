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
import android.view.animation.Animation;

import com.shazam.android.aspects.base.fragment.AspectSupportDialogFragment;

public class NoOpSupportDialogFragmentAspect implements SupportDialogFragmentAspect {

    @Override
    public void onActivityCreated(AspectSupportDialogFragment fragment, Bundle savedInstanceState) {
    }

    @Override
    public void onAttach(AspectSupportDialogFragment fragment, Activity activity) {
    }

    @Override
    public void onCancel(AspectSupportDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onCreate(AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public Dialog onCreateDialog(AspectSupportDialogFragment fragment, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onDestroyView(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onDetach(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onDismiss(AspectSupportDialogFragment fragment, DialogInterface dialog) {
    }

    @Override
    public void onSaveInstanceState(AspectSupportDialogFragment fragment, Bundle outState) {
    }

    @Override
    public void onStart(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onStop(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onActivityResult(AspectSupportDialogFragment fragment, int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onConfigurationChanged(AspectSupportDialogFragment fragment, Configuration newConfig) {
    }

    @Override
    public boolean onContextItemSelected(AspectSupportDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public Animation onCreateAnimation(AspectSupportDialogFragment fragment, int transit, boolean enter, int nextAnim) {
        return null;
    }

    @Override
    public void onCreateContextMenu(AspectSupportDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    @Override
    public void onCreateOptionsMenu(AspectSupportDialogFragment fragment, Menu menu, MenuInflater inflater) {
    }

    @Nullable
    @Override
    public View onCreateView(AspectSupportDialogFragment fragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onDestroy(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onDestroyOptionsMenu(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onHiddenChanged(AspectSupportDialogFragment fragment, boolean hidden) {
    }

    @Override
    public void onInflate(AspectSupportDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    }

    @Override
    public void onLowMemory(AspectSupportDialogFragment fragment) {
    }

    @Override
    public boolean onOptionsItemSelected(AspectSupportDialogFragment fragment, MenuItem item) {
        return false;
    }

    @Override
    public void onOptionsMenuClosed(AspectSupportDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onPause(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onPrepareOptionsMenu(AspectSupportDialogFragment fragment, Menu menu) {
    }

    @Override
    public void onResume(AspectSupportDialogFragment fragment) {
    }

    @Override
    public void onViewCreated(AspectSupportDialogFragment fragment, View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onViewStateRestored(AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState) {
    }

    @NonNull
    @Override
    public Class<AspectSupportDialogFragment> classActingOn() {
        return AspectSupportDialogFragment.class;
    }
}
