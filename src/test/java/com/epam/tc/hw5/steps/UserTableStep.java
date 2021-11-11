package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.data.Expected;
import com.epam.tc.hw5.util.Util;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.stream.Collectors;

public class UserTableStep extends AbstractStep {

    @Then("\"User Table\" page should be opened")
    public void assertTitle() {
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
    public void assertValuesInTable(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        rows = Util.removeTableHeaderFrom(rows);
        for (int i = 0; i < rows.size(); i++) {
            List<String> expectedRow = Util.collectRow(i + 1,
                userTablePage.getTablesUsernamesTexts(),
                userTablePage.getTablesDescriptionsTexts());
            softly.assertThat(expectedRow).isEqualTo(rows.get(i));
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDropDownMenusTexts(List<String> rows) {
        rows = Util.removeTableHeaderFrom(rows);
        for (int i = 0; i < rows.size(); i++) {
            softly.assertThat(userTablePage
                .getTablesDropdownMenusTexts().get(i))
                  .isEqualTo(rows.get(i));
        }
        softly.assertAll();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void clickVipCheckbox() {
        userTablePage.clickVipCheckBox();
    }

    @When("{int} log row has \"Vip: condition changed to true\" text in log section")
    public void assertLogs(int num) {
        String expectedLog = "Vip: condition changed to true";
        List<String> actualLogs = userTablePage.getActualLogs();
        List<String> tmp = actualLogs.stream()
                                     .filter(s -> s.equals(expectedLog))
                                     .collect(Collectors.toList());
        softly.assertThat(tmp.size()).isEqualTo(num);
        softly.assertAll();
    }
}

