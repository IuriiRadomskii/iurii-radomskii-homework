
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


    protected String getExpectedUserNameAtPage() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw3/credentials.properties");
            property.load(inputStream);
            return property.getProperty("expectedUserNameAtPage");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return null;
    }

    protected String getUserName() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw3/credentials.properties");
            property.load(inputStream);
            return property.getProperty("username");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return null;
    }

    protected String getPassword() {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw3/credentials.properties");
            property.load(inputStream);
            return property.getProperty("password");
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return null;
    }


    private void assertCheckBoxes(List<WebElement> checkBoxes, WebDriver driver,
                                  SoftAssertions softly, boolean isSelected) {
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String checkBoxName = checkBox.getText();
            String actualLogText = log.getText();
            String expectedLogText = checkBoxName + ": condition changed to " + isSelected;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);

        }
    }

    protected void checkCheckBoxes(List<WebElement> checkBoxes, WebDriver driver,
                                   SoftAssertions softly) {
        assertCheckBoxes(checkBoxes, driver, softly, true);
        assertCheckBoxes(checkBoxes, driver, softly, false);
    }

    protected void checkRadioBoxes(List<WebElement> radioBoxes, WebDriver driver, SoftAssertions softly) {
        for (WebElement radioBox : radioBoxes) {
            radioBox.click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String radioBoxName = radioBox.getText();
            String actualLogText = log.getText();
            String expectedLogText = "metal: value changed to " + radioBoxName;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);

        }
    }

    protected void checkColorOptions(List<WebElement> colorOptions, WebDriver driver, SoftAssertions softly) {
        for (int i = 3; i >= 0; i--) {
            colorOptions.get(i).click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String optionName = colorOptions.get(i).getText();
            String actualLogText = log.getText();
            String expectedLogText = "Colors: value changed to " + optionName;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);
        }
    }

    @AfterClass
    public void clear() {
        driver.quit();
    }
}