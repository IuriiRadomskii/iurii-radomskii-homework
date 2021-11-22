package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.components.page.metalsandcolors.MetalAndColorsMainSection;
import com.epam.tc.hw7.tests.utility.Info;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends BasePage {

    public static MetalAndColorsMainSection metalAndColorsMainSection;

    public void fillData(Info data) {
        metalAndColorsMainSection.fill(data);
    }

    public void submit() {
        metalAndColorsMainSection.submit();
    }

    @Css("ul.panel-body-list.results li")
    public WebList logs;

    public List<String> getActualLogs() {
        return logs
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
