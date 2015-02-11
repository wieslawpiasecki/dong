package com.wpi.document.audittrail.document;

import com.wpi.document.Chapter;
import com.wpi.document.base.annotation.ChapterDefinition;
import org.springframework.stereotype.Component;

/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
@Component
public class ChapterDefinitionProvider {

    public <T extends Chapter> ChapterDefinition provide(T chapter) {
        ChapterDefinition chapterDefinition = chapter.getClass().getAnnotation(ChapterDefinition.class);
        notNull(chapterDefinition, "Missing ChapterDefinition annotation for class" + chapter.getClass());
        return chapterDefinition;
    }

    private void notNull(Object object, String msg) {
        if (object == null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
