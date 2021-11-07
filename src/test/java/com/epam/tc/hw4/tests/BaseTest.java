package com.epam.tc.hw4.tests;

import com.epam.tc.hw3.tests.data.Expected;
import com.epam.tc.hw4.data.PropertyInit;
import com.epam.tc.hw4.utils.ExerciseOneListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExerciseOneListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected String userName;
    protected String password;

    private void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void setupCredentials() {
        userName = PropertyInit.getProperty("username");
        password = PropertyInit.getProperty("password");
    }

    private void setupInitialState() {
        driver.navigate().to(Expected.indexURL);
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void setup(/*ITestContext context*/) {
        System.out.println("Before class");
        setupDriver();
        setupCredentials();
        setupInitialState();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class");
        if (driver != null) {
            driver.quit();
        }

    }

    @BeforeMethod
    public void initTest(ITestContext context) {
        context.setAttribute("driver", driver);
    }
}
