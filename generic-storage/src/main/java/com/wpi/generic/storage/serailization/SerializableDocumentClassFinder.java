package com.wpi.generic.storage.serailization;

import com.wpi.common.AnnotationScanner;
import com.wpi.generic.storage.Document;
import com.wpi.generic.storage.serialization.SerializableDocument;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.stream.Collectors.toList;

/**
 * Created by Wiesław Piasecki on 2015-01-10.
 */
public class SerializableDocumentClassFinder {
    private final String documentComponentName;
    private String packageName;

    public SerializableDocumentClassFinder(String documentComponentName, String packageName) {
        this.documentComponentName = checkNotNull(documentComponentName);
        this.packageName = checkNotNull(packageName);
    }

    public Class<? extends Document> findClassForDocumentComponentName() {
        Set<Class<? extends Document>> subTypeOfAndAnnotatedWith = AnnotationScanner.getSubTypeOfAndAnnotatedWith(packageName, Document.class, SerializableDocument.class);
        Class<? extends Document> foundClass = findClassForDocumentComponentName(subTypeOfAndAnnotatedWith, documentComponentName);
        return foundClass;
    }

    private Class<? extends Document> findClassForDocumentComponentName(Set<Class<? extends Document>> subTypeOfAndAnnotatedWith, final String documentComponentName) {
        Stream<Class<? extends Document>> classStream = subTypeOfAndAnnotatedWith.stream().filter(new Predicate<Class<? extends Document>>() {
            @Override
            public boolean test(Class<? extends Document> aClass) {
                String readComponentName = readComponentName(aClass);
                return Objects.equals(readComponentName, documentComponentName);
            }
        });
        List<Class<? extends Document>> classes = classStream.collect(toList());
        if (classes.size() == 1) {
            return classes.get(0);
        }

        if (classes.size() == 0) {
            throw new RuntimeException("There is no class for componentName: " + documentComponentName);
        }
        throw new RuntimeException("There is many class for componentName: " + documentComponentName + classes.toArray());
    }

    public static String readComponentName(Class<?> aClass) {
        Annotation[] annotations = aClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof SerializableDocument) {
                SerializableDocument serializableDocument = (SerializableDocument) annotation;
                return serializableDocument.value();
            }
        }
        throw new RuntimeException("There is no @SerializableDocument annotation for class " + aClass.getName());
    }
}
