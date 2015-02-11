package com.wpi.document.audittrail.document;

import com.wpi.document.audittrail.document.ChapterPropertySnapshot;

/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
public class ChapterPropertySnapshotFactory {
    public ChapterPropertySnapshot create(String property, String i18nResourceKey, String value) {
        return new ChapterPropertySnapshot(property,i18nResourceKey,value);
    }
}
