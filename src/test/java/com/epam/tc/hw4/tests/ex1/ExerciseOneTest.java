package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.tests.BaseTest;
import com.epam.tc.hw4.data.Expected;
import com.epam.tc.hw4.steps.ExerciseOneSteps;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Feature("Home Page functions")

public class ExerciseOneTest extends BaseTest {

    private ExerciseOneSteps exOneSteps;

    @BeforeMethod
    private void setupExerciseOneSteps() {
        this.exOneSteps = new ExerciseOneSteps(driver);
    }

    @Test
    public void exerciseOneTest() {

        exOneSteps.openPage();
        exOneSteps.assertLoginPageUrl(Expected.homePageURL);
        exOneSteps.assertLoginPageTitle(Expected.homePageTitle);
        exOneSteps.login(userName, password);
        exOneSteps.assertUserLogged();
        exOneSteps.assertUserNameAtPage(Expected.userNameAtPage);
        exOneSteps.assertHeadersButtons(Expected.headersBtnsName);
        exOneSteps.assertIcons();
        exOneSteps.assertTextUnderIcons(Expected.textUnderIcons);
        exOneSteps.assertIframeWithFrameBtn();
        exOneSteps.switchToFrame();
        exOneSteps.assertFrameButtonInFrame();
        exOneSteps.switchBackToWindow();
        exOneSteps.assertLeftSideBar();
        exOneSteps.closeBrowser();
        exOneSteps.assertClosedBrowser();
        exOneSteps.assertAll();

    }
}
