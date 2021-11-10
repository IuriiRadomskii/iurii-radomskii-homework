package com.epam.tc.hw5.data;

import java.util.List;
import java.util.Set;

public class Expected {

    public static final String indexPageURL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String differentElementsURL = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    public static final String userNameAtPage = "ROMAN IOVLEV";
    public static final String homePageTitle = "Home Page";
    public static final String differentElementsPageTitle = "Different Elements";
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
}
