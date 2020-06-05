package RahulPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonClasses.Constants;

public class Autodrop {

	/**
	 * @param driver
	 * @param url
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void autodrop(WebDriver driver, String url) throws InterruptedException, IOException {

		String regex = "\\bUnited Kingdom.*";

		driver.get(Constants.URL_AUTODROPPRACTICE);

		WebElement tagSelect = driver.findElement(By.id("autocomplete"));

		tagSelect.sendKeys("united");
		String str1;

		// Javacsript dom for hidden object.
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;

		while (true) {
			tagSelect.sendKeys(Keys.DOWN);
			
			  str1 = "return document.getElementById(\"autocomplete\").value;"; 
			  str1 =  (String) jsExe.executeScript(str1);
			 
			//str1 = tagSelect.getText();
			if (str1.matches(regex)) {
				System.out.println("Selecting country: " + str1);
				break;
			}
		}

	}
}
