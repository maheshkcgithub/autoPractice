package com.mkc.pages;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RahulChkAssign {
	WebDriver driver;
	// Actions action;

	public RahulChkAssign(WebDriver driver) {
		this.driver = driver;
		// this.action = new Actions(driver);

	}

	// Elements Used
	@FindBy(how = How.ID, using = "checkBoxOption1")
	WebElement option1;
	@FindBy(how = How.ID, using = "checkBoxOption2")
	WebElement option2;
	@FindBy(how = How.ID, using = "checkBoxOption3")
	WebElement option3;
	@FindBy(how = How.ID, using = "dropdown-class-example")
	WebElement dropdownOption;
	@FindBy(how = How.ID, using = "name")
	WebElement nameSelected;
	@FindBy(how = How.ID, using = "alertbtn")
	WebElement alertBtn;

	//
	// User doing checkboxSelect
	public void checkboxOption(int value) throws InterruptedException {

		switch (value) {
		case 1:
			option1.click();
			break;
		case 2:
			option2.click();
			break;
		case 3:
			option3.click();
			break;
		default:
			option1.click();
			break;

		}

	}

	public String checkboxSelected() {
		if (option1.isSelected()) {
			return option1.getAttribute("value");
		} else if (option2.isSelected()) {

			return option2.getAttribute("value");
		} else {
			return option3.getAttribute("value");
		}

	}

	public void selectDropdown(String dropOption) {
		Select s = new Select(dropdownOption);

		s.selectByValue(dropOption);

	}

	public void sendAlert(String dropOption) {
		nameSelected.sendKeys(dropOption);
		alertBtn.click();
		String alertTxt = driver.switchTo().alert().getText();
		String[] splitStr = alertTxt.trim().split("\\s+");
		for (int i = 0; i < splitStr.length; i++) {

			if (splitStr[i].contains(dropOption)) {
				String[] finalStr = splitStr[i].trim().split(",");
				System.out.println(finalStr[0] + " found in alert message: " + alertTxt);
				break;
			}

		}

	}

}
