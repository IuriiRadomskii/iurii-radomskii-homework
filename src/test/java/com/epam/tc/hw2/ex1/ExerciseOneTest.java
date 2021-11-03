package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ExerciseOneTest extends BaseTest {

    @Test
    public void exerciseOneTest() {
        //1. Assert that page is opened and downloaded
        String indexWindowURL = driver.getCurrentUrl();
        softly.assertThat(indexWindowURL).isEqualTo(url);
        System.out.println(driver.getCurrentUrl());

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

        //5. Assert that menu buttons on header are displayed and have proper names
        List<WebElement> headersBtns = driver.findElements(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        Set<String> actualHeadersBtnsName = headersBtns
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
        softly.assertThat(expectedHeadersBtnsName).isEqualTo(actualHeadersBtnsName);

        //6. Assert that index page has 4 images
        List<WebElement> iconsOnIndexPage = driver.findElements(By.className("benefit-icon"));
        boolean imagesAreDisplayed = iconsOnIndexPage.stream().allMatch(WebElement::isDisplayed);
        softly.assertThat(imagesAreDisplayed).isTrue();

        //7. Assert that texts under icons have proper text
        List<WebElement> textUnderIconsElements = driver.findElements(By.className("benefit-txt"));
        Set<String> actualTextUnderIcons = textUnderIconsElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toCollection(TreeSet::new));
        softly.assertThat(actualTextUnderIcons).isEqualTo(expectedTextUnderIcons);

        //8. Assert that iframe with "Frame Button" exists
        WebElement iframeWithButton = driver.findElement(By.id("frame"));
        softly.assertThat(iframeWithButton.isEnabled()).isTrue();

        //9. Assert that "Frame Button" in frame exists
        String indexWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(iframeWithButton);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softly.assertThat(frameButton.isEnabled()).isTrue();

        //10. Assert that driver switched to original window
        driver.switchTo().window(indexWindowHandle);
        softly.assertThat(driver.getWindowHandle()).isEqualTo(indexWindowHandle);

        //11. Assert that left sidebar menu has 5 items and they have proper names
        List<WebElement> navigationSidebarElems = driver
            .findElements(By
                .cssSelector("#mCSB_1_container > ul > li"));
        Set<String> actualNavigationSidebarElemsText = navigationSidebarElems
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
        softly.assertThat(expectedNavigationSidebarText).isEqualTo(actualNavigationSidebarElemsText);

        //12. Assert that browser is closed
        driver.close();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
        softly.assertAll();
    }
}
