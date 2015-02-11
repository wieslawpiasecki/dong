package com.wpi.document.audittrail.document;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class ChapterPropertySnapshot {
    private String propertyId;
    private String i18n;
    private String value;

    public ChapterPropertySnapshot(String propertyId, String i18n, String value) {
        this.propertyId = propertyId;
        this.i18n = i18n;
        this.value = value;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getI18n() {
        return i18n;
    }

    public String getValue() {
        return value;
    }
}
