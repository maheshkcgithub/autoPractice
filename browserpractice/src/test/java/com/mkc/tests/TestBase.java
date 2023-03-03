package com.mkc.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public static WebDriver driver=null;

	
	public static void initialize() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
}
////

