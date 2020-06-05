package RealPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class Range {

	public void rangeInput(String range, WebDriver driver) throws InterruptedException, IOException {
		driver.get(Constants.URL_SLIDERS);
		
		driver.findElement(By.id(range)).click();
		Actions action = new Actions(driver);
		WebElement framePath = driver.findElement(By.xpath("//*[@id='post-2673']/div[2]/div/div/div[2]/p/iframe"));

		driver.switchTo().frame(framePath);
		
		WebElement rangeStart = driver.findElement(By.cssSelector("#slider-range span:nth-child(2)"));
		WebElement rangeEnd = driver.findElement(By.cssSelector("#slider-range span:nth-child(3)"));
		Dimension dimStart = rangeStart.getSize();
		int start = dimStart.getWidth();
		Dimension dimEnd = rangeEnd.getSize();
		int end = dimEnd.getWidth();

		// clickAndHold just holds it, so one needs to move offset and then release
		action.clickAndHold(rangeStart).moveByOffset(start + 50, 0).release().build().perform();
		
		action.clickAndHold(rangeEnd).moveByOffset(end + 30, 0).release().build().perform();

	

		WebElement offsetText = driver.findElement(By.id("amount"));
		
		File scrFile = ((TakesScreenshot)(offsetText)).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\rangeshot.png"));
		// driver.quit();

	}
}
