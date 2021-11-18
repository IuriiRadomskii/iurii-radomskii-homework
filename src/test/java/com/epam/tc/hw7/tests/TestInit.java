package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface TestInit {

    @BeforeClass(alwaysRun = true)
    default void setUp() {
        initElements(JdiSite.class);
    }

    @AfterClass(alwaysRun = true)
    default void tearDown() {
        killAllSeleniumDrivers();
    }

}
