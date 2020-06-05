package com.mkc.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.mkc.constants.Constants;
import com.mkc.pages.Controlgroup;
import com.mkc.pages.Droppable;

public class ControlgroupTest extends TestBase {
	
	@BeforeClass
	public static void init() {
		driver.get(Constants.URL_CONTROLGROUP);
		//Code added to see git workflow
		System.out.println("Git comment just to see git flow");
	}
	@Test
	public void controlGroupTest() throws InterruptedException{
		//Important to initialize
		Controlgroup controlgroupPage = PageFactory.initElements(driver, Controlgroup.class) ;
		
		controlgroupPage.selectCar("SUV",3);
		controlgroupPage.setInsurance(true);
		Assert.assertTrue("Insurance button is not selected", controlgroupPage.getInsurance());
		
		controlgroupPage.setAutomatic(true);
		Assert.assertTrue("Automatic car is not selected", controlgroupPage.getAutomatic());
		
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
