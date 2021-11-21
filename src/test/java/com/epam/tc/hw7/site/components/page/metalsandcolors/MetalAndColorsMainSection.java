package com.epam.tc.hw7.site.components.page.metalsandcolors;


import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MetalsAndColorsInfo;
import java.util.List;
import org.openqa.selenium.WebElement;

@Css(".form")
public class MetalAndColorsMainSection extends Section {

    public Summary summary;

    @Css(".vertical-group .checkbox") public List<WebElement> elements;

    @UI("#submit-button") public Button submit;

    @JDropdown(root = "#colors", value = "div > button", list = "li", expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option.pull-left", list = "li", expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables", value = ".filter-option.pull-left",
               expand = ".caret", list = "label")
    public Dropdown vegetables;

    public void submit() {
        submit.click();
    }

    public void fill(MetalsAndColorsInfo data) {
        selectVegetables(data.getVegetables());
        selectSummary(data.getSummary());
        selectElements(data.getElements());
        selectColors(data.getColors());
        selectMetals(data.getMetals());
    }

    private void selectVegetables(String[] vegetable) {
        vegetables.expand();
        vegetables.select("Vegetables");
        vegetables.select(vegetable);

    }

    private void selectSummary(int[] radioToClick) {
        summary.select(radioToClick);
    }

    private void selectElements(String[] elementsToClick) {
        for (WebElement element : elements) {
            for (byte j = 0; j < elementsToClick.length; j++) {
                if (element.getText().equalsIgnoreCase(elementsToClick[j])) {
                    element.click();
                }
            }
        }
    }

    private void selectColors(String color) {
        colors.select(color);
    }

    private void selectMetals(String metal) {
        metals.select(metal);
    }

}
