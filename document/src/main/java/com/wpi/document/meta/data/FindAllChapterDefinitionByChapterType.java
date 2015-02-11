package com.wpi.document.meta.data;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.wpi.document.Document;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


import static com.google.common.collect.Collections2.filter;

/**
 * Created by Wiesław Piasecki on 17.02.14.
 */
public class FindAllChapterDefinitionByChapterType {

    public Collection<ChapterDefinition> find(DocumentDefinition documentDefinition, final ChapterType chapterType) {
        final List<ChapterDefinition> chapterDefinitions = documentDefinition.chapterDefinitions();
        return filter(chapterDefinitions, new Predicate<ChapterDefinition>() {
            @Override
            public boolean apply(ChapterDefinition o) {
                return o.equals(chapterType);
            }
        });
    }
}
