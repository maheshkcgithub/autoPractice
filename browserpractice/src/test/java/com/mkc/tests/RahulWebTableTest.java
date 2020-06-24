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
import com.mkc.pages.RahulCheckbox;
import com.mkc.pages.Resizable;
import com.mkc.pages.RahulChkAssign;
import com.mkc.pages.RahulWebTable;

public class RahulWebTableTest extends TestBase {

	@BeforeClass
	public static void init() {
		driver.get(Constants.URL_RAHULAUTOPRACTICE);
	}

	@Test
	public void rahulWebTest() throws InterruptedException {
		// Important to initialize
		RahulWebTable rahulTable = PageFactory.initElements(driver, RahulWebTable.class);

		System.out.println("Total rows in the WebTable: " + rahulTable.rowscount());
		System.out.println("Total columns in the WebTable: " + rahulTable.columnscount());

		String result = rahulTable.printSecondRow();
		System.out.println("Second Row content is : " + result);

	}

}
