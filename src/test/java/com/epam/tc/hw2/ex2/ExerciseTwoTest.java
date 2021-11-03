package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ExerciseTwoTest extends BaseTest {

    @Test
    public void exerciseTwoTest() {
        //1. Assert that page is opened and downloaded
        String indexWindowURL = driver.getCurrentUrl();
        softly.assertThat(indexWindowURL).isEqualTo(url);

        //2. Assert that page title is 'Home Page'
        String expectedIndexPageTitle = "Home Page";
        String actualIndexPageTitle = driver.getTitle();
        softly.assertThat(actualIndexPageTitle).isEqualTo(expectedIndexPageTitle);

        //3. Assert that user is logged by given username and password
        WebElement toggleBtn = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][@href='#']"));
        toggleBtn.click();
        WebElement inputUserName = driver.findElement(By.id("name"));
        WebElement inputUserPass = driver.findElement(By.id("password"));
        inputUserName.sendKeys(userName);
        inputUserPass.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement contactFormBtn = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        contactFormBtn.click();
        String actualContactsPageTitle = driver.getTitle();
        driver.navigate().back();
        softly.assertThat(actualContactsPageTitle).isNotEqualTo(actualIndexPageTitle);

        //4. Assert that user name is displayed and equals to expected result
        WebElement userNameLogged = driver.findElement(By.id("user-name"));
        String actualUserNameAtPage = userNameLogged.getText();
        softly.assertThat(actualUserNameAtPage).isEqualTo(expectedUserNameAtPage);

        //5. Assert that Different Elements page is opened
        WebElement leftSidebarServiceBtn = driver
            .findElement(By.xpath("//ul[@class='sidebar-menu left']/li[@index=3]"));
        leftSidebarServiceBtn.click();
        WebElement leftSidebarDifElemsBtn = driver.findElement(By.xpath("//ul[@class='sub']/li[@index=8]"));
        leftSidebarDifElemsBtn.click();
        String expectedDifElemsPageTitle = "Different Elements";
        softly.assertThat(expectedDifElemsPageTitle).isEqualTo(driver.getTitle());

        //6. Assert that Water and Wind checkboxes are selected
        WebElement waterCheckBox = driver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input"));
        WebElement windCheckBox = driver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input"));
        waterCheckBox.click();
        windCheckBox.click();
        softly.assertThat(waterCheckBox.isSelected()).isTrue();
        softly.assertThat(windCheckBox.isSelected()).isTrue();

        //7. Assert that 'Selen' radio is checked
        WebElement selenRadioBox = driver.findElement(By.xpath("//label[@class='label-radio'][4]/input"));
        selenRadioBox.click();
        softly.assertThat(selenRadioBox.isSelected()).isTrue();

        //8. Assert that yellow option in dropdown menu is selected
        WebElement yellowOption = driver.findElement(By.xpath("//option[text()='Yellow']"));
        yellowOption.click();
        softly.assertThat(yellowOption.isSelected()).isTrue();

        //9. Assert that there is a separate log entry for each checkbox, radio button, and color option
        // corresponding to their status.
        driver.navigate().refresh();

        //9.1 Asserting checkboxes logs
        List<WebElement> checkBoxes = driver.findElements(By.className("label-checkbox"));
        checkCheckBoxes(checkBoxes, driver, softly);

        //9.2 Asserting radio boxes logs
        List<WebElement> radioBoxes = driver.findElements(By.className("label-radio"));
        checkRadioBoxes(radioBoxes, driver, softly);

        //9.3 Asserting color options logs
        List<WebElement> colorOptions = driver.findElements(By.tagName("option"));
        checkColorOptions(colorOptions, driver, softly);

        //10. Assert that browser is closed
        driver.close();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
        softly.assertAll();
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

    private void checkCheckBoxes(List<WebElement> checkBoxes, WebDriver driver,
                                   SoftAssertions softly) {
        assertCheckBoxes(checkBoxes, driver, softly, true);
        assertCheckBoxes(checkBoxes, driver, softly, false);
    }

    private void checkRadioBoxes(List<WebElement> radioBoxes, WebDriver driver, SoftAssertions softly) {
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

    private void checkColorOptions(List<WebElement> colorOptions, WebDriver driver, SoftAssertions softly) {
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
}
