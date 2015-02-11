package com.wpi.document.audittrail.document;

import com.wpi.document.audittrail.document.ChapterPropertySnapshot;
import com.wpi.document.audittrail.document.ChapterPropertySnapshotFactory;

import javax.annotation.Resource;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
public class SingleChapterPropertySnapshotsFactory {
    @Resource
    private ChapterPropertySnapshotFactory chapterPropertySnapshotFactory;

    public List<ChapterPropertySnapshot> create(String property, String i18nResourceKey, String value) {
        return asList(chapterPropertySnapshotFactory.create(property, i18nResourceKey, value));
    }
}
