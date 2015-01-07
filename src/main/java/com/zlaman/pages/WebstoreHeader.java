package com.zlaman.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.zlaman.model.User;

/*
 * Webstore Header
 * 
 */
public class WebstoreHeader extends Page {

    @FindBy(how = How.CSS, using = "a.account_navigation_link.login_link")
    private WebElement headerLoginLink;

    @FindBy(how = How.CSS, using = "li.account_navigation_list_item.account_navigation_welcome")
    private WebElement headerWelcomeText;

    @FindBy(how = How.CSS, using = "a.logout_link")
    private WebElement headerLogoutLink;

    public WebstoreHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        headerLoginLink.click();
    }

    public boolean verifyUserIsLoggedIn(User user) {
        return verifyTextPresentIn(headerWelcomeText, user.getUserName());

    }

    public void logOff() {
        headerLogoutLink.click();
    }

}
