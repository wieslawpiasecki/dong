package com.wpi.document.audittrail.document;

import com.wpi.document.base.annotation.ChapterDefinition;

import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class ChapterSnapshot {
    private ChapterDefinition chapterDefinition;
    private List<ChapterPropertySnapshot> chapterPropertySnapshotList;

    public ChapterSnapshot(ChapterDefinition chapterDefinition, List<ChapterPropertySnapshot> chapterPropertySnapshotList) {
        notNull(chapterDefinition);
        this.chapterDefinition = chapterDefinition;
        this.chapterPropertySnapshotList = chapterPropertySnapshotList;
    }

    public ChapterDefinition getChapterDefinition() {
        return chapterDefinition;
    }

    public List<ChapterPropertySnapshot> getChapterPropertySnapshotList() {
        return chapterPropertySnapshotList;
    }
}
