package RahulPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class Selectable {

	public void selectable(WebDriver driver, String url) throws InterruptedException, IOException {
		driver.get(Constants.URL_SELECTABLE);

		Actions action = new Actions(driver);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(framePath);
		WebElement selectable = driver.findElement(By.cssSelector("#selectable li:nth-child(1)"));
		WebElement selectable4 = driver.findElement(By.cssSelector("#selectable li:nth-child(4)"));
		WebElement selectable5 = driver.findElement(By.cssSelector("#selectable li:nth-child(5)"));	
		
		//selection 1st 4th and 5th in a group
		action.click(selectable).keyDown(Keys.CONTROL).click(selectable4).click(selectable5).build().perform();
		Thread.sleep(1000);

	}

}
