import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceE2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Already']")).click();
		driver.findElement(By.cssSelector("#login1")).sendKeys("mkc1");
		driver.findElement(By.cssSelector("input[name='passwd']")).sendKeys("pwd");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		System.out.println(driver.findElement(By.cssSelector("#div_login_error b")).getText());

		
	}

}
