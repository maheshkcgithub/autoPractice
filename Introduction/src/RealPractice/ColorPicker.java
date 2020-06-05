package RealPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class ColorPicker {

	public void colorPickerInput(String colorPicker, WebDriver driver, String url) throws InterruptedException {
		driver.get(Constants.URL_SLIDERS);
		driver.findElement(By.id(colorPicker)).click();
		Actions action = new Actions(driver);
		WebElement framePath = driver.findElement(By.xpath("//*[@id='post-2673']/div[2]/div/div/div[1]/p/iframe"));

		driver.switchTo().frame(framePath);
		// Thread.sleep(2000);

		WebElement redSpan = driver.findElement(By.cssSelector("#red span"));
		Dimension dimRed = redSpan.getSize();
		int xred = dimRed.getWidth();
		WebElement greenSpan = driver.findElement(By.cssSelector("#green span"));
		Dimension dimGreen = greenSpan.getSize();
		int xgreen = dimGreen.getWidth();
		// clickAndHold just holds it, so one needs to move offset and then release
		// Thread.sleep(1000);
		action.clickAndHold(redSpan).moveByOffset(xred - 300, 0).release().build().perform();
		// Thread.sleep(1000);
		action.clickAndHold(greenSpan).moveByOffset(xgreen - 200, 0).release().build().perform();

		// Thread.sleep(2000);
		// driver.quit();

	}
}
