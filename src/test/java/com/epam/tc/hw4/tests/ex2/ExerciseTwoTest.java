package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.tests.BaseTest;
import com.epam.tc.hw4.tests.steps.ExerciseTwoSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    private ExerciseTwoSteps exTwoSteps;

    @BeforeMethod
    private void setupExerciseOneSteps() {
        this.exTwoSteps = new ExerciseTwoSteps(driver);
    }

    @Test
    public void exerciseTwoTest() {

        exTwoSteps.openPage();
        exTwoSteps.assertLoginPageUrl();
        exTwoSteps.assertLoginPageTitle();
        exTwoSteps.login(userName, password);
        exTwoSteps.goToDifferentElementPage();
        exTwoSteps.assertDifferentElementsIsOpened();
        exTwoSteps.clickWaterAndWindCheckBoxes();
        exTwoSteps.clickSelenRadioBox();
        exTwoSteps.clickYellow();
        exTwoSteps.assertWaterAndWindCheckBoxesSelected();
        exTwoSteps.assertSelenRadioBoxIsSelected();
        exTwoSteps.assertYellow();
        exTwoSteps.refreshPage();
        exTwoSteps.clickAll();
        exTwoSteps.assertLogs();
        exTwoSteps.closeBrowser();
        exTwoSteps.assertClosedBrowser();
        exTwoSteps.assertAll();

    }
}
