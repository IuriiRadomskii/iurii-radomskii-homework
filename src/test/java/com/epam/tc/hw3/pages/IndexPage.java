
package com.epam.tc.hw3.pages;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    public final String title = "Home Page";

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> headersBtns;

    @FindBy(className = "benefit-icon")
    private List<WebElement> iconsOnIndexPage;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIconsElements;

    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> navigationSidebarElems;

    @FindBy(id = "frame")
    private WebElement iframe;

    public WebElement getIframe() {
        return iframe;
    }

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getActualPageTitle() {
        return driver.getTitle();
    }

    public Set<String> getHeadersBtnsText() {
        return headersBtns
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
    }

    public boolean isIconsDisplayed() {
        return iconsOnIndexPage
            .stream()
            .allMatch(WebElement::isDisplayed);
    }

    public Set<String> getActualTextUnderIcons() {
        return textUnderIconsElements
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toCollection(TreeSet::new));
    }

    public Frame switchTo(WebElement frame) {
        driver.switchTo().frame(frame);
        return new Frame(driver);
    }

    public Set<String> getActualNavigationSidebarText() {
        return navigationSidebarElems
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toSet());
    }

}
