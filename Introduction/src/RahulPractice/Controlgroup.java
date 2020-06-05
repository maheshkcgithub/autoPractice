package RahulPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonClasses.Constants;

public class Controlgroup {

	public void controlGroup(WebDriver driver) throws InterruptedException, IOException {
		driver.get(Constants.URL_CONTROLGROUP);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(framePath);
		Thread.sleep(2000);
		// Javascript Executor
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;

		// Javacsript dom for hidden object.
		WebElement carTypeButton = driver.findElement(By.id("car-type-button"));
		carTypeButton.click();
		carTypeButton.sendKeys(Keys.ARROW_DOWN);
		carTypeButton.sendKeys(Keys.ENTER);

		// To select radio,insurance button
		WebElement radioButton = driver.findElement(By.id("transmission-automatic"));
		WebElement insuranceButton = driver.findElement(By.id("insurance"));

		jse2.executeScript("arguments[0].click()", radioButton);
		jse2.executeScript("arguments[0].click()", insuranceButton);
		System.out.println(
				"Radio button is selected: " + driver.findElement(By.id("transmission-automatic")).isSelected());
		   

		// Spinner

		WebElement spinnerUp = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/span[2]/a[1]"));
		spinnerUp.click();
		spinnerUp.click();

		System.out.println("Number of cars booked: "
				+ driver.findElement(By.id("horizontal-spinner")).getAttribute("aria-valuenow"));

		// BookButton
		WebElement bookButton = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/button"));

		System.out.println("Book button is displayed: " + bookButton.isDisplayed());
		System.out.println("Book button is enabled: " + bookButton.isEnabled());

		Thread.sleep(3000);
		
		//jse2.executeScript("arguments[0].click()", bookButton);
		System.out.println("Book button before clicked: " + bookButton.isEnabled());
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(bookButton));
		bookButton.click();
		System.out.println("Book button after clicked: " + bookButton.isEnabled());

		Thread.sleep(3000);
	}

}
