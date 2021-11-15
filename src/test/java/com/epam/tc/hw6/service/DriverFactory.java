package com.epam.tc.hw6.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static final String LOCAL_LAUNCH = "LOCAL";
    private static final String REMOTE_LAUNCH = "REMOTE";

    private DriverFactory() {

    }

    public static WebDriver getDriver(LaunchType launchType, BrowserType browser) {
        WebDriver driver;
        if (launchType.toString().equalsIgnoreCase(LOCAL_LAUNCH)) {
            driver = getLocalDriver(browser);
        } else if (launchType.toString().equalsIgnoreCase(REMOTE_LAUNCH)) {
            driver = getRemoteDriver(browser);
        } else {
            throw new IllegalArgumentException();
        }
        return driver;
    }

    private static WebDriver getLocalDriver(BrowserType browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid local driver");
        }
        return driver;
    }

    private static WebDriver getRemoteDriver(final BrowserType browser) {
        WebDriver driver;
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = new ChromeOptions();
                break;
            case FIREFOX:
                capabilities = new FirefoxOptions();
                break;
            default:
                throw new IllegalArgumentException("Invalid remote driver");
        }
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid hub URL");
        }
        return driver;
    }
}

