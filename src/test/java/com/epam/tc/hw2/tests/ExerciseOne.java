package com.epam.tc.hw2.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import


public class ExerciseOne {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    private WebElement webElement;
    private final String userName = "Roman";
    private final String pass = "Jdi1234";
    private final String loggedUserName = "ROMAN IOVLEV";
    private final String pageTitle = "Home Page";

    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().window().maximize();
        //SoftAssert softAssertion = new SoftAssert();
        Assertion.assertNotNull(webDriver.getTitle());
        Assertion.assertEquals(webDriver.getTitle(), pageTitle);
        Thread.sleep(1000);

    }

    @AfterClass
    public void clear() {
        webDriver.quit();
    }

}
