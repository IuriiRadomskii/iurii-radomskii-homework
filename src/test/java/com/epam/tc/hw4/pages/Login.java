package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    @FindBy(xpath = "//a[@class='dropdown-toggle'][@href='#']")
    private WebElement toggleButton;

    @FindBy(id = "name")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public Index login(String userName, String password) {
        toggleButton.click();
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        loginButton.click();
        return new Index(driver);
    }
}
