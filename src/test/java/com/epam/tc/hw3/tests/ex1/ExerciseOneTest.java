package com.epam.tc.hw3.tests.ex1;

import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.tests.BaseTest;
import org.testng.annotations.BeforeMethod;

public class ExerciseOneTest extends BaseTest {

    private IndexPage indexPage;

    @BeforeMethod
    public void navigateToIndexPage() {
        indexPage = new IndexPage(driver);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void exerciseOneTest() {

        String currentUrl = indexPage.getCurrentURL();
        softly.assertThat(currentUrl).isEqualTo(indexPage.url);

        String currentTitle = indexPage.getTitle();
        softly.assertThat(currentTitle).isEqualTo(indexPage.title);


    }
}
