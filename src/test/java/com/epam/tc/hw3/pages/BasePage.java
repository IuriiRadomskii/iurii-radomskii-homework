package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage refresh() {
        driver.navigate().refresh();
        return this;
    }


    public void close() {
        driver.close();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }


}
