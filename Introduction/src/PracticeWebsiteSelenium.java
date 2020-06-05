import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWebsiteSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("#radio-btn-example fieldset label:nth-child(2) input")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("Nepal");
		driver.findElement(By.cssSelector("#dropdown-class-example option:nth-child(3)")).click();
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		
	}

}
