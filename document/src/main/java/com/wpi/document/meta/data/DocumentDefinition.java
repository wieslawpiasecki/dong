package com.wpi.document.meta.data;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public interface DocumentDefinition {
    DocumentType getDocumentType();
    DocumentVersionDefinition getVersion();
    List<ChapterDefinition> chapterDefinitions();
}
