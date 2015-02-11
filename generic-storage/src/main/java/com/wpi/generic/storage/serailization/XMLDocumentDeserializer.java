package com.wpi.generic.storage.serailization;

import com.wpi.generic.storage.Document;
import com.wpi.generic.storage.serialization.DocumentDeserializer;
import com.wpi.generic.storage.serialization.SerializedDocument;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
@Component
public class XMLDocumentDeserializer implements DocumentDeserializer {
    @Override
    public Document deserialize(SerializedDocument serializedDocument) {
        SerializableDocumentClassFinder serializableDocumentClassFinder = new SerializableDocumentClassFinder(serializedDocument.getDocumentComponentName(), "com.wpi");
        return deserialize(serializedDocument.getContent(), serializableDocumentClassFinder.findClassForDocumentComponentName());
    }

    private Document deserialize(String xmlContent, Class<? extends Document> foundClass) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(foundClass);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Object object = jaxbUnmarshaller.unmarshal(new StringReader(xmlContent));
            return foundClass.cast(object);
        } catch (JAXBException e) {
            throw new RuntimeException("Couldn't initiate JAXBContext on " + foundClass.getName());
        }
    }


}
