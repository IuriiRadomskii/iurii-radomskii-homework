
package com.epam.tc.hw3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssertions softly;

    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softly = new SoftAssertions();
    }

    @AfterClass
    public void clear() {
        driver.quit();
    }

    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final Set<String> expectedHeadersBtnsName = Set
        .of("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");
    protected final Set<String> expectedTextUnderIcons = Set
        .of("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "To include good practices\nand ideas from successful\nEPAM project");
    protected final Set<String> expectedNavigationSidebarText = Set
        .of("Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");

    protected static String expectedUserNameAtPage;
    protected static String userName;
    protected static String password;

    protected static void setExpectedUserNameAtPage() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw2/credentials.properties");
            property.load(inputStream);
            expectedUserNameAtPage = property.getProperty("expectedUserNameAtPage");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
    }

    protected static void setUserName() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw2/credentials.properties");
            property.load(inputStream);
            userName = property.getProperty("username");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
    }

    protected static void setPassword() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw2/credentials.properties");
            property.load(inputStream);
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
    }


}