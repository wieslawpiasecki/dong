package com.wpi.document.base;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class DocumentHeader {
    private VerisionedDocumentId versionedDocumentId;

    public VerisionedDocumentId getVersionedDocumentId() {
        return versionedDocumentId;
    }

    public void setVersionedDocumentId(VerisionedDocumentId versionedDocumentId) {
        this.versionedDocumentId = versionedDocumentId;
    }
}
