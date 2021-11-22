package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.enums.HeaderNavigationButtons;
import com.epam.tc.hw7.site.components.Header;

public class BasePage extends WebPage {

    public static Header header;

    public static void logout() {
        header.logout.click();
    }

    public String getFullUserName() {
        return header.fullName.getText();
    }

    public void selectInHeader(HeaderNavigationButtons value) {
        header.select(value);
    }

    public void refreshPage() {
        driver().navigate().refresh();
    }




}
