package com.wpi.document.meta.data;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class StringDefinedChapterType implements ChapterType {
    private final String stringType;

    public StringDefinedChapterType(String stringType) {
        this.stringType = stringType;
    }
}
