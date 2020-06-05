package com.mkc.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DroppableTest.class,ResizableTest.class,ControlgroupTest.class})

public class JunitTestSuite {
	
	@BeforeClass
    public static void setUp() {
        TestBase.initialize();
    }

    @AfterClass
    public static void tearDown() {
        TestBase.driver.quit();
    }

}
