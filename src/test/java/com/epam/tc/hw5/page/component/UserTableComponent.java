package com.epam.tc.hw5.page.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTableComponent extends BaseComponent {

    private final String tableXpath = "//table[@id='user-table']//";

    @FindBy(xpath = tableXpath + "select/option[@selected='']")
    private List<WebElement> dropdownMenus;

    @FindBy(xpath = tableXpath + "a[string-length(text()) > 0]")
    private List<WebElement> usernames;

    @FindBy(xpath = tableXpath + "span[string-length(text()) > 0]")
    private List<WebElement> descriptions;

    @FindBy(xpath = tableXpath + "input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = tableXpath + "tr[1]//select/option")
    private List<WebElement> userRomanDropDownMenuElements;

    @FindBy(xpath = tableXpath + "tbody/tr[2]/td[4]//input")
    private WebElement vipCheckBox;

    public UserTableComponent(WebDriver driver) {
        super(driver);
    }

    private List<String> getElementsTexts(List<WebElement> elements) {
        return elements
            .stream()
            .map(WebElement::getText)
            .map(StringBuilder::new)
            .map(s -> s.toString().replace("\n", " "))
            .collect(Collectors.toList());
    }

    public List<String> getDropDownMenuTexts() {
        return getElementsTexts(userRomanDropDownMenuElements);
    }

    public List<String> getUsernamesTexts() {
        return getElementsTexts(usernames);
    }

    public List<String> getDescriptionsTexts() {
        return getElementsTexts(descriptions);
    }

    public List<WebElement> getDropdownMenus() {
        return dropdownMenus;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public WebElement getVipCheckBox() {
        return vipCheckBox;
    }
}
