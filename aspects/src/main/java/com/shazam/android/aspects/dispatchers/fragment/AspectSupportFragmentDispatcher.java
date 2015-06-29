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

import com.shazam.android.aspects.aspects.AnnotatedAspectsProvider;
import com.shazam.android.aspects.aspects.Aspect;
import com.shazam.android.aspects.aspects.AspectsProvider;
import com.shazam.android.aspects.aspects.FilteredAspectsProvider;
import com.shazam.android.aspects.aspects.fragment.SupportFragmentAspect;
import com.shazam.android.aspects.base.fragment.AspectSupportFragment;

import java.util.Collection;

/**
 * This dispatcher holds a list of {@link SupportFragmentAspect}s and  delegates all the lifecycle 
 * calls to all of them.
 */
public class AspectSupportFragmentDispatcher {

    private Collection<SupportFragmentAspect> fragmentAspects;

    public AspectSupportFragmentDispatcher(AspectsProvider<SupportFragmentAspect> aspectsProvider) {
        this.fragmentAspects = aspectsProvider.getAspects();
    }

    public static AspectSupportFragmentDispatcher create(@NonNull AspectSupportFragment fragment) {
        return new AspectSupportFragmentDispatcher(providerFor(fragment));
    }

    private static AspectsProvider<SupportFragmentAspect> providerFor(@NonNull AspectSupportFragment fragment) {
        return AnnotatedAspectsProvider.annotatedAspectsFrom(fragment, SupportFragmentAspect.class, AspectSupportFragment.class);
    }

    public Animation dispatchOnCreateAnimation(@NonNull AspectSupportFragment fragment, int transit, boolean enter, int nextAnim) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            Animation animation = aspect.onCreateAnimation(fragment, transit, enter, nextAnim);
            if (animation != null) {
                return animation;
            }
        }
        return null;
    }

    public boolean dispatchOnContextItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            if (aspect.onContextItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchOnOptionsItemSelected(@NonNull AspectSupportFragment fragment, MenuItem item) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            if (aspect.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public View dispatchOnCreateView(@NonNull AspectSupportFragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            View view = aspect.onCreateView(fragment, inflater, container, savedInstanceState);
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    public void dispatchOnActivityCreated(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityCreated(fragment, savedInstanceState);
        }
    }

    public void dispatchOnActivityResult(@NonNull AspectSupportFragment fragment, int requestCode, int resultCode, Intent data) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    public void dispatchOnAttach(@NonNull AspectSupportFragment fragment, Activity activity) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onAttach(fragment, activity);
        }
    }

    public void dispatchOnConfigurationChanged(@NonNull AspectSupportFragment fragment, Configuration newConfig) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onConfigurationChanged(fragment, newConfig);
        }
    }

    public void dispatchOnCreate(@NonNull AspectSupportFragment fragment, @Nullable Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onCreate(fragment, savedInstanceState);
        }
    }

    public void dispatchOnCreateContextMenu(@NonNull AspectSupportFragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateContextMenu(fragment, menu, v, menuInfo);
        }
    }

    public void dispatchOnCreateOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu, MenuInflater inflater) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onCreateOptionsMenu(fragment, menu, inflater);
        }
    }

    public void dispatchOnDestroy(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroy(fragment);
        }
    }

    public void dispatchOnDestroyOptionsMenu(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyOptionsMenu(fragment);
        }
    }

    public void dispatchOnDestroyView(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onDestroyView(fragment);
        }
    }

    public void dispatchOnDetach(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onDetach(fragment);
        }
    }

    public void dispatchOnHiddenChanged(@NonNull AspectSupportFragment fragment, boolean hidden) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onHiddenChanged(fragment, hidden);
        }
    }

    public void dispatchOnInflate(@NonNull AspectSupportFragment fragment, Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onInflate(fragment, activity, attrs, savedInstanceState);
        }
    }

    public void dispatchOnLowMemory(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onLowMemory(fragment);
        }
    }

    public void dispatchOnOptionsMenuClosed(@NonNull AspectSupportFragment fragment, Menu menu) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onOptionsMenuClosed(fragment, menu);
        }
    }

    public void dispatchOnPause(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onPause(fragment);
        }
    }

    public void dispatchOnPrepareOptionsMenu(@NonNull AspectSupportFragment fragment, Menu menu) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onPrepareOptionsMenu(fragment, menu);
        }
    }

    public void dispatchOnResume(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onResume(fragment);
        }
    }

    public void dispatchOnSaveInstanceState(@NonNull AspectSupportFragment fragment, Bundle outState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onSaveInstanceState(fragment, outState);
        }
    }

    public void dispatchOnStart(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onStart(fragment);
        }
    }

    public void dispatchOnStop(@NonNull AspectSupportFragment fragment) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onStop(fragment);
        }
    }

    public void dispatchOnViewCreated(@NonNull AspectSupportFragment fragment, View view, Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    public void dispatchOnViewStateRestored(@NonNull AspectSupportFragment fragment, Bundle savedInstanceState) {
        for (SupportFragmentAspect aspect : fragmentAspects) {
            aspect.onViewStateRestored(fragment, savedInstanceState);
        }
    }

    public  <A extends Aspect<?>> AspectsProvider<A> getAspectProvider(final Class<A> aspectClass) {
        return new FilteredAspectsProvider<>(aspectClass, fragmentAspects);
    }
}
