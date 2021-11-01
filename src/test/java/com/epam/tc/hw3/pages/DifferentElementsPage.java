package com.epam.tc.hw3.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//label[@class='label-checkbox'][1]/input")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[@class='label-checkbox'][3]/input")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[@class='label-radio'][4]/input")
    private WebElement selenRadio;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOption;

    @FindBy(xpath = "//div[@class='checkbox-row'][1]")
    private List<WebElement> checkBoxRow;

    @FindBy(xpath = "//div[@class='checkbox-row'][2]")
    private List<WebElement> radioBoxRow;

    DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public DifferentElementsPage clickElement(WebElement element) {
        element.click();
        return this;
    }

    public WebElement getWaterCheckBox() {
        return waterCheckBox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getSelenRadio() {
        return selenRadio;
    }

    public WebElement getYellowOption() {
        return yellowOption;
    }
}
