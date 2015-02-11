package com.wpi.document.audittrail.document;

import com.wpi.document.Document;
import com.wpi.document.audittrail.TimeMachine;
import com.wpi.document.audittrail.document.DocumentSnapshotId;
import com.wpi.document.base.DocumentHeader;

import javax.annotation.Resource;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class DocumentSnapshotIdFactory {
    @Resource
    private TimeMachine timeMachine;

    public DocumentSnapshotId build(Document document) {
        DocumentHeader documentHeader = document.getHeader();
        return new DocumentSnapshotId(documentHeader.getVersionedDocumentId(),timeMachine.getCurrentLocalDateTime());
    }
}
