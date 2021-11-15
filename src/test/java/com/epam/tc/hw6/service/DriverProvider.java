package com.epam.tc.hw6.service;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class DriverProvider {

    private static WebDriver driver;

    private DriverProvider() {}

    public static WebDriver getWebDriver() {
        if (Objects.isNull(driver)) {
            String launchType = System.getProperty("launch.type", "local");
            String browserType = System.getProperty("browser.type", "chrome");
            driver = DriverFactory.getDriver(LaunchType.valueOf(launchType.toUpperCase()),
                BrowserType.valueOf(browserType.toUpperCase()));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
