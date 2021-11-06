package com.epam.tc.hw4.tests.steps;

import com.epam.tc.hw4.pages.DifferentElements;
import com.epam.tc.hw4.pages.Index;
import com.epam.tc.hw4.pages.Login;
import com.epam.tc.hw4.tests.data.Expected;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

public class ExerciseTwoSteps extends BaseSteps {

    private DifferentElements differentElements;

    public ExerciseTwoSteps(WebDriver driver) {
        super(driver);
        this.loginPage = new Login(driver);
    }

    @Step("Assert that user is logged")
    public void assertUserLogged() {
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();
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

}
