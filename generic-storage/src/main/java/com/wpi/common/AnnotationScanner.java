package com.wpi.common;

import com.google.common.collect.Sets;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
public class AnnotationScanner {
    public static <T, E extends Annotation> Set<Class<? extends T>> getSubTypeOfAndAnnotatedWith(String packageName, Class<T> parentClass, Class<E> annotationClass) {
        Set<Class<? extends T>> subTypesOf = getSubTypesOf(packageName, parentClass);
        Set<Class<?>> typesAnnotatedWith = getTypesAnnotatedWith(packageName, annotationClass);
        return Sets.intersection(subTypesOf,typesAnnotatedWith).immutableCopy();
    }

    public static <T> Set<Class<? extends T>> getSubTypesOf(String packageName, Class<T> parentClass) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(parentClass);
    }

    public static <E extends Annotation> Set<Class<?>> getTypesAnnotatedWith(String packageName, Class<E> annotationClass) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(annotationClass);
    }

}
