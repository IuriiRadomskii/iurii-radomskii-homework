package com.epam.tc.hw7.site.components.page.metalsandcolors;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MetalsAndColorsInfo;

@Css(".form")
public class MetalAndColorsMainSection extends Form<MetalsAndColorsInfo> {

    public Summary summary;


    public Checklist elements;

    @UI("#submit-button")
    public Button submit;

    @JDropdown(root = "#colors", value = "div > button", list = "li", expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option.pull-left", list = "li", expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables", value = ".filter-option.pull-left",
               expand = ".caret", list = "label")
    public Dropdown vegetables;



}
