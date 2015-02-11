package com.wpi.document.audittrail.document;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class DocumentSnapshot {
    private DocumentSnapshotId documentSnapshotId;
    List<ChapterSnapshot> chapterSnapshotList;

    public DocumentSnapshot(DocumentSnapshotId documentSnapshotId, List<ChapterSnapshot> chapterSnapshotList) {
        this.documentSnapshotId = documentSnapshotId;
        this.chapterSnapshotList = chapterSnapshotList;
    }

    public DocumentSnapshotId getDocumentSnapshotId() {
        return documentSnapshotId;
    }

    public List<ChapterSnapshot> getChapterSnapshotList() {
        return chapterSnapshotList;
    }
}
