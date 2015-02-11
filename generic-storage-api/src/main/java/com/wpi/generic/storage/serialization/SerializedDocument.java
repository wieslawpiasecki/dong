package com.wpi.generic.storage.serialization;

import com.wpi.generic.storage.VersionedDocumentId;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
public class SerializedDocument {
    public static final String ID = "versionedDocumentId."+VersionedDocumentId.ID;
    public static final String VERSION = "versionedDocumentId."+VersionedDocumentId.VERSION;
    private VersionedDocumentId versionedDocumentId;
    private String content;
    private String documentComponentName;

    public static SerializedDocument of(VersionedDocumentId versionedDocumentId, String content, String documentComponentName) {
        return new SerializedDocument(versionedDocumentId, content, documentComponentName);
    }

    private SerializedDocument(VersionedDocumentId versionedDocumentId, String content, String documentComponentName) {
        this.versionedDocumentId = versionedDocumentId;
        this.content = content;
        this.documentComponentName = documentComponentName;
    }

    /**
     * For hibernate.
     */
    private SerializedDocument() {

    }

    public VersionedDocumentId getVersionedDocumentId() {
        return versionedDocumentId;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerializedDocument that = (SerializedDocument) o;

        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (documentComponentName != null ? !documentComponentName.equals(that.documentComponentName) : that.documentComponentName != null)
            return false;
        if (versionedDocumentId != null ? !versionedDocumentId.equals(that.versionedDocumentId) : that.versionedDocumentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = versionedDocumentId != null ? versionedDocumentId.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (documentComponentName != null ? documentComponentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SerializedDocument{" +
                "versionedDocumentId=" + versionedDocumentId +
                ", documentComponentName='" + documentComponentName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getDocumentComponentName() {
        return documentComponentName;
    }
}
