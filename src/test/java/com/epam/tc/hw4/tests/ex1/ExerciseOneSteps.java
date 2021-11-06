package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.pages.Index;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class ExerciseOneSteps {

    private SoftAssertions softly;
    private Index indexPage;
    private WebDriver driver;

    ExerciseOneSteps(WebDriver driver) {
        this.driver = driver;

    }

}
