package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.tests.BaseTest;
import com.epam.tc.hw4.tests.steps.ExerciseOneSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    private ExerciseOneSteps exOneSteps;

    @BeforeMethod
    private void setupExerciseOneSteps() {
        this.exOneSteps = new ExerciseOneSteps(driver);
    }

    @Test
    public void exerciseOneTest() {

        exOneSteps.openPage();
        exOneSteps.assertLoginPageUrl();
        exOneSteps.assertLoginPageTitle();
        exOneSteps.login(userName, password);
        exOneSteps.assertUserLogged();
        exOneSteps.assertUserNameAtPage();
        exOneSteps.assertHeadersButtons();
        exOneSteps.assertIcons();
        exOneSteps.assertTextUnderIcons();
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
