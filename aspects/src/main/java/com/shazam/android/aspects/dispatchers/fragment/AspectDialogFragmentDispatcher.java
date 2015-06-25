/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License") {
} you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed dispatchOn
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.android.aspects.dispatchers.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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

import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.fragment.DialogFragmentAspect;
import com.shazam.android.aspects.base.fragment.AspectDialogFragment;
import com.shazam.android.aspects.base.fragment.AspectFragment;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

/**
 * This dispatcher holds a list of {@link DialogFragmentAspect}s and  delegates all the lifecycle calls to
 * them.
 */
public class AspectDialogFragmentDispatcher {

    private Collection<DialogFragmentAspect> fragmentAspects;

    public AspectDialogFragmentDispatcher(
            AspectsProvider<DialogFragmentAspect> aspectsProvider) {
        this.fragmentAspects = aspectsProvider.getAspects();
    }

    public static AspectDialogFragmentDispatcher create(AspectDialogFragment fragment) {
        return new AspectDialogFragmentDispatcher(providerFor(fragment));
    }

    private static AspectsProvider<DialogFragmentAspect> providerFor(AspectDialogFragment fragment) {
        return annotatedAspectsFrom(fragment, AspectFragment.class);
    }

    public Animator dispatchOnCreateAnimator(AspectDialogFragment fragment, int transit, boolean enter, int nextAnim) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            Animator animator = aspect.onCreateAnimator(fragment, transit, enter, nextAnim);
            if (animator != null) {
                return animator;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(AspectDialogFragment fragment, MenuItem item) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            if (aspect.onContextItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(AspectDialogFragment fragment, MenuItem item) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            if (aspect.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public Dialog dispatchOnCreateDialog(AspectDialogFragment fragment, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            Dialog dialog = aspect.onCreateDialog(fragment, savedInstanceState);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    @Nullable
    public View dispatchOnCreateView(AspectDialogFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            View view = aspect.onCreateView(fragment, inflater, container, savedInstanceState);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActivityCreated(AspectDialogFragment fragment, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityCreated(fragment, savedInstanceState);
        }
    }

    public void dispatchOnActivityResult(AspectDialogFragment fragment, int requestCode, int resultCode, Intent data) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    public void dispatchOnAttach(AspectDialogFragment fragment, Activity activity) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onAttach(fragment, activity);
        }
    }

    public void dispatchOnCancel(AspectDialogFragment fragment, DialogInterface dialog) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCancel(fragment, dialog);
        }
    }

    public void dispatchOnConfigurationChanged(AspectDialogFragment fragment, Configuration newConfig) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onConfigurationChanged(fragment, newConfig);
        }
    }

    public void dispatchOnCreate(AspectDialogFragment fragment, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreate(fragment, savedInstanceState);
        }
    }

    public void dispatchOnCreateContextMenu(AspectDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateContextMenu(fragment, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateOptionsMenu(AspectDialogFragment fragment, Menu menu, MenuInflater inflater) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateOptionsMenu(fragment, menu, inflater);
        }
    }

    public void dispatchOnDestroy(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroy(fragment);
        }
    }

    public void dispatchOnDestroyOptionsMenu(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyOptionsMenu(fragment);
        }
    }

    public void dispatchOnDestroyView(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyView(fragment);
        }
    }

    public void dispatchOnDetach(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDetach(fragment);
        }
    }

    public void dispatchOnDismiss(AspectDialogFragment fragment, DialogInterface dialog) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDismiss(fragment, dialog);
        }
    }

    public void dispatchOnSaveInstanceState(AspectDialogFragment fragment, Bundle outState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onSaveInstanceState(fragment, outState);
        }
    }

    public void dispatchOnStart(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onStart(fragment);
        }
    }

    public void dispatchOnStop(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onStop(fragment);
        }
    }

    public void dispatchOnHiddenChanged(AspectDialogFragment fragment, boolean hidden) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onHiddenChanged(fragment, hidden);
        }
    }

    public void dispatchOnInflate(AspectDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, activity, attrs, savedInstanceState);
        }
    }

    public void dispatchOnInflate(AspectDialogFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, attrs, savedInstanceState);
        }
    }

    public void dispatchOnLowMemory(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onLowMemory(fragment);
        }
    }

    public void dispatchOnOptionsMenuClosed(AspectDialogFragment fragment, Menu menu) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onOptionsMenuClosed(fragment, menu);
        }
    }

    public void dispatchOnPause(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onPause(fragment);
        }
    }

    public void dispatchOnPrepareOptionsMenu(AspectDialogFragment fragment, Menu menu) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onPrepareOptionsMenu(fragment, menu);
        }
    }

    public void dispatchOnResume(AspectDialogFragment fragment) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onResume(fragment);
        }
    }

    public void dispatchOnTrimMemory(AspectDialogFragment fragment, int level) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onTrimMemory(fragment, level);
        }
    }

    public void dispatchOnViewCreated(AspectDialogFragment fragment, View view, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    public void dispatchOnViewStateRestored(AspectDialogFragment fragment, Bundle savedInstanceState) {
        for (DialogFragmentAspect aspect : fragmentAspects) {
            aspect.onViewStateRestored(fragment, savedInstanceState);
        }
    }
}
