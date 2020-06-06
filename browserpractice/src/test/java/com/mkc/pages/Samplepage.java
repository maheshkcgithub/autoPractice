package com.mkc.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Samplepage {

	WebDriver driver;

	/*
	 * Actions action; JavascriptExecutor jse2;
	 */
	Select selectOption;

	public Samplepage(WebDriver driver) {
		this.driver = driver;
		/*
		 * this.action = new Actions(driver); this.jse2 = (JavascriptExecutor) driver;
		 */
		this.selectOption = null;

	}

	@FindBy(how = How.ID, using = "g2599-name")
	WebElement Name;
	@FindBy(how = How.ID, using = "g2599-email")
	WebElement Email;
	@FindBy(how = How.ID, using = "g2599-website")
	WebElement Website;
	@FindBy(how = How.ID, using = "g2599-experienceinyears")
	WebElement SelectYears;
	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/div[5]/label[2]/input")
	WebElement FunctionalTesting;
	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/div[5]/label[3]/input")
	WebElement AutomationTesting;
	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/div[5]/label[4]/input")
	WebElement ManualTesting;

	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/div[6]/label[2]/input")
	WebElement Graduate;
	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/button")
	WebElement AlertButton;
	@FindBy(how = How.ID, using = "contact-form-comment-g2599-comment")
	WebElement Comment;
	@FindBy(how = How.XPATH, using = "//*[@id='contact-form-2599']/form/p[3]/button")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//*[@id='wpcf7-f2598-p2599-o1']/form/p/span/input")
	WebElement ProfilePic;
	
	
	public void selectYears(String year) {
		selectOption = new Select(SelectYears);
		selectOption.selectByVisibleText(year);
	}

	public void selectTesting(String testtype) {

		if (testtype.contains("functional")) {
			FunctionalTesting.click();
		} else if (testtype.contains("automation")) {
			AutomationTesting.click();
		} else {
			ManualTesting.click();
		}

	}

	public void setName(String name) {
		Name.sendKeys(name);
	}

	public void setEmail(String email1) {
		Email.sendKeys(email1);
	}

	public void setUrl(String url) {
		Website.sendKeys(url);
	}

	public void selectGraduationLevel(String level) {
		Graduate.click();
	}

	public void selectAlert(boolean ok) {
		AlertButton.click();
		Alert alert = driver.switchTo().alert();
		if (ok) {
			alert.accept();
			alert = driver.switchTo().alert();
			Assert.assertEquals("incorrect alert message", "Good Luck. Go for it", alert.getText());

		} else {
			alert.dismiss();
			alert = driver.switchTo().alert();
			Assert.assertEquals("incorrect alert message", "Good Bye!!!", alert.getText());
		}
		alert.accept();

	}

	public void sendComment(String comment) {
		Comment.sendKeys(comment);

	}
	
	public void submit() {
		Submit.click();
	}
	
	public void profilePic() {
		ProfilePic.sendKeys("C:\\Users\\Administrator\\Pictures\\switzerland.jpg");
		
	}

}
