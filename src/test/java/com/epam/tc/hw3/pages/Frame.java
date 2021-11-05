package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends IndexPage {

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    Frame(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public IndexPage switchBackTo(IndexPage indexPage) {
        driver.switchTo().window(super.getHandle());
        return indexPage;
    }
}
