package com.zlaman.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.zlaman.util.Browser;
import com.zlaman.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 */

public class TestBase {

    protected WebDriver driver;

    protected String baseUrl;

    protected Browser browser;
        
    @Parameters({ "grid2.hub", "base.url", "browser.name", "browser.version", "browser.platform" })
    @BeforeSuite
    public void init(String gridHubUrl, String baseUrl, String browserName, String browserVersion, String browserPlatform) {
        browser = new Browser();
        browser.setName(browserName);
        browser.setVersion(browserVersion);
        browser.setPlatform(browserPlatform);
        
        driver = WebDriverFactory.getInstance(gridHubUrl, browser);
        
        // Ожидание при поиске элемента
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public boolean verifyTextPresentIn(By by, String text){
        try { 
            if(driver.findElement(by).getText().contains(text) == true){
                return true;
            }
            return false;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    
    // Метод от Хрола
    public boolean isElementPresent(By locator){
        List<WebElement> list = driver.findElements(locator);
        if (list.size() == 0){
            return false;
        } else {
            return list.get(0).isDisplayed();
        }
    }

}
