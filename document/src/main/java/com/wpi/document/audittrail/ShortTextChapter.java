package com.wpi.document.audittrail;

import com.wpi.document.Chapter;
import com.wpi.document.base.annotation.ChapterDefinition;

import static com.google.common.base.Predicates.notNull;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
@ChapterDefinition(type = ShortTextChapter.TYPE, version = 1.0)
public class ShortTextChapter implements Chapter {
    public static final String TYPE = "ShortText";
    private String label;
    private String i18nResourceKey;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getI18nResourceKey() {
        return i18nResourceKey;
    }

    public void setI18nResourceKey(String i18nResourceKey) {
        this.i18nResourceKey = i18nResourceKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
