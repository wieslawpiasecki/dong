package com.wpi.generic.storage.serailization;

import com.wpi.generic.storage.Document;
import com.wpi.generic.storage.serialization.DocumentSerializer;
import com.wpi.generic.storage.serialization.SerializedDocument;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static com.wpi.generic.storage.serailization.SerializableDocumentClassFinder.readComponentName;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
@Component
public class XMLDocumentSerializer implements DocumentSerializer {
    @Override
    public SerializedDocument serialize(Document document) {
        try {
            String xmlContent = serializeContent(document);
            return SerializedDocument.of(document.versionedDocumentId(), xmlContent, readComponentName(document.getClass()));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private String serializeContent(Document document) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(document.getClass());

        Marshaller marshaller = null;
        marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(document, stringWriter);
        return stringWriter.toString();
    }
}
