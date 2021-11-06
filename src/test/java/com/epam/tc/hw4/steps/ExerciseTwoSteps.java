package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElements;
import com.epam.tc.hw4.pages.Login;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

public class ExerciseTwoSteps extends BaseSteps {

    private DifferentElements differentElements;

    public ExerciseTwoSteps(WebDriver driver) {
        super(driver);
        this.loginPage = new Login(driver);
    }

    @Step("Assert that user is logged")
    public void assertUserLogged() {
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();
    }

    @Step("Go to Different Elements page")
    public void goToDifferentElementPage() {
        differentElements = indexPage.goToDiffElemsPage();
    }

    @Step("Assert that Different Elements page is opened")
    public void assertDifferentElementsIsOpened(String expectedDifferentElementsPageTitle) {
        softly.assertThat(differentElements.getTitle()).isEqualTo(expectedDifferentElementsPageTitle);
    }

    @Step("Click Water and Wind checkboxes")
    public void clickWaterAndWindCheckBoxes() {
        differentElements
            .clickElement(differentElements.getWaterCheckBox())
            .clickElement(differentElements.getWindCheckBox());
    }

    @Step("Assert that Water and Wind checkboxes are selected")
    public void assertWaterAndWindCheckBoxesSelected() {
        softly.assertThat(differentElements.getWaterCheckBox().isSelected()).isTrue();
        softly.assertThat(differentElements.getWindCheckBox().isSelected()).isTrue();
    }

    @Step("Click Selen radiobox")
    public void clickSelenRadioBox() {
        differentElements.clickElement(differentElements.getSelenRadio());
    }

    @Step("Assert that Selen radiobox is selected")
    public void assertSelenRadioBoxIsSelected() {
        softly.assertThat(differentElements.getSelenRadio().isSelected()).isTrue();
    }

    @Step("Click Yellow option")
    public void clickYellow() {
        differentElements.clickElement(differentElements.getYellowOption());
    }

    @Step("Assert that Selen radiobox is selected")
    public void assertYellow() {
        softly.assertThat(differentElements.getSelenRadio().isSelected()).isTrue();
    }

    @Step("Refresh page")
    public void refreshPage() {
        differentElements.refresh();
    }

    @Step("Click all")
    public void clickAll() {
        differentElements
            .clickInARow(differentElements.getCheckBoxRow())
            .clickInARow(differentElements.getRadioBoxRow())
            .clickInARow(differentElements.getColorOptions());
    }

    @Step("Assert logs")
    public void assertLogs(List<String> expectedLogs) {
        softly.assertThat(differentElements.getActualLogs()).isEqualTo(expectedLogs);
    }

    @Step("Close browser")
    public void closeBrowser() {
        driver.close();
    }

    @Step("Assert that browser is closed")
    public void assertClosedBrowser() {
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
    }

    @Step("Assert all")
    public void assertAll() {
        softly.assertAll();
    }
}
