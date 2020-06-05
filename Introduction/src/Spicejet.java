import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/accordion-and-tabs/");
		System.out.println(driver.getTitle());
		
		/*driver.findElement(By.cssSelector("#block_top_menu ul li:nth-child(1) a")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#categories_block_left div ul li:nth-child(1) a")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#uniform-layered_category_5 span input")).click();
		driver.findElement(By.cssSelector("#uniform-layered_id_attribute_group_1 span input")).click();
		
		driver.findElement(By.cssSelector("#layered_id_attribute_group_14")).click();*/
				
		
	}

}
