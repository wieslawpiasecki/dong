package com.wpi.generic.storage.serailization;

import com.wpi.common.StreamUtils;
import com.wpi.generic.storage.Document;
import com.wpi.generic.storage.VersionedDocumentId;
import com.wpi.generic.storage.serialization.DocumentDeserializer;
import com.wpi.generic.storage.serialization.SerializedDocument;
import com.wpi.test.support.AbstractSpringContextTestsSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class XMLDocumentDeserializerTest extends AbstractSpringContextTestsSupport {
    private static final String ID = "id";
    private static final long VERSION = 1;
    public static final String DOCUMENT_COMPONENT_NAME = "SimpleDocument";

    @Autowired
    private DocumentDeserializer documentDeserializer;

    @Test
    public void testDeserialize() throws Exception {
        SerializedDocument serializedDocument = createSerializedDocument();
        Document document = documentDeserializer.deserialize(serializedDocument);
        assertThat(document).isNotNull();
    }

    private SerializedDocument createSerializedDocument() {
        String xmlContent = readXMLContentFromFile("com/wpi/generic/storage/serialization/simpleDocument.xml");
        return SerializedDocument.of(VersionedDocumentId.of(ID, VERSION), xmlContent, DOCUMENT_COMPONENT_NAME);
    }

    private String readXMLContentFromFile(String fileName) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
        String content = StreamUtils.convertStreamToString(in);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}