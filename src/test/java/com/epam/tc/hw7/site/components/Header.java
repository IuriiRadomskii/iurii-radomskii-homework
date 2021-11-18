package com.epam.tc.hw7.site.components;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.site.forms.LoginForm;
import org.openqa.selenium.WebElement;

@FindBy(className = "uui-header dark-gray")
public class Header extends Section {


    public static LoginForm loginForm;

    @Css("img#user-icon")
    public static Icon userIcon;

    @Css(".fa-sign-out")
    public static WebElement logout;

    @Css("#user-name")
    public static Text fullName;




}
