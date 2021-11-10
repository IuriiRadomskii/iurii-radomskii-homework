package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.data.Expected;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

;

public class DifferentPageStep extends AbstractStep {

    @And("Select 'Water' and 'Wind' checkboxes")
    public void selectWaterAndWindCheckboxes() {
        differentElementsPage
            .clickElement(differentElementsPage.getWaterCheckBox())
            .clickElement(differentElementsPage.getWindCheckBox());
    }

    @And("Select 'Selen' radio button")
    public void selectSelenRadio() {
        differentElementsPage
            .clickElement(differentElementsPage.getSelenRadio());
    }

    @And("Select 'Yellow' in dropdown menu")
    public void selectYellowOption() {
        differentElementsPage
            .clickElement(differentElementsPage.getYellowOption());
    }

    @Then("Log has proper entries")
    public void assertLogs() {
        Assertions.assertThat(differentElementsPage.getActualLogs()).isEqualTo(Expected.logs);
    }

}
