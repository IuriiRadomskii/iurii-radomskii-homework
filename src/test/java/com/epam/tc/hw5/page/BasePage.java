package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.AbstractComponent;
import com.epam.tc.hw5.page.component.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractComponent {

    private final String baseURL = "https://jdi-testing.github.io/jdi-light/";
    protected HeaderComponent header;

    protected BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public IndexPage login(String username, String password) {
        return header.login(String username, String password);
    }

    public HeaderComponent clickServiceDropdownMenu() {
        return header.clickServiceDropdownMenu();
    }

    public DifferentElementsPage clickDifferentElementsInDropDownMenu() {
        return header.clickDifferentElementsInDropDownMenu();
    }

    protected void open(String url) {
        driver.navigate().to(baseURL + url);
    }

}
