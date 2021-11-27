package com.epam.tc.hw7.site.components.pages.metalsandcolors;


import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.data.Info;
import java.util.List;
import org.openqa.selenium.WebElement;

@Css(".form")
public class MetalAndColorsMainSection extends Section {

    public Summary summary;

    //@Css(".vertical-group .checkbox") public List<WebElement> elements;
    @Css(".vertical-group .checkbox") public List<WebElement> elements;

    @UI("#submit-button") public Button submit;

    @JDropdown(root = "#colors", value = "div > button", list = "li", expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option.pull-left", list = "li", expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables", value = "#salad-dropdown > button",
               expand = ".caret", list = "label")
    public Dropdown vegetables;

    public void submit() {
        submit.click();
    }

    public void fill(Info data) {
        selectSummary(data.getSummary());
        selectElements(data.getElements());
        selectColors(data.getColor());
        selectMetals(data.getMetals());
        selectVegetables(data.getVegetables());
    }

    private void selectVegetables(List<String> vegetable) {
        vegetables.expand();
        vegetables.select(vegetables.selected());
        for (String veg : vegetable) {
            vegetables.select(veg);
        }
    }

    private void selectSummary(List<String> radioToClick) {
        summary.select(radioToClick);
    }

    private void selectElements(List<String> elementsToClick) {
        for (WebElement element : elements) {
            for (byte j = 0; j < elementsToClick.size(); j++) {
                if (element.getText().equalsIgnoreCase(elementsToClick.get(j))) {
                    element.click();
                }
            }
        }
    }

    private void selectElements() {

    }

    private void selectColors(String color) {
        colors.select(color);
    }

    private void selectMetals(String metal) {
        metals.select(metal);
    }

}
