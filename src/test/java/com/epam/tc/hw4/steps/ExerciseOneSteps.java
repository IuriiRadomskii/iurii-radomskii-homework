package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.data.Expected;
import com.epam.tc.hw4.pages.Frame;
import com.epam.tc.hw4.pages.Index;
import com.epam.tc.hw4.pages.Login;
import io.qameta.allure.Step;
import java.util.Set;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

public class ExerciseOneSteps extends BaseSteps {

    private Frame frame;

    public ExerciseOneSteps(WebDriver driver) {
        super(driver);
        this.loginPage = new Login(driver);
    }

    @Step("Assert that user is logged")
    public void assertUserLogged() {
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();
    }

    @Step("Assert that user name is displayed and equals to expected result")
    public void assertUserNameAtPage(String expectedUserNameAtPage) {
        softly.assertThat(indexPage.getActualUserNameAtPage()).isEqualTo(expectedUserNameAtPage);
    }

    @Step("Assert that headers buttons on loginPage are displayed and have proper names")
    public void assertHeadersButtons(Set<String> expectedHeadersBtnsName) {
        softly.assertThat(indexPage.getHeadersBtnsName()).isEqualTo(expectedHeadersBtnsName);
    }

    @Step("Assert that index page has 4 images")
    public void assertIcons() {
        softly.assertThat(indexPage.isIconsDisplayed()).isTrue();
    }

    @Step("Assert that texts under icons have proper text")
    public void assertTextUnderIcons(Set<String> expectedTextUnderIcons) {
        softly.assertThat(indexPage.getActualTextUnderIcons()).isEqualTo(expectedTextUnderIcons);
    }

    @Step("Assert that iframe with 'Frame Button' exists")
    public void assertIframeWithFrameBtn() {
        softly.assertThat(indexPage.getIframe().isEnabled()).isTrue();
    }

    @Step("Switch to frame with 'Frame Button'")
    public void switchToFrame() {
        this.frame = indexPage.switchToFrame(indexPage.getIframe());
    }

    @Step("Assert 'Frame Button' in frame")
    public void assertFrameButtonInFrame() {
        softly.assertThat(frame.getFrameButton().isEnabled()).isTrue();
    }

    @Step("Switch back to window")
    public void switchBackToWindow() {
        indexPage = (Index) frame.switchBackTo();
    }

    @Step("Assert that left sidebar menu has 5 items and they have proper names")
    public void assertLeftSideBar() {
        softly.assertThat(indexPage.getActualNavigationSidebarText()).isEqualTo(Expected.navigationSidebarText);
    }


}
