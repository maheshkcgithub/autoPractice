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
import com.mkc.pages.Resizable;

public class MaheshEdgeTest extends TestBase {
	
	@BeforeClass
	public static void init() {
		driver.get(Constants.URL_MKCEDGE);
	}
	@Test
	public void resizableTest() throws InterruptedException{
		//Important to iniliaze
		Resizable resizablePage = PageFactory.initElements(driver, Resizable.class) ;
		
		resizablePage.resizeBy(50, 100);
		System.out.println("just printing");
		
	} 
	
	/*
	 * @AfterClass public static void tearDown() { driver.close(); }
	 */
	
	
	
}