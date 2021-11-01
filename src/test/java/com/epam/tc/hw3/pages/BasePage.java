package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='index.html']")
    private WebElement homeBtn;

    BasePage(WebDriver driver) {
        super(driver);
    }

    public IndexPage goToIndexPage() {
        homeBtn.click();
        return new IndexPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }


}
