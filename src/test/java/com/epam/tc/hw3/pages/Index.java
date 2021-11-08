
package com.epam.tc.hw3.pages;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index extends BasePage {

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

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> headersBtns;

    @FindBy(className = "benefit-icon")
    private List<WebElement> iconsOnIndexPage;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIconsElements;

    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> navigationSidebarElems;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']//li[@index=3]")
    private WebElement serviceBtn;

    @FindBy(xpath = "//ul[@class='sub']/li[@index=8]")
    private WebElement differentElementsBtn;

    public WebElement getIframe() {
        return iframe;
    }

    public Index(WebDriver driver) {
        super(driver);
    }

    public Index openPage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        this.handle = getWindowHandle();
        return this;
    }

    public Set<String> getHeadersBtnsName() {
        return headersBtns
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
    }

    public boolean isIconsDisplayed() {
        return iconsOnIndexPage
            .stream()
            .allMatch(WebElement::isDisplayed);
    }

    public Set<String> getActualTextUnderIcons() {
        return textUnderIconsElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toCollection(TreeSet::new));
    }

    public Frame switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
        return new Frame(driver, this);
    }

    public Set<String> getActualNavigationSidebarText() {
        return navigationSidebarElems
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
    }

    public String getActualUserNameAtPage() {
        return userNameText.getText();
    }

    public WebElement getUserNameText() {
        return userNameText;
    }

    public Index login(String userName, String password) {
        toggleButton.click();
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        loginButton.click();
        return this;
    }

    public DifferentElements goToDiffElemsPage() {
        serviceBtn.click();
        differentElementsBtn.click();
        return new DifferentElements(driver);
    }

}
