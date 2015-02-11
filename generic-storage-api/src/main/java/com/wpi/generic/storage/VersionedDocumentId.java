package com.wpi.generic.storage;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
public class VersionedDocumentId implements Serializable {
    public static final String ID = "id";
    public static String VERSION = "version";
    private String id;
    private long version;

    VersionedDocumentId(String id, long version) {
        this.id = checkNotNull(id);
        this.version = checkNotNull(version);
    }

    private VersionedDocumentId() {
    }


    public String getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public static VersionedDocumentId of(String id, long version) {
        return new VersionedDocumentId(id, version);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VersionedDocumentId that = (VersionedDocumentId) o;

        if (version != that.version) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VersionedDocumentId{" +
                "id='" + id + '\'' +
                ", version=" + version +
                '}';
    }
}
