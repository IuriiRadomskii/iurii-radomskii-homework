package com.epam.tc.hw7.site.components.page.metalsandcolors;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalsAndColorsInfo;

@Css(".form")
public class MetalAndColorsMainSection extends Section {

    @FindBy(xpath = "//p[@class='radio']") public RadioButtons summary;

    @UI("p.checkbox") public Checklist elements;

    @UI("#submit-button") public Button submit;

    @JDropdown(root = "#colors", value = "div > button", list = "li", expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option.pull-left", list = "li", expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables", value = ".filter-option.pull-left",
               expand = ".caret", list = "label")
    public Dropdown vegetables;

    public void fill(MetalsAndColorsInfo data) {
        fillElements(data.getElements());
        fillColors(data.getColors());
        fillMetals(data.getMetals());
        fillVegetables(data.getVegetables());
        fillSummary(data.getSummary());
    }

    private void fillSummary(int[] radioToClick) {
        summary.select(radioToClick);
    }

    private void fillElements(String[] elementsToClick) {
        elements.checkAll();
        //TODO
    }

    private void fillColors(String color) {
        colors.select(color);
    }

    private void fillMetals(String metal) {
        metals.select(metal);
    }

    private void fillVegetables(String[] vegetable) {
        vegetables.select(vegetable);
    }

}
