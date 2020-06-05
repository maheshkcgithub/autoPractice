package RahulPractice;

import java.io.IOException;


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

public class Makemytrip {

	public void makeMytrip(WebDriver driver) throws InterruptedException, IOException {
		driver.get(Constants.URL_MAKEMYTRIP);

		// Javascript Executor
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		//Actions action = new Actions(driver);
		WebElement fromCity = driver.findElement(By.id("fromCity"));
		fromCity.click();
		Thread.sleep(3000);
		WebElement source=driver.findElement(By.xpath("//input[@placeholder='From']"));

		//fromCity.clear();
		source.sendKeys("mum");
		
		
		
		  //WebElement fromCityList = driver.findElement(By.id("react-autowhatever-1"));
		  Thread.sleep(2000);
		  source.sendKeys(Keys.ARROW_DOWN);
		  source.sendKeys(Keys.ARROW_DOWN);
		  source.sendKeys(Keys.ENTER);
		  
		  //fromCityList.sendKeys(Keys.ARROW_DOWN); fromCityList.sendKeys(Keys.ENTER);
		  System.out.println(fromCity.getAttribute("value"));
		 
		//action.keyDown(fromCity,Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
		
		

		Thread.sleep(3000);
	}

}
