package com.epam.tc.hw3.tests.ex2;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.tests.BaseTest;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test
    public void exerciseTwoTest() {

        //1. Assert that page is opened and downloaded
        indexPage.openPage();
        softly.assertThat(indexPage.getCurrentURL()).isEqualTo(url);

        //2. Assert that page title is 'Home Page'
        softly.assertThat(indexPage.getActualPageTitle()).isEqualTo(indexPage.title);

        //3. Assert that user is logged by given username and password
        indexPage.login(userName, password);
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();

        //4. Assert that user name is displayed and equals to expected result
        softly.assertThat(indexPage.getUserNameText().getText()).isEqualTo(expectedUserNameAtPage);

        //5. Assert that Different Elements page is opened
        DifferentElementsPage diffPage = indexPage.goToDiffElemsPage();
        softly.assertThat("Different Elements").isEqualTo(diffPage.getTitle());

        //6. Assert that Water and Wind checkboxes are selected
        diffPage
            .clickElement(diffPage.getWaterCheckBox())
            .clickElement(diffPage.getWindCheckBox());
        softly.assertThat(diffPage.getWaterCheckBox().isSelected()).isTrue();
        softly.assertThat(diffPage.getWindCheckBox().isSelected()).isTrue();

        //7. Assert that 'Selen' radio is checked
        diffPage.clickElement(diffPage.getSelenRadio());
        softly.assertThat(diffPage.getSelenRadio().isSelected()).isTrue();

        //8. Assert that yellow option in dropdown menu is selected
        diffPage.clickElement(diffPage.getYellowOption());
        softly.assertThat(diffPage.getSelenRadio().isSelected()).isTrue();

        //9. Assert that there is a separate log entry for each checkbox, radio button, and color option
        // corresponding to their status.
        diffPage
            .refresh()
            .clickInARow(diffPage.getCheckBoxRow())
            .clickInARow(diffPage.getRadioBoxRow())
            .clickInARow(diffPage.getColorOptions());
        softly.assertThat(diffPage.getActualLogs()).isEqualTo(expectedLogs);

        //10. Assert that browser is closed
        indexPage.closeBrowser();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
        softly.assertAll();

    }
}
