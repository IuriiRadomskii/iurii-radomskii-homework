
package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='dropdown-toggle'][@href='#']")
    private WebElement toggleButton;

    @FindBy(id = "name")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    public WebElement getUserNameText() {
        return userNameText;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login(String userName, String password) {
        toggleButton.click();
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        loginButton.click();
        return this;
    }



}
