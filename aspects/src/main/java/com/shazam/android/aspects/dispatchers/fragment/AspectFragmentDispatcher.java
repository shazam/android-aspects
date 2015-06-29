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
package com.shazam.android.aspects.dispatchers.fragment;

import android.animation.Animator;
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

import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.aspects.fragment.FragmentAspect;
import com.shazam.android.aspects.base.fragment.AspectFragment;

import java.util.Collection;

import static com.shazam.android.aspects.aspects.AnnotatedAspectsProvider.annotatedAspectsFrom;

/**
 * This dispatcher holds a list of {@link FragmentAspect}s and  delegates all the lifecycle calls to
 * them.
 */
public class AspectFragmentDispatcher {

    private Collection<FragmentAspect> fragmentAspects;

    public AspectFragmentDispatcher(
            AspectsProvider<FragmentAspect> aspectsProvider) {
        this.fragmentAspects = aspectsProvider.getAspects();
    }

    public static AspectFragmentDispatcher create(@NonNull AspectFragment fragment) {
        return new AspectFragmentDispatcher(providerFor(fragment));
    }

    private static AspectsProvider<FragmentAspect> providerFor(@NonNull AspectFragment fragment) {
        return annotatedAspectsFrom(fragment, FragmentAspect.class, AspectFragment.class);
    }

    public Animator dispatchOnCreateAnimator(@NonNull AspectFragment fragment, int transit, boolean enter, int nextAnim) {
        for (FragmentAspect aspect : fragmentAspects) {
            Animator animator = aspect.onCreateAnimator(fragment, transit, enter, nextAnim);
            if (animator != null) {
                return animator;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(@NonNull AspectFragment fragment, MenuItem item) {
        for (FragmentAspect aspect : fragmentAspects) {
            if (aspect.onContextItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(@NonNull AspectFragment fragment, MenuItem item) {
        for (FragmentAspect aspect : fragmentAspects) {
            if (aspect.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public View dispatchOnCreateView(@NonNull AspectFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            View view = aspect.onCreateView(fragment, inflater, container, savedInstanceState);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActivityCreated(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onActivityCreated(fragment, savedInstanceState);
        }
    }

    public void dispatchOnActivityResult(@NonNull AspectFragment fragment, int requestCode, int resultCode, Intent data) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    public void dispatchOnAttach(@NonNull AspectFragment fragment, Activity activity) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onAttach(fragment, activity);
        }
    }

    public void dispatchOnConfigurationChanged(@NonNull AspectFragment fragment, Configuration newConfig) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onConfigurationChanged(fragment, newConfig);
        }
    }

    public void dispatchOnCreate(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onCreate(fragment, savedInstanceState);
        }
    }

    public void dispatchOnCreateContextMenu(@NonNull AspectFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onCreateContextMenu(fragment, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateOptionsMenu(@NonNull AspectFragment fragment, Menu menu, MenuInflater inflater) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onCreateOptionsMenu(fragment, menu, inflater);
        }
    }

    public void dispatchOnDestroy(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onDestroy(fragment);
        }
    }

    public void dispatchOnDestroyOptionsMenu(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyOptionsMenu(fragment);
        }
    }

    public void dispatchOnDestroyView(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyView(fragment);
        }
    }

    public void dispatchOnDetach(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onDetach(fragment);
        }
    }

    public void dispatchOnHiddenChanged(@NonNull AspectFragment fragment, boolean hidden) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onHiddenChanged(fragment, hidden);
        }
    }

    public void dispatchOnInflate(@NonNull AspectFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, activity, attrs, savedInstanceState);
        }
    }

    public void dispatchOnLowMemory(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onLowMemory(fragment);
        }
    }

    public void dispatchOnInflate(@NonNull AspectFragment fragment, AttributeSet attrs, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, attrs, savedInstanceState);
        }
    }

    public void dispatchOnOptionsMenuClosed(@NonNull AspectFragment fragment, Menu menu) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onOptionsMenuClosed(fragment, menu);
        }
    }

    public void dispatchOnPause(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onPause(fragment);
        }
    }

    public void dispatchOnPrepareOptionsMenu(@NonNull AspectFragment fragment, Menu menu) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onPrepareOptionsMenu(fragment, menu);
        }
    }

    public void dispatchOnResume(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onResume(fragment);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectFragment fragment, Bundle outState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onSaveInstanceState(fragment, outState);
        }
    }

    public void dispatchOnStart(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onStart(fragment);
        }
    }

    public void dispatchOnStop(@NonNull AspectFragment fragment) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onStop(fragment);
        }
    }

    public void dispatchOnTrimMemory(@NonNull AspectFragment fragment, int level) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onTrimMemory(fragment, level);
        }
    }

    public void dispatchOnViewCreated(@NonNull AspectFragment fragment, View view, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    public void dispatchOnViewStateRestored(@NonNull AspectFragment fragment, Bundle savedInstanceState) {
        for (FragmentAspect aspect : fragmentAspects) {
            aspect.onViewStateRestored(fragment, savedInstanceState);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, fragmentAspects);
    }
}
