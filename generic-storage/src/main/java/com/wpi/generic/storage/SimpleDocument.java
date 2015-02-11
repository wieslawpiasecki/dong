package com.wpi.generic.storage;

import com.wpi.generic.storage.serialization.SerializableDocument;

import javax.xml.bind.annotation.*;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@SerializableDocument(value = SimpleDocument.COMPONENT_NAME)
public class SimpleDocument implements Document {
    public static final String COMPONENT_NAME = "SimpleDocument";
    private String name;
    private String address;
    @XmlElement(name = "phone-number")
    private List<PhoneNumber> phoneNumberList;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleDocument that = (SimpleDocument) o;

        if (!versionedDocumentId().equals(that.versionedDocumentId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return versionedDocumentId().hashCode();
    }

    public SimpleDocument(VersionedDocumentId versionedDocumentId, String address, String name, List<PhoneNumber> phoneNumberList) {
        checkNotNull(versionedDocumentId);
        this.id = versionedDocumentId.getId();
        this.version = versionedDocumentId.getVersion();
        this.address = address;
        this.name = name;
        this.phoneNumberList = phoneNumberList;
    }

    SimpleDocument() {
    }

    @Override
    public VersionedDocumentId versionedDocumentId() {
        return VersionedDocumentId.of(id, version);
    }


}
