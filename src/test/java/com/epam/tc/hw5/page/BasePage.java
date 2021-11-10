package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.BaseComponent;
import com.epam.tc.hw5.page.component.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseComponent {

    protected String handle;
    protected HeaderComponent header;

    protected BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public void close() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getHandle() {
        return handle;
    }

}
