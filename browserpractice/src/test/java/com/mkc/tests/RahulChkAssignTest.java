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

public class RahulChkAssignTest extends TestBase {
	
	@BeforeClass
	public static void init() {
		driver.get(Constants.URL_RAHULAUTOPRACTICE);
	}
	@Test
	public void rahulCheckAltTest() throws InterruptedException{
		//Important to initialize
		RahulChkAssign rahulAssign = PageFactory.initElements(driver, RahulChkAssign.class) ;
		
		rahulAssign.checkboxOption(3);
		String selectedBox = rahulAssign.checkboxSelected();
		rahulAssign.selectDropdown(selectedBox);
		rahulAssign.sendAlert(selectedBox);
		
	} 
	
	
	
	
}
