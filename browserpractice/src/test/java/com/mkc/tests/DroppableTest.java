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

public class DroppableTest extends TestBase {
	
	@BeforeClass
	public static void init() {
		//initialize();
		driver.get(Constants.URL_DROPPABLE);
	}
	@Test
	public void dragDropTest() throws InterruptedException{
		//Important to initialize
		Droppable droppablePage = PageFactory.initElements(driver, Droppable.class) ;
		
		droppablePage.dragAndDrop();
		
	} 
	
	
	/*
	 * @AfterClass public static void tearDown() {
	 * 
	 * driver.close();
	 * 
	 * }
	 * 
	 */
	
	
	
}
