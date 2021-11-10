package com.epam.tc.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class IndexPageStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void clickSearchButtonInTheHeader() {
        indexPage.login();
    }

    @When("I click on \"Service\" button in Header")
    public void clickServiceToggle() {
        indexPage.clickServiceToggle();
    }

    @And("I click on \"Different Elements\" button in Service dropdown")
    public void clickDifferentElementsBtn() {
        indexPage.clickDifferentElementsBtn();
    }
}
