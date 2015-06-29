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
import android.view.animation.Animation;

import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.aspects.fragment.SupportDialogFragmentAspect;
import com.shazam.android.aspects.base.fragment.AspectSupportDialogFragment;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

/**
 * This dispatcher holds a list of {@link SupportDialogFragmentAspect}s and  delegates all the lifecycle calls to
 * them.
 */
public class AspectSupportDialogFragmentDispatcher {

    private Collection<SupportDialogFragmentAspect> fragmentAspects;

    public AspectSupportDialogFragmentDispatcher(
            AspectsProvider<SupportDialogFragmentAspect> aspectsProvider) {
        this.fragmentAspects = aspectsProvider.getAspects();
    }

    public static AspectSupportDialogFragmentDispatcher create(AspectSupportDialogFragment fragment) {
        return new AspectSupportDialogFragmentDispatcher(providerFor(fragment));
    }

    private static AspectsProvider<SupportDialogFragmentAspect> providerFor(AspectSupportDialogFragment fragment) {
        return annotatedAspectsFrom(fragment, SupportDialogFragmentAspect.class, AspectSupportDialogFragment.class);
    }

    public void dispatchOnActivityCreated(AspectSupportDialogFragment fragment, Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityCreated(fragment, savedInstanceState);
        }
    }

    public void dispatchOnAttach(AspectSupportDialogFragment fragment, Activity activity) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onAttach(fragment, activity);
        }
    }

    public void dispatchOnCancel(AspectSupportDialogFragment fragment, DialogInterface dialog) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCancel(fragment, dialog);
        }
    }

    public void dispatchOnCreate(AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreate(fragment, savedInstanceState);
        }
    }

    public Dialog dispatchOnCreateDialog(AspectSupportDialogFragment fragment, Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            Dialog dialog = aspect.onCreateDialog(fragment, savedInstanceState);
            if (dialog != null) {
                return dialog;
            }
        }
        return null;
    }

    public void dispatchOnDestroyView(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyView(fragment);
        }
    }

    public void dispatchOnDetach(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDetach(fragment);
        }
    }

    public void dispatchOnDismiss(AspectSupportDialogFragment fragment, DialogInterface dialog) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDismiss(fragment, dialog);
        }
    }

    public void dispatchOnSaveInstanceState(AspectSupportDialogFragment fragment, Bundle outState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onSaveInstanceState(fragment, outState);
        }
    }

    public void dispatchOnStart(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onStart(fragment);
        }
    }

    public void dispatchOnStop(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onStop(fragment);
        }
    }

    public void dispatchOnActivityResult(AspectSupportDialogFragment fragment, int requestCode, int resultCode, Intent data) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    public void dispatchOnConfigurationChanged(AspectSupportDialogFragment fragment, Configuration newConfig) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onConfigurationChanged(fragment, newConfig);
        }
    }

    public boolean dispatchOnContextItemSelected(AspectSupportDialogFragment fragment, MenuItem item) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            if (aspect.onContextItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public Animation dispatchOnCreateAnimation(AspectSupportDialogFragment fragment, int transit, boolean enter, int nextAnim) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            Animation animation = aspect.onCreateAnimation(fragment, transit, enter, nextAnim);
            if (animation != null) {
                return animation;
            }
        }
        return null;
    }

    public void dispatchOnCreateContextMenu(AspectSupportDialogFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateContextMenu(fragment, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateOptionsMenu(AspectSupportDialogFragment fragment, Menu menu, MenuInflater inflater) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateOptionsMenu(fragment, menu, inflater);
        }
    }

    @Nullable
    public View dispatchOnCreateView(AspectSupportDialogFragment fragment, LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            View view = aspect.onCreateView(fragment, inflater, container, savedInstanceState);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnDestroy(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroy(fragment);
        }
    }

    public void dispatchOnDestroyOptionsMenu(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyOptionsMenu(fragment);
        }
    }

    public void dispatchOnHiddenChanged(AspectSupportDialogFragment fragment, boolean hidden) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onHiddenChanged(fragment, hidden);
        }
    }

    public void dispatchOnInflate(AspectSupportDialogFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, activity, attrs, savedInstanceState);
        }
    }

    public void dispatchOnLowMemory(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onLowMemory(fragment);
        }
    }

    public boolean dispatchOnOptionsItemSelected(AspectSupportDialogFragment fragment, MenuItem item) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            if (aspect.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOnOptionsMenuClosed(AspectSupportDialogFragment fragment, Menu menu) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onOptionsMenuClosed(fragment, menu);
        }
    }

    public void dispatchOnPause(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onPause(fragment);
        }
    }

    public void dispatchOnPrepareOptionsMenu(AspectSupportDialogFragment fragment, Menu menu) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onPrepareOptionsMenu(fragment, menu);
        }
    }

    public void dispatchOnResume(AspectSupportDialogFragment fragment) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onResume(fragment);
        }
    }

    public void dispatchOnViewCreated(AspectSupportDialogFragment fragment, View view, @Nullable Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    public void dispatchOnViewStateRestored(AspectSupportDialogFragment fragment, @Nullable Bundle savedInstanceState) {
        for (SupportDialogFragmentAspect aspect : fragmentAspects) {
            aspect.onViewStateRestored(fragment, savedInstanceState);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, fragmentAspects);
    }
}
