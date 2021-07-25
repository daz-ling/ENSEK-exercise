package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class buyEnergyPage {
	
	 WebDriver driver;
	 
	 public buyEnergyPage(WebDriver driver) {
	        this.driver = driver;
	       	        
	    }
	 	
	 
	 public void homepageSelect() {
		 
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.linkText(Locator_VARS.BUY_Homepage));
			
		 WebElement button = driver.findElement(By.linkText(Locator_VARS.BUY_Homepage));
		 button.click();
			
		 Assert.assertEquals(driver.getTitle(), "ENSEK Energy Corp. - Candidate Test");
	 }
	 
	 public void purchaseGasQuantity(int gasQuantity) {
		 
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.cssSelector(Locator_VARS.BUY_Reset_Button));
		 
		 		 
		 driver.findElement(By.cssSelector(Locator_VARS.BUY_Reset_Button)).click();	
		 int gasBefore = Integer.parseInt(driver.findElement(By.cssSelector(Locator_VARS.BUY_Gas_Avaliable)).getText());
		 
		 WebElement gasText = driver.findElement(By.cssSelector(Locator_VARS.BUY_Gas_Text_Box));		 
		 generalClass.clearWebElement(gasText);
		 gasText.sendKeys(Integer.toString(gasQuantity));
		 driver.findElement(By.cssSelector(Locator_VARS.BUY_Gas_Buy_button)).click();	
		 driver.findElement(By.cssSelector(Locator_VARS.SALE_Buy_More)).click();	
		 
		 int gasAfter = Integer.parseInt(driver.findElement(By.cssSelector(Locator_VARS.BUY_Gas_Avaliable)).getText());
		 int gasRequiredValue = gasBefore - gasQuantity;
		 
		 Assert.assertEquals(gasAfter, gasRequiredValue);
	 }
	 
	 
}
