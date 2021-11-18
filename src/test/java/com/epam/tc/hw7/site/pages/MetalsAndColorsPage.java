package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.MetalsAndColorsInfo;
import com.epam.tc.hw7.site.components.page.metalsandcolors.MetalAndColorsMainSection;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends BasePage {

    public static MetalAndColorsMainSection metalAndColorsMainSection;

    public void fillData(MetalsAndColorsInfo data) {
        metalAndColorsMainSection.fill(data);
    }


}
