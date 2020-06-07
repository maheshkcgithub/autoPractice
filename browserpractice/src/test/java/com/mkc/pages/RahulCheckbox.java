package com.mkc.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mkc.constants.*;

public class RahulCheckbox {
	WebDriver driver;
	Actions action;

	public RahulCheckbox(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);

	}

	// Elements Used
	@FindBy(how = How.ID, using = "checkBoxOption1")
	WebElement option1;
	@FindBy(how = How.ID, using = "checkBoxOption2")
	WebElement option2;
	@FindBy(how = How.ID, using = "checkBoxOption3")
	WebElement option3;

	//
	// User doing checkboxSelect
	public void checkboxOption(int value) throws InterruptedException {

		switch (value) {
		case 1:
			option1.click();
			Assert.assertTrue("option1 is not selected", option1.isSelected());
			break;
		case 2:
			option2.click();
			Assert.assertTrue("option2 is not selected", option2.isSelected());
			break;
		case 3:
			option3.click();
			Assert.assertTrue("option3 is not selected", option3.isSelected());
			break;
		default:
			option1.click();
			Assert.assertTrue("option1 is not selectedas default", option1.isSelected());
			break;

		}

	}

	// User doing checkboxUnSelect
	public void checkboxUncheck(int value) throws InterruptedException {

		switch (value) {
		case 1:
			option1.click();
			Assert.assertFalse("option1 is  selected", option1.isSelected());
			break;
		case 2:
			option2.click();
			Assert.assertFalse("option2 is  selected", option2.isSelected());
			break;
		case 3:
			option3.click();
			Assert.assertFalse("option3 is  selected", option3.isSelected());
			break;
		default:
			option1.click();
			Assert.assertFalse("option1 is  selected as default", option1.isSelected());
			break;

		}

	}

	public int checkboxCount() {
		return driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	}

}
