package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.BaseComponent;
import com.epam.tc.hw5.page.component.HeaderComponent;
import com.epam.tc.hw5.page.component.LogsComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseComponent {

    protected String handle;
    protected HeaderComponent header;
    private LogsComponent logsTable;

    protected BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        logsTable = new LogsComponent(driver);
    }

    public List<String> getActualLogs() {
        return logsTable.getActualLogs();
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
