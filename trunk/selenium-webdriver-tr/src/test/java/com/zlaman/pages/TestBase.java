package com.zlaman.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
    protected LoginPage loginPage;
    protected WebstoreHeader webstoreHeader;

    @Parameters({ "grid2.hub", "base.url", "browser.name", "browser.version",
            "browser.platform" })
    @BeforeSuite
    public void init(String gridHubUrl, String baseUrl, String browserName,
            String browserVersion, String browserPlatform) {
        browser = new Browser();
        browser.setName(browserName);
        browser.setVersion(browserVersion);
        browser.setPlatform(browserPlatform);

        driver = WebDriverFactory.getInstance(gridHubUrl, browser);

        driver.get(baseUrl);

        loginPage = initElements(new LoginPage(driver));
        webstoreHeader = initElements(new WebstoreHeader(driver));

    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
                page);
        return page;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Метод от Хрола
    public boolean isElementPresent(By locator) {
        List<WebElement> list = driver.findElements(locator);
        if (list.size() == 0) {
            return false;
        } else {
            return list.get(0).isDisplayed();
        }
    }

}
