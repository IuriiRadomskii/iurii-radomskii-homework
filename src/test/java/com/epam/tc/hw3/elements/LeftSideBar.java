package com.epam.tc.hw3.elements;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideBar extends AbstractMenu {

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li")
    private List<WebElement> leftSideBarElements;

    public LeftSideBar(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLeftSideBarElements() {
        return leftSideBarElements;
    }


}
