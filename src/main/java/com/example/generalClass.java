package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class generalClass {
	
	 WebDriver driver;
	 
	 public generalClass(WebDriver driver) {
	        this.driver = driver;
	               
	    }
	 
		
	 
public void waitForElementBy (By By) {
		 
		
			 
			 WebDriverWait wait = new WebDriverWait(driver, 5);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By));
		 
	 }
	 
	 	 
	 
	 public void clearWebElement(WebElement elementToClear) {
		 	
		 	elementToClear.sendKeys(Keys.CONTROL + "a");
		 	elementToClear.sendKeys(Keys.DELETE);
		 
	 }
}
