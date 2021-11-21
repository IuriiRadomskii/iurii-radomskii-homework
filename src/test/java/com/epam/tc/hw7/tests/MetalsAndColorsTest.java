package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.entities.User.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiSite.homePage;
import static com.epam.tc.hw7.site.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.components.Header.loginForm;
import static com.epam.tc.hw7.site.components.Header.userIcon;

import com.epam.tc.hw7.data.HeaderNavigationButton;
import com.epam.tc.hw7.entities.MetalsAndColorsInfo;
import org.testng.annotations.Test;



public class MetalsAndColorsTest implements TestInit {

    /*@AfterMethod
    public void logout() {
        HomePage.logout();
    }*/

    @Test
    public void loginTest() {
        homePage.open();
        homePage.checkOpened();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.selectInHeader(HeaderNavigationButton.METALS_AND_COLORS);
        metalsAndColorsPage.shouldBeOpened();
        metalsAndColorsPage.fillData(MetalsAndColorsInfo.TEST_DATA);
        metalsAndColorsPage.submit();
    }
}
