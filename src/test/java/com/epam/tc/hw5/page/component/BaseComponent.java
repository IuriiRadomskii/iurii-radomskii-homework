package com.epam.tc.hw5.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {

    protected WebDriver driver;
    protected Actions actions;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
