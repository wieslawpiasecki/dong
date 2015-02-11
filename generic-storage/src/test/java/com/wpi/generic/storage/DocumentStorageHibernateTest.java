package com.wpi.generic.storage;

import com.wpi.test.support.AbstractSpringContextTestsSupport;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DocumentStorageHibernateTest extends AbstractSpringContextTestsSupport {
    private static final List<PhoneNumber> PHONE_NUMBER_LIST = asList(PhoneNumber.of("HOME", "78437548754"), PhoneNumber.of("WORK", "9999548754"));
    public static final VersionedDocumentId VERSIONED_DOCUMENT_ID = VersionedDocumentId.of("2", 3);
    private static final SimpleDocument SIMPLE_DOCUMENT = new SimpleDocument(VERSIONED_DOCUMENT_ID, "adda", "dsd", PHONE_NUMBER_LIST);
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private DocumentStorage documentStorage;

    @Test
    public void testStore() throws Exception {
        documentStorage.store(SIMPLE_DOCUMENT);
        Document resultDocument = documentStorage.findByVersionedId(VERSIONED_DOCUMENT_ID);
        assertThat(resultDocument).isEqualTo(SIMPLE_DOCUMENT);
    }
}