package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.data.Expected;
import com.epam.tc.hw4.steps.ExerciseTwoSteps;
import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different Elements page functions")
@Story("Check logs")
public class ExerciseTwoTestWithInvalidLogs extends BaseTest {

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
        exTwoSteps.assertLogs(Expected.invalidLogs);
        exTwoSteps.assertAll();

    }
}
