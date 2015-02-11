package com.wpi.document.audittrail;

import com.wpi.document.audittrail.document.BaseSnapshotFactory;
import com.wpi.document.audittrail.document.ChapterPropertySnapshot;
import com.wpi.document.audittrail.document.SingleChapterPropertySnapshotsFactory;

import javax.annotation.Resource;
import java.util.List;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class ShortTextSnapshotFactory extends BaseSnapshotFactory<ShortTextChapter> {
    @Resource
    private SingleChapterPropertySnapshotsFactory singleChapterPropertySnapshotsFactory;

    @Override
    public List<ChapterPropertySnapshot> takeChapterPropertySnapshot(ShortTextChapter chapter) {
        return singleChapterPropertySnapshotsFactory.create(chapter.getLabel(), chapter.getI18nResourceKey(), chapter.getValue());
    }
}
