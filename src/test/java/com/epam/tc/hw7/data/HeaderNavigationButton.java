package com.epam.tc.hw7.data;

public enum HeaderNavigationButton {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE(" Service                        "),
    METALS_AND_COLORS("Metals & Colors");

    private final String text;

    private HeaderNavigationButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
