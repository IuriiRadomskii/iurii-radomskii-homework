package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.data.PropertyInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected String userName;
    protected String password;

    @BeforeClass
    public void setup(ITestContext context) {
        System.out.println("Before class");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userName = PropertyInit.getProperty("username");
        password = PropertyInit.getProperty("password");
        context.setAttribute("driver", driver);
        context.setAttribute("username", userName);
        context.setAttribute("password", password);
    }



    @AfterClass
    public void tearDown() {
        System.out.println("After class");
        driver.quit();
    }
}
