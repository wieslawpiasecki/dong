package com.wpi.generic.storage;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
public interface DocumentStorage {
    void store(Document document);
    Document findByVersionedId(VersionedDocumentId versionedDocumentId);
}
