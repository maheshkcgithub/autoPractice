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

public class Steps {

	public void stepsInput(String steps, WebDriver driver) throws InterruptedException, IOException {
		driver.get(Constants.URL_SLIDERS);
		// Thread.sleep(3000);
		driver.findElement(By.id(steps)).click();
		Actions action = new Actions(driver);
		WebElement framePath = driver.findElement(By.xpath("//*[@id='post-2673']/div[2]/div/div/div[3]/p/iframe"));

		driver.switchTo().frame(framePath);
		// Thread.sleep(3000);

		WebElement slider = driver.findElement(By.cssSelector("#slider span"));
		Dimension dim = slider.getSize();
		int xoffset = dim.getWidth();

		action.clickAndHold(slider).moveByOffset(xoffset + 80, 0).release().build().perform();

		// clickAndHold just holds it, so one needs to move offset and then release

		WebElement amountValue = driver.findElement(By.id("amount"));

		File scrFile = ((TakesScreenshot) amountValue).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File("c:\\tmp\\stepshot.png"));

		// Thread.sleep(2000);

		// driver.quit();

	}
}
