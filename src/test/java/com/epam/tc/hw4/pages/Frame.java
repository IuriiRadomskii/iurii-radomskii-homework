package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends BasePage {

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    private BasePage parent;

    Frame(WebDriver driver, BasePage parent) {
        super(driver);
        this.parent = parent;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public BasePage switchBackTo() {
        driver.switchTo().window(parent.getHandle());
        return parent;
    }
}
