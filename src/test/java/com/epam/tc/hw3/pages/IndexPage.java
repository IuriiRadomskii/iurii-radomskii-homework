package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {

    public final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    public final String title = "Home Page";

    public IndexPage(WebDriver driver) {
        super(driver);
    }


}
