
package com.epam.tc.hw5.page;

import com.epam.tc.hw5.data.Expected;
import com.epam.tc.hw5.data.PropertyInit;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    private String username;
    private String password;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.handle = getWindowHandle();
        this.username = PropertyInit.getProperty("username");
        this.password = PropertyInit.getProperty("password");
    }

    public void open() {
        driver.navigate().to(Expected.indexPageURL);
    }


    public void login() {
        header
            .clickLoginToggle()
            .inputUserName(username)
            .inputPassword(password)
            .clickLoginBtn();
    }

    public void goThroughHeaderToDifferentElements() {
        header
            .clickServiceToggle()
            .clickDifferentElementsBtn();
    }

}
