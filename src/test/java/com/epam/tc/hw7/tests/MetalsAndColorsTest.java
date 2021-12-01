package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.entities.User.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiSite.homePage;
import static com.epam.tc.hw7.site.JdiSite.metalsAndColorsPage;

import com.epam.tc.hw7.data.Info;
import com.epam.tc.hw7.data.JsonParser;
import com.epam.tc.hw7.enums.HeaderNavigationButtons;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MetalsAndColorsTest implements TestInit {

    @DataProvider
    public Object[][] getTestData() {
        return JsonParser.getTestData();
    }

    @Test
    public void loginTest() {
        homePage.login(DEFAULT_USER);
        Assertions.assertThat(homePage.getFullUserName()).isEqualToIgnoringCase(DEFAULT_USER.getFullName());
    }

    @Test(dataProvider = "getTestData")
    public void testMetalsAndColors(Info info) {
        homePage.selectInHeader(HeaderNavigationButtons.METALS_AND_COLORS);
        metalsAndColorsPage.shouldBeOpened();
        metalsAndColorsPage.fillData(info);
        metalsAndColorsPage.submit();
        Assertions.assertThat(info.getExpectedLogs()).isEqualTo(metalsAndColorsPage.getActualLogs());
        metalsAndColorsPage.refreshPage();
    }
}
