package RahulPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class Resizable {

	public void resizable(WebDriver driver, String url) throws InterruptedException, IOException {
		driver.get(Constants.URL_RESIZEABLE);
				
		Actions action = new Actions(driver);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(framePath);
		WebElement resizable = driver.findElement(By.cssSelector("#resizable div:nth-child(4)"));
		
		System.out.println(resizable.getAttribute("class"));
		action.clickAndHold(resizable).moveByOffset(50, 100).release().build().perform();
		
		Thread.sleep(1000);
		
		
	}

}
