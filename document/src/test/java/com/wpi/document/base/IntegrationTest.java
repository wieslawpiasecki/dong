package com.wpi.document.base;

import com.wpi.document.Chapter;
import com.wpi.document.audittrail.document.ChapterDefinitionProvider;
import com.wpi.document.base.annotation.ChapterDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
@ContextConfiguration(locations = {"classpath*:META-INF/com.wpi.document/context.xml"})
public class IntegrationTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChapterDefinitionProvider chapterDefinitionProvider;

    @Test
    public void testReadingChapterDefinitionFromChapter() {
        ChapterDefinition chapterDefinition = chapterDefinitionProvider.provide(new TestChapter());
        assertThat(chapterDefinition.type()).isEqualTo(TestChapter.CHAPTER_NAME);
        assertThat(chapterDefinition.version()).isEqualTo(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenThereIsNoChapterDefinition() throws Exception {
        chapterDefinitionProvider.provide(new Chapter() {
        });
    }

    @ChapterDefinition(type = TestChapter.CHAPTER_NAME, version = 1)
    private class TestChapter implements Chapter {
        public static final String CHAPTER_NAME = "TestChapter";

    }
}
