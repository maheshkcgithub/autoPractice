package com.mkc.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.mkc.pages.Samplepage;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DroppableTest.class, ResizableTest.class, ControlgroupTest.class, SamplepageTest.class,
		SelectTripTest.class, RahulCheckboxTest.class })
//@Suite.SuiteClasses({ SelectTripTest.class})

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
