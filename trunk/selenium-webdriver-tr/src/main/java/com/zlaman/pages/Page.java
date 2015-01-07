package com.zlaman.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 */
public class Page {

	protected WebDriver webDriver;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
    public boolean verifyTextPresentIn(WebElement webElement, String text){
        try { 
            if(webElement.getText().contains(text) == true){
                return true;
            }
            return false;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

}
