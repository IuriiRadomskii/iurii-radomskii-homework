package com.epam.tc.hw2.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.desktop.ScreenSleepEvent;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ExerciseOneTest {

    private WebDriverWait webDriverWait;
    private WebDriver driver;
    private WebElement webElement;
    private final String userName = "Roman";
    private final String pass = "Jdi1234";
    private final String loggedUserName = "ROMAN IOVLEV";
    private final String pageTitle = "Home Page";


    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        String pageID = driver.getWindowHandle();
        //System.out.println(pageID);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(pageID).isNotEmpty();
        String expectedPageTitle = driver.getTitle();
        softly.assertThat(pageTitle).isEqualTo(expectedPageTitle);
        //System.out.println(expectedPageTitle);


    }

    @AfterClass
    public void clear() {
        driver.quit();
        driver = null;
    }

}
