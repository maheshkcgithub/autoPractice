import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeWebsiteSelenium2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("div[role='navigation'] div.container div nav ul li:nth-child(2) a")).click();
		
		
		
		
	}

}
