package com.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// A select few examples based on the test cases

public class exerciseTests {

    WebDriver driver;

   
    // General Navigation Tests     
    @Test
    public void M008_navigateToAboutPage() {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	aboutPage aboutPage = mainPage.selectAboutPage();
    	
    	
    }
    
    @Test
    public void M013_navigateToBuyEnergyPage() {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	buyEnergyPage buyEnergyPage = mainPage.selectBuyEnergyButton();
    	
    	
    }

    @Test
    public void B002_navigateToHomePage() {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	buyEnergyPage buyEnergyPage = mainPage.selectBuyEnergyButton();
    	buyEnergyPage.homepageSelect();    	
    	
    }
    
    @Test(dataProvider = "loginAccounts")
    public void L004_accountLogin(String Email, String Password) {	//This test will fail

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	loginPage loginPage = mainPage.selectLoginPage();
    	loginPage.accountLogin(Email, Password);   	
    	
    }
    
    // Buy Energy Tests
    @Test
    public void B007_buyGasInQuantityOf1() {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	buyEnergyPage buyEnergyPage = mainPage.selectBuyEnergyButton();
    	buyEnergyPage.purchaseGasQuantity(1);   	
    	
    }
    
    @Test
    public void B008_buyGasInQuantityOf500() {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	buyEnergyPage buyEnergyPage = mainPage.selectBuyEnergyButton();
    	buyEnergyPage.purchaseGasQuantity(500);   	
    	
    }
    
    @Test(dataProvider = "gasPurchaseData")
    public void B008_9_10_buyGasInQuantity(int gasUnitRequired) {

    	mainPage mainPage = PageFactory.initElements(driver, mainPage.class);
    	buyEnergyPage buyEnergyPage = mainPage.selectBuyEnergyButton();
    	buyEnergyPage.purchaseGasQuantity(gasUnitRequired);   	
    	
    }
    
   // TestNG Methods
    @BeforeMethod
    public void beforeMethod() {

    	  System.setProperty("webdriver.chrome.driver",
                  "C:\\Selenium\\chromedriver_win32_b84\\chromedriver.exe");
          ChromeOptions  chromeOptions = new ChromeOptions();
          chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
          driver = new ChromeDriver(chromeOptions);
          driver.manage().window().maximize();
    	  	   	
        
    }
    
    @AfterMethod
    public void afterMethod() throws InterruptedException {

        // close and quit the browser
    	Thread.sleep(2000);
        driver.quit();
    }
    
    // Data Sets
    @DataProvider(name = "gasPurchaseData")
    public Object[][] gasPurchaseData() {
        return new Object[][]{
                {1},
                {30},
                {500},
                {3000}
        };
    }
    
    @DataProvider(name = "loginAccounts")
    public Object[][] loginAccounts() {
        return new Object[][]{
                {"bugs.bunny@warner.com","!IeatCarr0ts"},
                {"micky.mouse@disney.com","!IdonteatCarr0ts"}
        };
    }

}

