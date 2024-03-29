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

public class Sortable {

	public void sortable(WebDriver driver, String url) throws InterruptedException, IOException {
		driver.get(Constants.URL_SORTABLE);

		Actions action = new Actions(driver);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(framePath);
		WebElement sortable1 = driver.findElement(By.cssSelector("#sortable li:nth-child(1)"));
		WebElement sortable2 = driver.findElement(By.cssSelector("#sortable li:nth-child(2)"));
		WebElement sortable5 = driver.findElement(By.cssSelector("#sortable li:nth-child(5)"));	
		Thread.sleep(2000);
		
		//selection 1st 4th and 5th in a group
		//action.dragAndDrop(sortable1, sortable3).release().build().perform();
		action.clickAndHold(sortable1).moveToElement(sortable5).moveByOffset(0, 20).release().build().perform();
		//action.clickAndHold(sortable1).moveByOffset(0, 40).release().build().perform();
		//action.dragAndDropBy(sortable1, 0, 120).build().perform();
		
		
		Thread.sleep(2000);
	}

}
