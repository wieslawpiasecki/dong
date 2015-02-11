package com.wpi.document.meta.data;

/**
 * Created by Wiesław Piasecki on 18.02.14.
 */
public class BaseChapterVersion implements ChapterVersion{
    private long version=0;

    public BaseChapterVersion(long version) {
        this.version = version;
    }

    @Override
    public long version() {
        return version;
    }
}
