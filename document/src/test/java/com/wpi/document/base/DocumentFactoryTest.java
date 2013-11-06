package com.wpi.document.base;

import com.wpi.document.Document;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by Wiesław Piasecki on 06.11.13.
 */
public class DocumentFactoryTest {
    @InjectMocks
    private DocumentFactory documentFactory;
    @Mock
    private Document expectedDocument;
    @Mock
    private DocumentId documentId;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        documentFactory = new DocumentFactory();
        initMocks(this);
    }

    @Test
    public void testCreateNewDocument() throws Exception {
        Document resultDocument = documentFactory.createNewDocument(documentId);
        assertNotNull(resultDocument);
    }
}
