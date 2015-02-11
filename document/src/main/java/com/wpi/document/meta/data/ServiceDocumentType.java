package com.wpi.document.meta.data;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public class ServiceDocumentType implements DocumentType {
    private String serviceName;

    public ServiceDocumentType(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String type() {
        return serviceName;
    }
}
