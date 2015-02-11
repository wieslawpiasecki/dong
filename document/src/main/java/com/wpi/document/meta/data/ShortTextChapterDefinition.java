package com.wpi.document.meta.data;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public class ShortTextChapterDefinition implements ChapterDefinition {

    public static final String SHORT_TEXT_TYPE = "SHORT_TEXT_TYPE";

    @Override
    public ChapterType getChapterType() {
        return new StringDefinedChapterType(SHORT_TEXT_TYPE);
    }

    @Override
    public ChapterVersion getChapterVersion() {
        return new BaseChapterVersion(0);
    }
}
