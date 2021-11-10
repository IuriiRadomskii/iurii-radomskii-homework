
package com.epam.tc.hw5.page;

import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']//li[@index=3]")
    private WebElement serviceBtn;

    @FindBy(xpath = "//ul[@class='sub']/li[@index=8]")
    private WebElement differentElementsBtn;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.handle = getWindowHandle();
    }

    public Set<String> getHeadersBtnsName() {
        return headersBtns
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
    }

    public String getActualUserNameAtPage() {
        return userNameText.getText();
    }

    public WebElement getUserNameText() {
        return userNameText;
    }

    public DifferentElementsPage goToDiffElemsPage() {
        serviceBtn.click();
        differentElementsBtn.click();
        return new DifferentElementsPage(driver);
    }

}
