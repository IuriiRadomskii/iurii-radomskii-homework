package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.data.Info;
import com.epam.tc.hw7.site.components.pages.metalsandcolors.MetalAndColorForm;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends BasePage {

    public static MetalAndColorForm metalAndColorForm;

    public void fillData(Info data) {
        metalAndColorForm.fill(data);
    }

    public void submit() {
        metalAndColorForm.submit();
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
