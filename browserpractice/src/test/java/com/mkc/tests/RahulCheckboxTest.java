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

public class RahulCheckboxTest extends TestBase {
	
	@BeforeClass
	public static void init() {
		driver.get(Constants.URL_RAHULAUTOPRACTICE);
	}
	@Test
	public void rahulCheckboxTest() throws InterruptedException{
		//Important to iniliaze
		RahulCheckbox rahulCheckBox = PageFactory.initElements(driver, RahulCheckbox.class) ;
		
		rahulCheckBox.checkboxOption(3);
		rahulCheckBox.checkboxUncheck(3);
		System.out.println(rahulCheckBox.checkboxCount());
	} 
	
	
	
	
}
