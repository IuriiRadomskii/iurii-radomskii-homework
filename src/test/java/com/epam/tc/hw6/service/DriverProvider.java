package com.epam.tc.hw6.service;

import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class DriverProvider {

    private static WebDriver driver;

    private DriverProvider() {}

    public static WebDriver getWebDriver() {
        if (Objects.isNull(driver)) {
            String launchType = System.getProperty("launch.type", "local");
            String browserType = System.getProperty("browser.type", "chrome");
            driver = DriverFactory.createDriver(LaunchType.valueOf(launchType.toUpperCase(Locale.ROOT)),
                BrowserType.valueOf(browserType.toUpperCase(Locale.ROOT)));
        }
        return driver;
    }

    public static void closeWebDriver() {
        driver.quit();
        driver = null;
    }
}
