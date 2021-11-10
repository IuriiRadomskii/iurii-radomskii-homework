package com.epam.tc.hw5.page;

import com.epam.tc.hw4.pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;
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

    @FindBy(xpath = "//div[@class='checkbox-row'][1]//input")
    private List<WebElement> checkBoxRow;

    @FindBy(xpath = "//div[@class='checkbox-row'][2]//input")
    private List<WebElement> radioBoxRow;

    @FindBy(tagName = "option")
    private List<WebElement> colorOptions;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getActualLogs() {
        return logs.stream()
                   .map(WebElement::getText)
                   .map(StringBuilder::new)
                   .map(s -> s.delete(0, 9))
                   .map(String::new).collect(Collectors.toList());
    }

    public DifferentElementsPage clickElement(WebElement element) {
        element.click();
        return this;
    }

    @Override
    public DifferentElementsPage refresh() {
        driver.navigate().refresh();
        return this;
    }

    public DifferentElementsPage clickInARow(List<WebElement> elementList) {
        for (WebElement elem : elementList) {
            elem.click();
        }
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

    public List<WebElement> getCheckBoxRow() {
        return checkBoxRow;
    }

    public List<WebElement> getRadioBoxRow() {
        return radioBoxRow;
    }

    public List<WebElement> getColorOptions() {
        return colorOptions;
    }

}
