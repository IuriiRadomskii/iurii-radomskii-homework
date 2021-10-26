package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SuppressWarnings("checkstyle:Indentation")
public class ExerciseTwoTest extends BaseTest {

    private WebDriver driver = null;
    private SoftAssertions softly = null;

    @BeforeClass
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softly = new SoftAssertions();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void exerciseTwoTest() throws InterruptedException {
        //1. Assert that page is opened and downloaded
        String indexWindowHandle = driver.getWindowHandle();
        softly.assertThat(indexWindowHandle).isNotNull();

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
        driver.navigate().back();
        softly.assertThat(actualContactsPageTitle).isNotEqualTo(actualIndexPageTitle);

        //4. Assert that user name is displayed and equals to expected result
        WebElement userNameLogged = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        String actualUserNameAtPage = userNameLogged.getText();
        softly.assertThat(actualUserNameAtPage).isEqualTo(expectedUserNameAtPage);

        //5. Assert that Support page is opened
        WebElement leftSidebarServiceBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("#mCSB_1_container > ul > li:nth-child(3) > a")));
        leftSidebarServiceBtn.click();
        WebElement leftSidebarDifElemsBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(8) > a")));
        leftSidebarDifElemsBtn.click();
        String expectedDifElemsPageTitle = "Different Elements";
        softly.assertThat(expectedDifElemsPageTitle).isEqualTo(driver.getTitle());

        //6. Assert that Water and Wind checkboxes are selected
        WebElement waterCheckBox = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("body > div > div.uui-main-container.page-inside > main > "
                        + "div.main-content > div > div:nth-child(2) > label:nth-child(1) > input[type=checkbox]")));
        WebElement windCheckBox = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("body > div > div.uui-main-container.page-inside > main > "
                        + "div.main-content > div > div:nth-child(2) > label:nth-child(3) > input[type=checkbox]")));
        waterCheckBox.click();
        windCheckBox.click();
        softly.assertThat(waterCheckBox.isSelected()).isTrue();
        softly.assertThat(windCheckBox.isSelected()).isTrue();

        //7. Assert that 'Selen' radio is checked
        WebElement selenRadioBox = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("body > div > div.uui-main-container.page-inside > main > "
                        + "div.main-content > div > div:nth-child(3) > label:nth-child(4) > input[type=radio]")));
        selenRadioBox.click();
        softly.assertThat(selenRadioBox.isSelected()).isTrue();

        //8. Assert that yellow option in dropdown menu is selected
        WebElement yellowOption = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElement(By
                    .cssSelector("body > div > div.uui-main-container.page-inside > main > "
                        + "div.main-content > div > div.colors > select > option:nth-child(4)")));
        yellowOption.click();
        softly.assertThat(yellowOption.isSelected()).isTrue();

        //9. Assert that there is a separate log entry for each checkbox, radio button, and color option
        // corresponding to their status.
        driver.navigate().refresh();

        //9.1 Asserting checkboxes logs
        List<WebElement> checkBoxes = new WebDriverWait(driver, Duration.ofSeconds(2000))
            .until(driver -> driver.findElements(By.className("label-checkbox")));
        checkCheckBoxes(checkBoxes, driver, softly);

        //9.2 Asserting radio boxes logs
        List<WebElement> radioBoxes = new WebDriverWait(driver, Duration.ofSeconds(2000))
            .until(driver -> driver.findElements(By.className("label-radio")));
        checkRadioBoxes(radioBoxes, driver, softly);

        //9.3 Asserting color options logs
        List<WebElement> colorOptions = new WebDriverWait(driver, Duration.ofSeconds(2000))
            .until(driver -> driver.findElements(By.tagName("option")));
        checkColorOptions(colorOptions, driver, softly);

        //10. Assert that browser is closed
        driver.close();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");

        softly.assertAll();
    }

    @AfterClass
    public void clear() {
        driver.quit();
        driver = null;
    }
}
