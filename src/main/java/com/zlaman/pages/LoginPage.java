package com.zlaman.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zlaman.model.User;

/*
 * Login page
 * 
 */
public class LoginPage extends Page {

    @FindBy(how = How.CSS, using = "input.f_email[id *=dwfrm_login_username]")
    private WebElement userNameField;

    @FindBy(how = How.ID, using = "dwfrm_login_password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "dwfrm_login_rememberme")
    private WebElement rememberMeCheckBox;

    @FindBy(how = How.NAME, using = "dwfrm_login_login")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage loginWithUser(User user, Boolean rememberMeState) {
        userNameField.clear();
        userNameField.sendKeys(user.getEmailAddress());
        passwordField.clear();
        passwordField.sendKeys(user.getPassword());
        if (rememberMeState) {
            if (!rememberMeCheckBox.isSelected()) {
                rememberMeCheckBox.click();
            }
        }
        loginButton.click();
        return this;
    }

}