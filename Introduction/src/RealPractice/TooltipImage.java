package RealPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class TooltipImage {

	public void imageInput(String imagebased, WebDriver driver) throws InterruptedException, IOException {
		driver.get(Constants.URL_SLIDERS);
		//Thread.sleep(5000);
		driver.findElement(By.id(imagebased)).click();
		Actions action = new Actions(driver);

		WebElement framePath = driver.findElement(By.xpath("//*[@id='post-2679']/div[2]/div/div/div[1]/p[1]/iframe"));
		
		
		driver.switchTo().frame(framePath);
		//Thread.sleep(5000);
		// First Image
		WebElement image = driver.findElement(By.cssSelector("body div:nth-child(1) div h3 a"));

		action.moveToElement(image).build().perform();

		WebElement tooltip = driver.findElement(By.cssSelector("body div:nth-child(1) div h3 a"));

		System.out.println(tooltip.getText());

		//Thread.sleep(1000);

		// Second Image

		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		image = driver.findElement(By.cssSelector("body div:nth-child(2) div h3 a"));

		action.moveToElement(image).build().perform();

		tooltip = driver.findElement(By.cssSelector("body div:nth-child(2) div h3 a"));

		System.out.println(tooltip.getText());

		//Thread.sleep(1000);

		// driver.quit();

	}

}
