package com.wpi.document.audittrail;

import com.wpi.document.Chapter;
import com.wpi.document.audittrail.document.ChapterDefinitionProvider;
import com.wpi.document.base.annotation.ChapterDefinition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Wiesław Piasecki on 19.02.14.
 */
public class ChapterDefinitionProviderTest {

    private ChapterDefinitionProvider chapterDefinitionProvider;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        chapterDefinitionProvider = new ChapterDefinitionProvider();
    }

    @Test
    public void testProvide() throws Exception {
        Chapter chapter = new TestedClass();
        ChapterDefinition chapterDefinition = chapterDefinitionProvider.provide(chapter);
        assertEquals(chapterDefinition.type(), TestedClass.TESTED_CLASS_TYPE);
        assertEquals(chapterDefinition.version(), TestedClass.TESTED_CLASS_VERSION);
    }

    @ChapterDefinition(type = TestedClass.TESTED_CLASS_TYPE, version = TestedClass.TESTED_CLASS_VERSION)
    private class TestedClass implements Chapter {
        public static final String TESTED_CLASS_TYPE = "TestedClass";
        public static final double TESTED_CLASS_VERSION = 1.0;
    }
}
