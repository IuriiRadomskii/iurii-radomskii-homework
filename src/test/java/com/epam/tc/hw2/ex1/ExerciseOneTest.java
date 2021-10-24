package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExerciseOneTest {

    private WebDriver driver;
    private SoftAssertions softly = null;
    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String userName = "Roman";
    private final String pass = "Jdi1234";

    public ExerciseOneTest() {
    }

    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softly = new SoftAssertions();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void exerciseOneTest() {
        //1. Assert that page is opened and downloaded
        String indexPageID = driver.getWindowHandle();
        softly.assertThat(indexPageID).isNotNull();

        //2. Assert that page title is 'Home Page'
        String expectedIndexPageTitle = "Home Page";
        String actualIndexPageTitle = driver.getTitle();
        softly.assertThat(actualIndexPageTitle).isEqualTo(expectedIndexPageTitle);

        //3. Assert that user is logged by given username and password
        WebElement toggleBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver.findElement(By.xpath("//a[@class='dropdown-toggle'][@href='#']")));
        toggleBtn.click();
        WebElement inputUserName = driver.findElement(By.id("name"));
        WebElement inputUserPass = driver.findElement(By.id("password"));
        inputUserName.sendKeys(userName);
        inputUserPass.sendKeys(pass);
        WebElement loginBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver.findElement(By.id("login-button")));
        loginBtn.click();
        WebElement contactFormBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions
                .presenceOfElementLocated(By
                    .xpath("//a[@href='contacts.html']")));
        contactFormBtn.click();
        String actualContactsPageTitle = driver.getTitle();
        driver.switchTo().window(indexPageID);
        softly.assertThat(actualContactsPageTitle).isNotEqualTo(actualIndexPageTitle);

        //4.Assert that user name is displayed and equals to expected result
        WebElement userNameLogged = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        String userNameLoggedText = userNameLogged.getText();
        String userNameAfterLoggingCssTextTransf userNameLogged.getCssValue()

        softly.assertAll();
    }


    @AfterClass
    public void clear() {
        driver.quit();
        driver = null;


    }

}
