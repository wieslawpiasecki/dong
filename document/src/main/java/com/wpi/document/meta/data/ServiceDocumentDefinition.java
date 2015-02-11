package com.wpi.document.meta.data;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public class ServiceDocumentDefinition implements DocumentDefinition {
    private ServiceDocumentType serviceDocumentType;
    private ServiceDocumentVersionDefinition serviceVersion;
    private List<ChapterDefinition> chapterDefinitions;

    public ServiceDocumentDefinition(ServiceDocumentType serviceDocumentType, ServiceDocumentVersionDefinition serviceVersion, List<ChapterDefinition> chapterDefinitions) {
        this.serviceDocumentType = serviceDocumentType;
        this.serviceVersion = serviceVersion;
        this.chapterDefinitions = chapterDefinitions;
    }

    @Override
    public DocumentType getDocumentType() {
        return serviceDocumentType;
    }

    @Override
    public DocumentVersionDefinition getVersion() {
        return serviceVersion;
    }

    @Override
    public List<ChapterDefinition> chapterDefinitions() {
        return chapterDefinitions;
    }
}
