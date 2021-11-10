package com.epam.tc.hw5.data;

import java.util.List;

public class Expected {

    public static final String indexPageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String differentElementsURL = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    public static final String userNameAtPage = "ROMAN IOVLEV";
    public static final String indexPageTitle = "Home Page";
    public static final String differentElementsPageTitle = "Different Elements";
    public static final String userTablePageTitle = "User Table";
    public static final List<String> logs = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true"
    );
}
