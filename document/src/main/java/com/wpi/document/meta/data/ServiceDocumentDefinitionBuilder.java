package com.wpi.document.meta.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public class ServiceDocumentDefinitionBuilder {
    private ServiceDocumentType serviceDocumentType;
    private ServiceDocumentVersionDefinition versionDefinition;
    public List<ChapterDefinition> chapterDefinitions=new ArrayList<ChapterDefinition>();

    public ServiceDocumentDefinitionBuilder(ServiceDocumentType serviceDocumentType, ServiceDocumentVersionDefinition versionDefinition) {
        this.serviceDocumentType = serviceDocumentType;
        this.versionDefinition = versionDefinition;
    }

    public ServiceDocumentDefinitionBuilder addChapterDefinition(ChapterDefinition chapterDefinition){
       this.chapterDefinitions.add(chapterDefinition);
        return this;
    }

    public ServiceDocumentDefinition build(){
        return new ServiceDocumentDefinition(serviceDocumentType,versionDefinition,chapterDefinitions);
    }

}
