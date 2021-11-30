package com.epam.tc.hw7.site.components.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.WebElement;

@FindBy(id = "summary-block")
public class Summary extends Section {

    @UI("#even-selector p")
    private List<WebElement> even;
    @UI("#odds-selector p")
    private List<WebElement> odd;
    @FindBy(id = "calculate-button")
    private Button calculateBtn;

    public Summary() {
    }

    public void select(List<String> toSelect) {
        for (String number : toSelect) {
            int intNumber = Integer.parseInt(number);
            Optional<WebElement> option;
            if (intNumber % 2 == 0) {
                option = even.stream()
                             .filter(element -> element.getText().equals(number))
                             .findFirst();
            } else {
                option = odd.stream()
                            .filter(element -> element.getText().equals(number))
                            .findFirst();
            }
            option.ifPresent(WebElement::click);
        }
        calculateBtn.click();
    }
}
