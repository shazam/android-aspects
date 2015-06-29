/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (@NonNull AspectSupportDialogFragment fragment, AspectDialogFragment fragment, the "License"); you may not use this file except in compliance with
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

import com.shazam.android.aspects.annotations.Aspects;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.base.fragment.AspectSupportDialogFragment;

/**
 * This is the interface that classes must implement in order to be able to receive lifecycle
 * callbacks from the {@link AspectSupportDialogFragment} when they are listed in the {@link Aspects#aspects()}
 * parameter.
 */
public interface SupportDialogFragmentAspect extends Aspect<AspectSupportDialogFragment> {

    void onActivityCreated(@NonNull AspectSupportDialogFragment fragment, Bundle savedInstanceState);

    void onAttach(@NonNull AspectSupportDialogFragment fragment, Activity activity);

    void onCancel(@NonNull AspectSupportDialogFragment fragment, DialogInterface dialog);

    void onCreate(@NonNull AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState);

    Dialog onCreateDialog(@NonNull AspectSupportDialogFragment fragment, Bundle savedInstanceState);

    void onDestroyView(@NonNull AspectSupportDialogFragment fragment);

    void onDetach(@NonNull AspectSupportDialogFragment fragment);

    void onDismiss(@NonNull AspectSupportDialogFragment fragment, DialogInterface dialog);

    void onSaveInstanceState(@NonNull AspectSupportDialogFragment fragment, Bundle outState);

    void onStart(@NonNull AspectSupportDialogFragment fragment);

    void onStop(@NonNull AspectSupportDialogFragment fragment);

    void onActivityResult(@NonNull AspectSupportDialogFragment fragment, int requestCode, int resultCode, Intent data);

    void onConfigurationChanged(@NonNull AspectSupportDialogFragment fragment, Configuration newConfig);

    boolean onContextItemSelected(@NonNull AspectSupportDialogFragment fragment, MenuItem item);

    Animation onCreateAnimation(@NonNull AspectSupportDialogFragment fragment, int transit, boolean enter, int nextAnim);

    void onCreateContextMenu(@NonNull AspectSupportDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);

    void onCreateOptionsMenu(@NonNull AspectSupportDialogFragment fragment, Menu menu, MenuInflater inflater);

    @Nullable
    View onCreateView(@NonNull AspectSupportDialogFragment fragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    void onDestroy(@NonNull AspectSupportDialogFragment fragment);

    void onDestroyOptionsMenu(@NonNull AspectSupportDialogFragment fragment);

    void onHiddenChanged(@NonNull AspectSupportDialogFragment fragment, boolean hidden);

    void onInflate(@NonNull AspectSupportDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState);

    void onLowMemory(@NonNull AspectSupportDialogFragment fragment);

    boolean onOptionsItemSelected(@NonNull AspectSupportDialogFragment fragment, MenuItem item);

    void onOptionsMenuClosed(@NonNull AspectSupportDialogFragment fragment, Menu menu);

    void onPause(@NonNull AspectSupportDialogFragment fragment);

    void onPrepareOptionsMenu(@NonNull AspectSupportDialogFragment fragment, Menu menu);

    void onResume(@NonNull AspectSupportDialogFragment fragment);

    void onViewCreated(@NonNull AspectSupportDialogFragment fragment, View view, @Nullable Bundle savedInstanceState);

    void onViewStateRestored(@NonNull AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState);
}
