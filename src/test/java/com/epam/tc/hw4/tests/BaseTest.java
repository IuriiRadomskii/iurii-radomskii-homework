package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.pages.Index;
import com.epam.tc.hw4.pages.Login;
import com.epam.tc.hw4.tests.data.PropertyInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected String userName;
    protected String password;

    @BeforeClass
    public void setup() {
        System.out.println("Before class");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userName = PropertyInit.getProperty("username");
        password = PropertyInit.getProperty("password");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class");
        driver.quit();
    }
}
