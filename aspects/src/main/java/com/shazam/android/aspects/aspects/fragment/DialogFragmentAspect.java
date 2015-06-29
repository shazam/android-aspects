/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (@NonNull AspectDialogFragment fragment, the "License"); you may not use this file except in compliance with
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

import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.base.fragment.AspectDialogFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectDialogFragment} when they are listed in the {@link Aspects#aspects()}
 * parameter.
 */
public interface DialogFragmentAspect extends Aspect<AspectDialogFragment> {

    Animator onCreateAnimator(@NonNull AspectDialogFragment fragment, int transit, boolean enter, int nextAnim);

    boolean onContextItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item);

    boolean onOptionsItemSelected(@NonNull AspectDialogFragment fragment, MenuItem item);

    Dialog onCreateDialog(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    @Nullable
    View onCreateView(@NonNull AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onActivityCreated(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    void onActivityResult(@NonNull AspectDialogFragment fragment, int requestCode, int resultCode, Intent data);

    void onAttach(@NonNull AspectDialogFragment fragment, Activity activity);

    void onCancel(@NonNull AspectDialogFragment fragment, DialogInterface dialog);

    void onConfigurationChanged(@NonNull AspectDialogFragment fragment, Configuration newConfig);

    void onCreate(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);

    void onCreateContextMenu(@NonNull AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu, MenuInflater inflater);

    void onDestroy(@NonNull AspectDialogFragment fragment);

    void onDestroyOptionsMenu(@NonNull AspectDialogFragment fragment);

    void onDestroyView(@NonNull AspectDialogFragment fragment);

    void onDetach(@NonNull AspectDialogFragment fragment);

    void onDismiss(@NonNull AspectDialogFragment fragment, DialogInterface dialog);

    void onSaveInstanceState(@NonNull AspectDialogFragment fragment, @NonNull Bundle outState);

    void onStart(@NonNull AspectDialogFragment fragment);

    void onStop(@NonNull AspectDialogFragment fragment);

    void onHiddenChanged(@NonNull AspectDialogFragment fragment, boolean hidden);

    void onInflate(@NonNull AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onInflate(@NonNull AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(@NonNull AspectDialogFragment fragment);

    void onOptionsMenuClosed(@NonNull AspectDialogFragment fragment, Menu menu);

    void onPause(@NonNull AspectDialogFragment fragment);

    void onPrepareOptionsMenu(@NonNull AspectDialogFragment fragment, Menu menu);

    void onResume(@NonNull AspectDialogFragment fragment);

    void onTrimMemory(@NonNull AspectDialogFragment fragment, int level);

    void onViewCreated(@NonNull AspectDialogFragment fragment, View view, Bundle savedInstanceState);

    void onViewStateRestored(@NonNull AspectDialogFragment fragment, Bundle savedInstanceState);
}
