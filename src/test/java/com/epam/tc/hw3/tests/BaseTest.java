package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.IndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssertions softly;
    protected IndexPage indexPage;
    protected String expectedUserNameAtPage;
    protected String userName;
    protected String password;
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
    protected List<String> expectedLogs = List.of(
        "Colors: value changed to Yellow",
        "Colors: value changed to Blue",
        "Colors: value changed to Green",
        "metal: value changed to Selen",
        "metal: value changed to Bronze",
        "metal: value changed to Silver",
        "metal: value changed to Gold",
        "Fire: condition changed to true",
        "Wind: condition changed to true",
        "Earth: condition changed to true",
        "Water: condition changed to true"
    );

    @BeforeClass
    public void setupChromeDriver() {
        System.out.println("Before class");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softly = new SoftAssertions();
    }

    @AfterClass
    public void clear() {
        System.out.println("After class");
        driver.quit();
    }

    @BeforeMethod
    public void setupWindow() {
        System.out.println("Before method");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        indexPage = new IndexPage(driver);
        userName = getProperty("username");
        password = getProperty("password");
        expectedUserNameAtPage = getProperty("expectedUserNameAtPage");
    }

    protected String getProperty(String propertyName) {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw3/credentials.properties");
            property.load(inputStream);
            return property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return "";
    }
}
