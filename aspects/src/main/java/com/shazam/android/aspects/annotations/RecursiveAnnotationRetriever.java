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
package com.shazam.android.aspects.annotations;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class will scan the provided object for annotations of type {@link A} and all its
 * annotations recursively.
 */
public final class RecursiveAnnotationRetriever<A extends Annotation> implements AnnotationRetriever<A> {
    private Class<A> annotationClass;

    private RecursiveAnnotationRetriever(Class<A> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public static <AA extends Annotation> AnnotationRetriever<AA> recursiveAnnotationRetriever(
            Class<AA> annotationClass) {
        return new RecursiveAnnotationRetriever<>(annotationClass);
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public List<A> retrieveAnnotations(Object annotatedObject) {
        List<A> result = new ArrayList<>();
        Set<Class<?>> scannedClasses = new HashSet<Class<?>>();
        Class<?> annotatedObjectClass = annotatedObject.getClass();
        findAnnotationsOn(annotatedObjectClass, result, scannedClasses);
        return result;
    }

    @SuppressWarnings("unchecked")
    private void findAnnotationsOn(Class<?> annotatedObjectClass, List<A> result, Set<Class<?>> scannedClasses) {
        Annotation[] annotations = annotatedObjectClass.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (annotationClass.isAssignableFrom(annotationType)) {
                // T cast is safe here. T is of type annotationClass
                result.add((A) annotation);
            } else {
                if (!scannedClasses.contains(annotationType)) {
                    scannedClasses.add(annotationType);
                    findAnnotationsOn(annotationType, result, scannedClasses);
                }
            }
        }
    }
}
