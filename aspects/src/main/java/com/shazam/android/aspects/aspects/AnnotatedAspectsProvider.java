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
package com.shazam.android.aspects.aspects;

import com.shazam.android.aspects.annotations.AnnotationRetriever;
import com.shazam.android.aspects.annotations.Aspects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.shazam.android.aspects.annotations.RecursiveAnnotationRetriever.recursiveAnnotationRetriever;

/**
 * This class retrieves aspects of type {@link A} listed in the {@link Aspects#aspects()}
 * parameter on the object of type {@link O}
 */
public final class AnnotatedAspectsProvider<O, A extends Aspect> implements AspectsProvider<A> {

    private O annotatedObject;
    private Class<A> aspectClassFilter;
    private AnnotationRetriever<Aspects> annotationRetriever;
    private Class<?> classAppliedTo;

    private AnnotatedAspectsProvider(O annotatedObject,
                                     Class<A> aspectClassFilter,
                                     AnnotationRetriever<Aspects> annotationRetriever,
                                     Class<?> classAppliedTo) {
        this.annotatedObject = annotatedObject;
        this.aspectClassFilter = aspectClassFilter;
        this.annotationRetriever = annotationRetriever;
        this.classAppliedTo = classAppliedTo;
    }

    public static <OO, AA extends Aspect> AspectsProvider<AA>
    annotatedAspectsFrom(OO annotatedObject, Class<AA> aspectClassFilter, Class<?> classAppliedTo) {
        return annotatedAspectsFrom(annotatedObject,
                aspectClassFilter,
                recursiveAnnotationRetriever(Aspects.class),
                classAppliedTo);
    }

    public static <OO, AA extends Aspect> AspectsProvider<AA>
    annotatedAspectsFrom(OO annotatedObject,
                         Class<AA> aspectClassFilter,
                         AnnotationRetriever<Aspects> annotationRetriever,
                         Class<?> classAppliedTo) {
        return new AnnotatedAspectsProvider<>(annotatedObject, aspectClassFilter,
                annotationRetriever, classAppliedTo);
    }

    public Collection<A> getAspects() {
        Collection<A> aspects = new ArrayList<>();
        List<Aspects> annotations = annotationRetriever.retrieveAnnotations(annotatedObject);
        for (Aspects annotation : annotations) {
            for (Class<? extends Aspect> aspectClass : annotation.aspects()) {
                addAspect(aspectClass, aspects);
            }
        }
        return aspects;
    }

    @SuppressWarnings("unchecked")
    private void addAspect(Class<? extends Aspect> aspectClass, Collection<A> aspects) {
        if (!aspectClassFilter.isAssignableFrom(aspectClass)) {
            return;
        }
        //noinspection OverlyBroadCatchBlock
        try {
            A aspect = (A) aspectClass.newInstance();
            if (aspect.classActingOn().isAssignableFrom(classAppliedTo)) {
                aspects.add(aspect);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not instantiate all aspects " +
                    "(specifically " + aspectClass + ").", e);
        }
    }
}
