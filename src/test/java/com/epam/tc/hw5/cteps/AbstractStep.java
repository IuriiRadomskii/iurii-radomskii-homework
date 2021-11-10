package com.epam.tc.hw5.cteps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.IndexPage;
import com.epam.tc.hw5.page.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected IndexPage indexPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver");
        indexPage = new IndexPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }

}
