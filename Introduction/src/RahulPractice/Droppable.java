package RahulPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class Droppable {

	public void droppable(WebDriver driver, String url) throws InterruptedException, IOException {
		driver.get(Constants.URL_DROPPABLE);
				
		Actions action = new Actions(driver);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(framePath);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		action.dragAndDrop(draggable, droppable).build().perform();		


	}

}
