package com.mkc.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class Resizable {
	WebDriver driver;
	Actions action;
	
	public Resizable(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id='content']/iframe") WebElement framepath;
	@FindBy(how=How.CSS, using = "#resizable div:nth-child(4)") WebElement resizable;
	
	
	public void resizeBy(int xoffset, int yoffset) {
		driver.switchTo().frame(framepath);
		action.clickAndHold(resizable).moveByOffset(xoffset, yoffset).release().build().perform();
		System.out.println(resizable.getAttribute("class"));
		
	}

	

}
