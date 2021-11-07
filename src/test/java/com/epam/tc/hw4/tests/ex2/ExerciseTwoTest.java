package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.data.Expected;
import com.epam.tc.hw4.steps.ExerciseOneSteps;
import com.epam.tc.hw4.steps.ExerciseTwoSteps;
import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Different Elements page functions")
@Story("Check checkboxes")
public class ExerciseTwoTest extends BaseTest {

    @Test
    public void exerciseTwoTest() {

        ExerciseTwoSteps exTwoSteps = new ExerciseTwoSteps(driver);
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
        exTwoSteps.assertLogs(Expected.logs);
        exTwoSteps.closeBrowser();
        exTwoSteps.assertClosedBrowser();
        exTwoSteps.assertAll();

    }
}
