package com.wpi.document.audittrail.document;

import com.wpi.document.Chapter;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public interface ChapterSnapshotFactory<T extends Chapter> {
    ChapterSnapshot takeSnapshot(T chapter);
}
