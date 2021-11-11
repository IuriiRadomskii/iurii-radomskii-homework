package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.pages.Index;
import com.epam.tc.hw6.pages.Login;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected SoftAssertions softly;
    protected WebDriver driver;
    protected Login loginPage;
    protected Index indexPage;

    BaseSteps(WebDriver driver) {
        this.driver = driver;
        softly = new SoftAssertions();
    }


    @Step("Assert that Index Page is opened")
    public void assertLoginPageUrl(String expectedHomePageUrl) {
        softly.assertThat(loginPage.getCurrentURL()).isEqualTo(expectedHomePageUrl);
    }

    @Step("Assert Index Page title")
    public void assertLoginPageTitle(String expectedHomePageTitle) {
        softly.assertThat(loginPage.getTitle()).isEqualTo(expectedHomePageTitle);
    }

    @Step("Login. Username: {username}, password: {password}")
    public void login(String username, String password) {
        indexPage = loginPage.login(username, password);
    }

    @Step("Assert all")
    public void assertAll() {
        softly.assertAll();
    }

}
