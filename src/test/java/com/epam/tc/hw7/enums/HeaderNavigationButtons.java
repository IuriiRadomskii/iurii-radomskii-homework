package com.epam.tc.hw7.enums;

public enum HeaderNavigationButtons {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE(" Service                        "),
    METALS_AND_COLORS("Metals & Colors");

    private final String text;

    private HeaderNavigationButtons(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
