package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.data.Expected;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
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

    /*| Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulksome description             |*/

    @And("User table should contain following values:")
    public void checkValuesInTable(DataTable table) {

        List<List<String>> rows = table.asLists(String.class);

    }


}

