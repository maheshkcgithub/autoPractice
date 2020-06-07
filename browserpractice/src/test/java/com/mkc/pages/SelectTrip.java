package com.mkc.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.mkc.constants.*;

public class SelectTrip {
	WebDriver driver;

	public SelectTrip(WebDriver driver) {
		this.driver = driver;

	}

	// Elements Used
	@FindBy(how = How.ID, using = "Adults")
	WebElement adults;
	@FindBy(how = How.ID, using = "Childrens")
	WebElement childrens;
	@FindBy(how = How.ID, using = "DepartDate")
	WebElement departdate;
	@FindBy(how = How.ID, using = "MoreOptionsLink")
	WebElement moreoptions;
	@FindBy(how = How.ID, using = "AirlineAutocomplete")
	WebElement airline;
	@FindBy(how = How.ID, using = "SearchBtn")
	WebElement search;
	@FindBy(how = How.ID, using = "homeErrorMessage")
	WebElement errormessage;

	public void selectAdults(int number) {
		Select s = new Select(adults);
		// default is 1
		if (number < 1 || number > 9)
			number = 1;

		s.selectByValue(String.valueOf(number));
	}

	public void selectChildrens(int number) {
		Select s = new Select(childrens);
		// default is 0
		if (number < 0 || number > 8)
			number = 0;

		s.selectByValue(String.valueOf(number));
	}

	public void selectDepartDate() {
		departdate.click();
		departdate.sendKeys(Keys.ENTER);

	}

	public void selectMoreOption(String name) {
		moreoptions.click();
		airline.sendKeys(name);
	}

	public void searchFlights() throws InterruptedException {
		search.click();
		System.out.println(errormessage.getText());

	}

}
