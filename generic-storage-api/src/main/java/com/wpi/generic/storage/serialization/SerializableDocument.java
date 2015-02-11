package com.wpi.generic.storage.serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @ interface SerializableDocument {
    String value();
}
