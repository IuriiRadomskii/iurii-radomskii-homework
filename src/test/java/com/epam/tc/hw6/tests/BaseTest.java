package com.epam.tc.hw6.tests;

import com.epam.tc.hw3.tests.data.Expected;
import com.epam.tc.hw6.data.PropertyInit;
import com.epam.tc.hw6.service.DriverProvider;
import com.epam.tc.hw6.utils.ScreenshotListener;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected String userName;
    protected String password;

    private void setupDriver() {
        driver = DriverProvider.getWebDriver();
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
    public void setup(ITestContext context) {
        System.out.println("Before class");
        setupCredentials();
        driver = DriverProvider.getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(Expected.indexURL);
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.closeWebDriver();
    }
}
