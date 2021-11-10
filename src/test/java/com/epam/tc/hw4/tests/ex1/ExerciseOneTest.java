package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.data.Expected;
import com.epam.tc.hw4.steps.ExerciseOneSteps;
import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature("Home page functions")
@Story("Check login, icons, frame")
public class ExerciseOneTest extends BaseTest {

    @Test
    public void exerciseOneTest() {

        ExerciseOneSteps exOneSteps = new ExerciseOneSteps(driver);
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
        exOneSteps.assertAll();

    }
}
