package com.wpi.document.audittrail.document;

import com.wpi.document.Document;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class DocumentSnapshotFactory {
    @Resource
    private DocumentSnapshotIdFactory documentSnapshotIdFactory;
    @Resource
    private MultiChapterSnapshotFactory multiChapterSnapshotFactory;

    public DocumentSnapshot buildSnapshot(Document document) {
        DocumentSnapshotId documentSnapshotId = documentSnapshotIdFactory.build(document);
        List<ChapterSnapshot> chapterSnapshotList = multiChapterSnapshotFactory.takeSnapshot(document.chapters());
        return new DocumentSnapshot(documentSnapshotId, chapterSnapshotList);
    }
}
