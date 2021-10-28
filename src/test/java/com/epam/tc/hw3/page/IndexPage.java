package com.epam.tc.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private WebDriver driver;
    private final String indexURL = "https://jdi-testing.github.io/jdi-light/index.html";

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
