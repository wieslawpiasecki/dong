package com.wpi.document.audittrail.document;

import com.wpi.document.Chapter;
import com.wpi.document.base.annotation.ChapterDefinition;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
public abstract class BaseSnapshotFactory<T extends Chapter>  implements ChapterSnapshotFactory<T> {
    @Resource
    private ChapterDefinitionProvider chapterDefinitionProvider;

    @Override
    public ChapterSnapshot takeSnapshot(T chapter) {
        ChapterDefinition chapterDefinition = chapterDefinitionProvider.provide(chapter);
        List<ChapterPropertySnapshot> chapterPropertySnapshotList = takeChapterPropertySnapshot(chapter);
        return new ChapterSnapshot(chapterDefinition,chapterPropertySnapshotList);
    }

    public abstract List<ChapterPropertySnapshot> takeChapterPropertySnapshot(T chapter);
}
