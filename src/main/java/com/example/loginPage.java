package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {
	WebDriver driver;
	 
	 public loginPage(WebDriver driver) {
	        this.driver = driver;    

	 }
	 
	 public void accountLogin(String Email, String Password) {
		 
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.cssSelector(Locator_VARS.LOGIN_Login));
		 
		 WebElement emailElement = driver.findElement(By.id(Locator_VARS.LOGIN_Email));		 
		 generalClass.clearWebElement(emailElement);
		 emailElement.sendKeys(Email);
		 
		 WebElement passwordElement = driver.findElement(By.id(Locator_VARS.LOGIN_Password));		 
		 generalClass.clearWebElement(passwordElement);
		 passwordElement.sendKeys(Password);
		 
		 driver.findElement(By.cssSelector(Locator_VARS.LOGIN_Login)).click();
		 // Need to check the Login happened
		 generalClass.waitForElementBy(By.linkText(Locator_VARS.LOGIN_ActiveUser));
		 
		 
	 }

}
