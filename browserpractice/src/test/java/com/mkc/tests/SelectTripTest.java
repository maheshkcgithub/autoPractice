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
import com.mkc.pages.SelectTrip;

public class SelectTripTest extends TestBase {

	@BeforeClass
	public static void init() {
		// initialize();
		driver.get(Constants.URL_CLEARTRIP);
	}

	@Test
	public void selectTrip() throws InterruptedException {
		// Important to initialize
		SelectTrip selectTripPage = PageFactory.initElements(driver, SelectTrip.class);

		selectTripPage.selectAdults(3);
		selectTripPage.selectChildrens(2);
		selectTripPage.selectDepartDate();
		selectTripPage.selectMoreOption("Indigo");
		selectTripPage.searchFlights();
		Thread.sleep(2000);

	}

}
