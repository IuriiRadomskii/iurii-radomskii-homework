package com.epam.tc.hw5.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTableComponent extends BaseComponent {

    private final String tableXpath = "//table[@id='user-table']//";

    @FindBy(xpath = tableXpath + "select")
    private List<WebElement> dropdownMenus;

    @FindBy(xpath = tableXpath + "a[string-length(text()) > 0]")
    private List<WebElement> usernames;

    @FindBy(xpath = tableXpath + "span[string-length(text()) > 0]")
    private List<WebElement> descriptions;

    @FindBy(xpath = tableXpath + "input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public UserTableComponent(WebDriver driver) {
        super(driver);
    }

}
