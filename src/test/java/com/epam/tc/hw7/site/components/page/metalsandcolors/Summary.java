package com.epam.tc.hw7.site.components.page.metalsandcolors;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

@FindBy(id = "summary-block")
public class Summary extends Section {

    @UI("#even-selector p")
    private List<WebElement> even;
    @UI("#odds-selector p")
    private List<WebElement> odd;
    @FindBy(id = "calculate-button")
    private Button calculateBtn;

    public void select(int[] toSelect) {
        for (int number : toSelect) {
            String stringNumber = String.valueOf(number);
            Optional<WebElement> option;
            if (number % 2 == 0) {
                option = even.stream()
                             .filter(element -> element.getText().equals(stringNumber))
                             .findFirst();
            } else {
                option = odd.stream()
                            .filter(element -> element.getText().equals(stringNumber))
                            .findFirst();
            }
            if (option.isPresent()) {
                option.get().click();
            }
        }
        calculateBtn.click();
    }


}
