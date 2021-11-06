package com.epam.tc.hw4.tests.steps;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected SoftAssertions softly;
    protected WebDriver driver;

    BaseSteps(WebDriver driver) {
        this.driver = driver;
        softly = new SoftAssertions();
    }

}
