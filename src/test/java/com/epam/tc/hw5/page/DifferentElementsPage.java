package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.LogsComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    private LogsComponent logsTable;

    @FindBy(xpath = "//label[@class='label-checkbox'][1]/input")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[@class='label-checkbox'][3]/input")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[@class='label-radio'][4]/input")
    private WebElement selenRadio;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOption;

    public DifferentElementsPage(WebDriver driver) {
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
