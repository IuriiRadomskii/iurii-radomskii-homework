package com.epam.tc.hw3.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractMenu {

    protected WebDriver driver;

    protected AbstractMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
