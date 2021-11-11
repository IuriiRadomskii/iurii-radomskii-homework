package com.epam.tc.hw5.page.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogsComponent extends BaseComponent {

    public LogsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public List<String> getActualLogs() {
        return logs.stream()
                   .map(WebElement::getText)
                   .map(StringBuilder::new)
                   .map(s -> s.delete(0, 9))
                   .map(String::new).collect(Collectors.toList());
    }
}
