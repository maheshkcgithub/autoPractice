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

import com.mkc.constants.*;

public class Droppable {
	WebDriver driver;
	Actions action;

	public Droppable(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);

	}

	//Elements Used
	@FindBy(how = How.XPATH, using = "//*[@id='content']/iframe")
	WebElement framePath;
	@FindBy(how = How.ID, using = "draggable")
	WebElement draggable;
	@FindBy(how = How.ID, using = "droppable")
	WebElement droppable;

	//
	// User doing draganddrop
	public void dragAndDrop() throws InterruptedException {

		driver.switchTo().frame(framePath);

		action.dragAndDrop(draggable, droppable).build().perform();
	}

}
