package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.page.IndexPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class ExerciseOneTest extends BaseTest {

    private IndexPage indexPage;

    @BeforeMethod
    public void navigateToIndexPage() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void exerciseOneTest() {
        String actualUrl = indexPage.getActualUrl;
        softly.assertThat(actualUrl).isEqualTo(getExpectedUrl);
    }

}
