package com.wpi.generic.storage;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 2014-09-29.
 */
public interface BatchDocumentsStorage {
    void store(List<Document> documents);
}
