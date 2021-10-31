package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
