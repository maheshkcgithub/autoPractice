import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.name("username")).sendKeys("Mahesh");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		//Catch error
		//System.out.println(driver.findElement(By.id("error")).getText());
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		System.out.println(driver.findElement(By.cssSelector("div.loginError")).getText());
		//driver.findElement(By.partialLinkText("forgotpassword")).click();
		driver.findElement(By.xpath("//*[@id='forgot_password_link']")).click();
	}

}
