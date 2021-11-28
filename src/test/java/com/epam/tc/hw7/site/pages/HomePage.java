package com.epam.tc.hw7.site.pages;

import static com.epam.tc.hw7.entities.User.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiSite.homePage;
import static com.epam.tc.hw7.site.components.Header.loginForm;
import static com.epam.tc.hw7.site.components.Header.userIcon;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.User;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends BasePage {

    public void login(User user) {
        homePage.open();
        homePage.checkOpened();
        userIcon.click();
        loginForm.loginAs(user);
    }
}
