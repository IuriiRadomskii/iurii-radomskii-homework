package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.IndexPage;
import com.epam.tc.hw5.page.UserTablePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected SoftAssertions softly;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver");
        indexPage = new IndexPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        softly = new SoftAssertions();
    }
}
