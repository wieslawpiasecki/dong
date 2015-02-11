package com.wpi.generic.storage.serialization;

import com.wpi.generic.storage.Document;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */

public interface DocumentSerializer {
    SerializedDocument serialize(Document document);
}
