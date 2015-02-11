package com.wpi.document;

import com.wpi.document.base.DocumentHeader;

import java.util.List;

/**
 * Created by Wiesław Piasecki on 06.11.13.
 */
public interface Document {
    List<Chapter> chapters();

    DocumentHeader getHeader();
}
