package com.wpi.document.base;

import com.wpi.document.Document;

/**
 * Created by Wiesław Piasecki on 06.11.13.
 */
public class DocumentFactory {
    public Document createNewDocument(DocumentId documentId) {
       return new BaseDocument(documentId);
    }
}
