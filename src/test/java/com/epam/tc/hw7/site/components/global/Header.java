package com.epam.tc.hw7.site.components.global;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.data.HeaderNavigationButton;
import com.epam.tc.hw7.site.components.page.homepage.LoginForm;
import org.openqa.selenium.WebElement;

@FindBy(className = "uui-header dark-gray")
public class Header extends Section {


    public static LoginForm loginForm;

    @UI("ul.uui-navigation.nav.navbar-nav.m-l8 li a")
    public Menu headerMenu;

    @Css("img#user-icon")
    public static Icon userIcon;

    @Css(".fa-sign-out")
    public static WebElement logout;

    @Css("#user-name")
    public static Text fullName;

    public void select(HeaderNavigationButton value) {
        headerMenu.select(value.getText());
    }



}
