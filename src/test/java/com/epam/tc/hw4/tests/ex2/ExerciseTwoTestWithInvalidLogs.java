package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.tests.BaseTest;
import com.epam.tc.hw4.tests.data.Expected;
import com.epam.tc.hw4.tests.data.PropertyInit;
import com.epam.tc.hw4.tests.steps.ExerciseTwoSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseTwoTestWithInvalidLogs extends BaseTest {

    private ExerciseTwoSteps exTwoSteps;

    @BeforeMethod
    private void setupExerciseOneSteps() {
        this.exTwoSteps = new ExerciseTwoSteps(driver);
        userName = PropertyInit.getProperty("username");
        password = PropertyInit.getProperty("password");
    }

    @Test
    public void exerciseTwoTest() {

        exTwoSteps.openPage();
        exTwoSteps.assertLoginPageUrl(Expected.homePageURL);
        exTwoSteps.assertLoginPageTitle(Expected.homePageTitle);
        exTwoSteps.login(userName, password);
        exTwoSteps.goToDifferentElementPage();
        exTwoSteps.assertDifferentElementsIsOpened(Expected.differentElementsPageTitle);
        exTwoSteps.clickWaterAndWindCheckBoxes();
        exTwoSteps.clickSelenRadioBox();
        exTwoSteps.clickYellow();
        exTwoSteps.assertWaterAndWindCheckBoxesSelected();
        exTwoSteps.assertSelenRadioBoxIsSelected();
        exTwoSteps.assertYellow();
        exTwoSteps.refreshPage();
        exTwoSteps.clickAll();
        exTwoSteps.assertLogs(Expected.invalidLogs);
        exTwoSteps.closeBrowser();
        exTwoSteps.assertClosedBrowser();
        exTwoSteps.assertAll();

    }
}
