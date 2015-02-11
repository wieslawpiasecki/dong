package com.wpi.document.base;

import com.wpi.document.Chapter;
import com.wpi.document.Document;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 06.11.13.
 */
public class BaseDocument implements Document {
    private DocumentId documentId;

    public BaseDocument(DocumentId documentId) {
        this.documentId = documentId;
    }

    @Override
    public List<Chapter> chapters() {
        return null;
    }

    @Override
    public DocumentHeader getHeader() {
        return null;
    }
}
