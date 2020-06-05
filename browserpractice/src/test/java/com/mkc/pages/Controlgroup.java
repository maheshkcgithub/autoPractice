package com.mkc.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Controlgroup {

	WebDriver driver;
	Actions action;
	JavascriptExecutor jse2;

	public Controlgroup(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		this.jse2 = (JavascriptExecutor) driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id='content']/iframe")
	WebElement framePath;
	@FindBy(how = How.ID, using = "car-type-button")
	WebElement carTypeButton;
	@FindBy(how = How.ID, using = "transmission-automatic")
	WebElement automaticButton;
	@FindBy(how = How.ID, using = "transmission-standard")
	WebElement standardButton;
	@FindBy(how = How.ID, using = "insurance")
	WebElement insuranceButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/fieldset[1]/div/span[2]/a[1]")
	WebElement spinnerup;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/fieldset[1]/div/button")
	WebElement bookButton;
	@FindBy(how = How.ID, using = "horizontal-spinner")
	WebElement spinnerQuantity;

	public void selectCar(String carType, int quantity) {
		driver.switchTo().frame(framePath);
		while (true) {
			carTypeButton.click();
			carTypeButton.sendKeys(Keys.ARROW_DOWN);
			carTypeButton.sendKeys(Keys.ENTER);
			if (carTypeButton.getText().matches(carType))
				break;
		}

		for (int i = 0; i < quantity; i++) {
			spinnerup.click();
		}

		Assert.assertEquals("Car selected does not match to input", quantity, Integer.parseInt(spinnerQuantity.getAttribute("aria-valuenow")));
		Assert.assertEquals("Car type selected does not match with input", carType,carTypeButton.getText());

	}

	public void setInsurance(boolean insurance) {

		// JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		if (insurance) {
			jse2.executeScript("arguments[0].click()", insuranceButton);
		}

	}

	public boolean getInsurance() {
		return insuranceButton.isSelected();
	}

	public void setAutomatic(boolean automatic) {

		// JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		if (automatic) {
			jse2.executeScript("arguments[0].click()", automaticButton);
		} else {
			jse2.executeScript("arguments[0].click()", standardButton);
		}

	}

	public boolean getAutomatic() {

		return automaticButton.isSelected();
	}

}

/*
 * public void controlGroup(WebDriver driver, String url) throws
 * InterruptedException, IOException { driver.get(Constants.URL_CONTROLGROUP);
 * 
 * WebElement framePath =
 * driver.findElement(By.xpath("//*[@id='content']/iframe"));
 * driver.switchTo().frame(framePath); Thread.sleep(2000); // Javascript
 * Executor JavascriptExecutor jse2 = (JavascriptExecutor) driver;
 * 
 * // Javacsript dom for hidden object. WebElement carTypeButton =
 * driver.findElement(By.id("car-type-button")); carTypeButton.click();
 * carTypeButton.sendKeys(Keys.ARROW_DOWN); carTypeButton.sendKeys(Keys.ENTER);
 * 
 * // To select radio,insurance button WebElement radioButton =
 * driver.findElement(By.id("transmission-automatic")); WebElement
 * insuranceButton = driver.findElement(By.id("insurance"));
 * 
 * jse2.executeScript("arguments[0].click()", radioButton);
 * jse2.executeScript("arguments[0].click()", insuranceButton);
 * System.out.println( "Radio button is selected: " +
 * driver.findElement(By.id("transmission-automatic")).isSelected());
 * System.out.println("Insurance button is selected: " +
 * driver.findElement(By.id("insurance")).isSelected());
 * 
 * // Spinner
 * 
 * WebElement spinnerUp =
 * driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/span[2]/a[1]")
 * ); spinnerUp.click(); spinnerUp.click();
 * 
 * System.out.println("Number of cars booked: " +
 * driver.findElement(By.id("horizontal-spinner")).getAttribute("aria-valuenow")
 * );
 * 
 * // BookButton WebElement bookButton =
 * driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/button"));
 * 
 * System.out.println("Book button is displayed: " + bookButton.isDisplayed());
 * System.out.println("Book button is enabled: " + bookButton.isEnabled());
 * 
 * jse2.executeScript("arguments[0].click()", bookButton);
 * System.out.println("Book button is clicked: " + bookButton.isSelected());
 * 
 * Thread.sleep(3000); }
 */
