package com.epam.tc.hw5.page.component;

import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.UserTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BaseComponent {

    @FindBy(xpath = "//a[@class='dropdown-toggle'][@href='#']")
    private WebElement loginToggleBtn;

    @FindBy(id = "name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")
    private WebElement serviceToggle;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='user-table.html']")
    private WebElement userTableBtn;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='different-elements.html']")
    private WebElement differentElementsBtn;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent clickLoginToggle() {
        loginToggleBtn.click();
        return this;
    }

    public HeaderComponent inputUserName(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public HeaderComponent inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HeaderComponent clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public HeaderComponent clickServiceToggle() {
        serviceToggle.click();
        return this;
    }

    public UserTablePage clickUserTableBtn() {
        userTableBtn.click();
        return new UserTablePage(driver);
    }

    public DifferentElementsPage clickDifferentElementsBtn() {
        differentElementsBtn.click();
        return new DifferentElementsPage(driver);
    }

}
