package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.data.Expected;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class UserTableStep extends AbstractStep {

    @Then("\"User Table\" page should be opened")
    public void assertLogs() {
        softly.assertThat(userTablePage.getTitle()).isEqualTo(Expected.userTablePageTitle);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void countDropdowns(int num) {
        softly.assertThat(userTablePage.countDropDownNumber()).isEqualTo(num);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void countUsernames(int num) {
        softly.assertThat(userTablePage.countUserNamesNumber()).isEqualTo(num);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void countDescriptions(int num) {
        softly.assertThat(userTablePage.countDescriptionsNumber()).isEqualTo(num);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void countCheckboxes(int num) {
        softly.assertThat(userTablePage.countCheckboxesNumber()).isEqualTo(num);
    }


}

