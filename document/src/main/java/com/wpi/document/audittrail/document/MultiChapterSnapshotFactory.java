package com.wpi.document.audittrail.document;

import com.google.common.base.Function;
import com.wpi.document.Chapter;

import javax.annotation.Resource;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class MultiChapterSnapshotFactory {
    @Resource
    private SimpleChapterSnapshotFactory simpleChapterSnapshotFactory;

    public List<ChapterSnapshot> takeSnapshot(List<Chapter> chapters) {
        return transform(chapters, new Function<Chapter, ChapterSnapshot>() {
            @Override
            public ChapterSnapshot apply(Chapter chapter) {
                return simpleChapterSnapshotFactory.takeSnapshot(chapter);
            }
        });
    }
}
