package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.data.Expected;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class CommonStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void clickSearchButtonInTheHeader() {
        indexPage.login();
    }

    @When("Open Different Element page through the header dropdown menu Service")
    public void goThroughHeaderToDifferentElements() {
        indexPage.goThroughHeaderToDifferentElements();
    }

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
