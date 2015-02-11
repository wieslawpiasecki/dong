package com.wpi.document.audittrail.document;

import com.wpi.document.base.VerisionedDocumentId;
import org.joda.time.LocalDateTime;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class DocumentSnapshotId {
    private VerisionedDocumentId verisionedDocumentId;
    private LocalDateTime timestamp;

    public DocumentSnapshotId(VerisionedDocumentId verisionedDocumentId, LocalDateTime timestamp) {
        this.verisionedDocumentId = verisionedDocumentId;
        this.timestamp = timestamp;
    }
}
