package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.UserTableComponent;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends BasePage {

    private UserTableComponent table;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public int countDropDownNumber() {
        return 0;
    }

    public int countUserNamesNumber() {
        return 0;
    }

    public int countDescriptionsNumber() {
        return 0;
    }

    public int countCheckboxesNumber() {
        return 0;
    }



}
