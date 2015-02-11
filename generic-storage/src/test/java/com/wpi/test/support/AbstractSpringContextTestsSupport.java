package com.wpi.test.support;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by Wiesław Piasecki on 2015-01-02.
 */
@ContextConfiguration(locations = {"/META-INF/spring/com.wpi/common/scopeContext.xml", "/testContext.xml"} )
public class AbstractSpringContextTestsSupport extends AbstractTestNGSpringContextTests {


}
