package com.epam.tc.hw6.tests.ex2;

import com.epam.tc.hw6.data.Expected;
import com.epam.tc.hw6.steps.ExerciseTwoSteps;
import com.epam.tc.hw6.tests.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
        exTwoSteps.assertAll();

    }
}
