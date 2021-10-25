package com.epam.tc.hw2;

import java.util.Set;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BaseTest {


    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String userName = "Roman";
    protected final String pass = "Jdi1234";
    protected final String expectedUserNameAtPage = "ROMAN IOVLEV";
    protected final Set<String> expectedHeadersBtnsName = Set
        .of("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");
    protected final Set<String> expectedTextUnderIcons = Set
        .of("To be flexible and\ncustomizable",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…",
            "To be multiplatform",
            "To include good practices\nand ideas from successful\nEPAM project");
    protected final Set<String> expectedNavigationSidebarText = Set
        .of("Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");


}
