package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class mainPage {
	
	WebDriver driver;
	
	
	public mainPage(WebDriver driver) {
        this.driver = driver;            
        driver.get("https://ensekautomationcandidatetest.azurewebsites.net/");
    }

	
	public buyEnergyPage selectBuyEnergyButton() {
		
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.cssSelector(Locator_VARS.MAIN_Buy_Energy_Button));
		 
		 WebElement menu = driver.findElement(By.cssSelector(Locator_VARS.MAIN_Buy_Energy_Button));
		 menu.click();
		 Assert.assertEquals(driver.getTitle(), "Buy - Candidate Test");
		 
		return PageFactory.initElements(driver,
				buyEnergyPage.class);
		
	}
	
	public aboutPage selectAboutPage() {
		
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.linkText(Locator_VARS.MAIN_About));
		 
		 WebElement menu = driver.findElement(By.linkText(Locator_VARS.MAIN_About));
		 menu.click();
		 Assert.assertEquals(driver.getTitle(), "About ENSEK Energy Corp. - Candidate Test");
		 
		return PageFactory.initElements(driver,
				aboutPage.class);
		
	}
	
	public loginPage selectLoginPage() {
		
		 generalClass generalClass = new generalClass(driver);
		 generalClass.waitForElementBy(By.linkText(Locator_VARS.MAIN_Login));
		 
		 WebElement menu = driver.findElement(By.linkText(Locator_VARS.MAIN_Login));
		 menu.click();
		 Assert.assertEquals(driver.getTitle(), "Log in - Candidate Test");
		 
		return PageFactory.initElements(driver,
				loginPage.class);		
	}
	
	
}
