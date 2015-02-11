package com.wpi.document.audittrail.document;

import com.wpi.document.Chapter;
import com.wpi.document.audittrail.document.ChapterSnapshot;
import com.wpi.document.audittrail.document.ChapterSnapshotFactory;
import com.wpi.document.audittrail.document.ChapterSnapshotFactoryProvider;

import javax.annotation.Resource;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class SimpleChapterSnapshotFactory implements ChapterSnapshotFactory {
    @Resource
    private ChapterSnapshotFactoryProvider chapterSnapshotFactoryProvider;

    public ChapterSnapshot takeSnapshot(Chapter chapter) {
        ChapterSnapshotFactory chapterSnapshotFactory = chapterSnapshotFactoryProvider.find(chapter);
        return chapterSnapshotFactory.takeSnapshot(chapter);
    }
}
