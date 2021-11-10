package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.UserTableComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends BasePage {

    private UserTableComponent table;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public int countDropDownNumber() {
        return table.getDropdownMenus().size();
    }

    public int countUserNamesNumber() {
        return table.getUsernames().size();
    }

    public int countDescriptionsNumber() {
        return table.getDescriptions().size();
    }

    public int countCheckboxesNumber() {
        return table.getCheckBoxes().size();
    }



}
