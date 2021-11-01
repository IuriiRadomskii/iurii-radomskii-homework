package com.epam.tc.hw3.tests.ex2;

import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.tests.BaseTest;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @BeforeMethod
    public void navigateToIndexPage() {
        indexPage = new IndexPage(driver);
        setUserName();
        setPassword();
        setExpectedUserNameAtPage();
    }

    @AfterMethod
    public void assertAll() {
        softly.assertAll();
    }

    @Test
    public void exerciseTwoTest() {

        //1. Assert that page is opened and downloaded
        indexPage.openPage();
        softly.assertThat(indexPage.getURL()).isEqualTo(url);

        //2. Assert that page title is 'Home Page'
        softly.assertThat(indexPage.getActualPageTitle()).isEqualTo(indexPage.title);

        //3. Assert that user is logged by given username and password
        indexPage.login(userName, password);
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();

        //4. Assert that user name is displayed and equals to expected result
        softly.assertThat(indexPage.getUserNameText().getText()).isEqualTo(expectedUserNameAtPage);

        //5. Assert that Different Elements page is opened
        List<WebElement> leftSidebarServiceBtn = new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver -> driver
                .findElements(By
                    .xpath("//ul[@class='sidebar-menu left']/li")));
        leftSidebarServiceBtn.stream().map(WebElement::getText).forEach(System.out::println);


    }
}
