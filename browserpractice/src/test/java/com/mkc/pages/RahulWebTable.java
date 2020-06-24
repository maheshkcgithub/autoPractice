package com.mkc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RahulWebTable {
	WebDriver driver;
	// Actions action;

	public RahulWebTable(WebDriver driver) {
		this.driver = driver;
		// this.action = new Actions(driver);

	}

	@FindBy(how = How.CSS, using = "#product tbody tr")
	List<WebElement> table;
	@FindBy(how = How.CSS, using = "#product tbody tr:nth-child(1) th")
	List<WebElement> columns;
	@FindBy(how = How.CSS, using = "#product tbody tr:nth-child(3) td")
	List<WebElement> secondRow;

	public int rowscount() throws InterruptedException {

		return table.size();

	}

	public int columnscount() throws InterruptedException {

		return columns.size();

	}

	public String printSecondRow() throws InterruptedException {
		String test = "";
		for (int i = 0; i < secondRow.size(); i++) {
			test = test + secondRow.get(i).getText() + " ";
			

		}
		
		/*
		 * String arr[]=test.split(" "); System.out.println(arr[0]);
		 * System.out.println(arr[1]);
		 */

		return test;

	}
	
	

}
