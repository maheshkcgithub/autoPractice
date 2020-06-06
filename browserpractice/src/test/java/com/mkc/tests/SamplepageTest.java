package com.mkc.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.mkc.constants.Constants;
import com.mkc.pages.Droppable;
import com.mkc.pages.Samplepage;

public class SamplepageTest extends TestBase {

	@BeforeClass
	public static void init() {
		// initialize();
		driver.get(Constants.URL_SAMPLEPAGE);
	}

	@Test
	public void samplepageTest() throws InterruptedException {
		// Important to initialize
		Samplepage samplePage = PageFactory.initElements(driver, Samplepage.class);

		samplePage.profilePic();
		samplePage.setName("Mahesh");
		samplePage.setEmail("mahesh.kc@yahoo.com");
		samplePage.setUrl("https://google.com");
		samplePage.selectTesting("automation");
		samplePage.selectYears("0-1");
		samplePage.selectGraduationLevel("Graduate");
		samplePage.selectAlert(false);
		samplePage.sendComment("Hello testing Testing");
		samplePage.submit();

	}

}
