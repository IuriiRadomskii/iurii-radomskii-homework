package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected String handle;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage refresh() {
        driver.navigate().refresh();
        return this;
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

    public String getHandle() {
        return handle;
    }

}
