package com.epam.tc.hw4.data;

import java.util.List;
import java.util.Set;

public class Expected {

    public static final String homePageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String differentElementsURL = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    public static final String userNameAtPage = "ROMAN IOVLEV";
    public static final String homePageTitle = "Home Page";
    public static final String differentElementsPageTitle = "Different Elements";
    public static final Set<String> headersBtnsName = Set
        .of("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");
    public static final Set<String> textUnderIcons = Set
        .of("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "To include good practices\nand ideas from successful\nEPAM project");
    public static final Set<String> navigationSidebarText = Set
        .of("Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");
    public static final List<String> logs = List.of(
        "Colors: value changed to Yellow",
        "Colors: value changed to Blue",
        "Colors: value changed to Green",
        "metal: value changed to Selen",
        "metal: value changed to Bronze",
        "metal: value changed to Silver",
        "metal: value changed to Gold",
        "Fire: condition changed to true",
        "Wind: condition changed to true",
        "Earth: condition changed to true",
        "Water: condition changed to true"
    );

    public static final List<String> invalidLogs = List.of(
        "Colors: value changed to Red",
        "Colors: value changed to Blue",
        "Colors: value changed to Green",
        "metal: value changed to Selen",
        "metal: value changed to Bronze",
        "metal: value changed to Silver",
        "metal: value changed to Gold",
        "Fire: condition changed to true",
        "Wind: condition changed to true",
        "Earth: condition changed to true",
        "Water: condition changed to true"
    );
}
