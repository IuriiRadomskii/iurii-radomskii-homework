package com.epam.tc.hw4.tests.steps;

import com.epam.tc.hw4.pages.Frame;
import com.epam.tc.hw4.pages.Index;
import com.epam.tc.hw4.pages.Login;
import com.epam.tc.hw4.tests.data.Expected;
import io.qameta.allure.Step;
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
    public void assertUserNameAtPage() {
        softly.assertThat(indexPage.getActualUserNameAtPage()).isEqualTo(Expected.userNameAtPage);
    }

    @Step("Assert that headers buttons on loginPage are displayed and have proper names")
    public void assertHeadersButtons() {
        softly.assertThat(indexPage.getHeadersBtnsName()).isEqualTo(Expected.headersBtnsName);
    }

    @Step("Assert that index page has 4 images")
    public void assertIcons() {
        softly.assertThat(indexPage.isIconsDisplayed()).isTrue();
    }

    @Step("Assert that texts under icons have proper text")
    public void assertTextUnderIcons() {
        softly.assertThat(indexPage.getActualTextUnderIcons()).isEqualTo(Expected.textUnderIcons);
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
