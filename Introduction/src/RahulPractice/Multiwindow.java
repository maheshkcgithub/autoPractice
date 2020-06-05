package RahulPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import CommonClasses.Constants;

public class Multiwindow {

	public void windowSwitch(WebDriver driver, String url) throws InterruptedException, IOException {
		driver.get(Constants.URL_RAHUL_PRACTICE);
		driver.findElement(By.cssSelector("#content ul li:nth-child(33) a")).click();
		driver.findElement(By.cssSelector("#content div a")).click();

		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> handleIterator = winHandles.iterator();

		String parentId = handleIterator.next();
		String childId = handleIterator.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("#content div h3")).getText());

	}

}
