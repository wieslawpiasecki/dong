package com.wpi.generic.storage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
public class XMLStorageTest {
    public static final List<PhoneNumber> PHONE_NUMBER_LIST = asList(PhoneNumber.of("HOME", "78437548754"), PhoneNumber.of("WORK", "9999548754"));
    private static final SimpleDocument SIMPLE_DOCUMENT = new SimpleDocument(VersionedDocumentId.of("2", 3), "adda", "dsd", PHONE_NUMBER_LIST);


    @Test
    public void shouldCreateXMLFromClass() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SimpleDocument.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(SIMPLE_DOCUMENT, System.out);

    }

    @Test
    public void shouldCreateObjectFromXML() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("SimpleXml.xml");

        Resource resource = new ClassPathResource("SimpleXml.xml");    //resource.getFile();
        JAXBContext jaxbContext = JAXBContext.newInstance(SimpleDocument.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        SimpleDocument simpleDocument = (SimpleDocument) jaxbUnmarshaller.unmarshal(resourceAsStream);
        System.out.println(simpleDocument);
    }
}
