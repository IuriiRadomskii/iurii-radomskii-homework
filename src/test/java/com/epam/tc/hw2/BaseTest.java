package com.epam.tc.hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String expectedUserNameAtPage = "ROMAN IOVLEV";
    protected final Set<String> expectedHeadersBtnsName = Set
        .of("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");
    protected final Set<String> expectedTextUnderIcons = Set
        .of("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "To include good practices\nand ideas from successful\nEPAM project");
    protected final Set<String> expectedNavigationSidebarText = Set
        .of("Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");

    protected String getUserName() {
        try {
            File file = new File("src/test/java/com/epam/tc/hw2/credentials");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern1 = Pattern.compile("username", Pattern.CASE_INSENSITIVE);
            while (line != null) {
                Matcher matcher1 = pattern1.matcher(line);
                if (matcher1.find()) {
                    Pattern pattern2 = Pattern.compile("\"([^\"]*)\"");
                    Matcher matcher2 = pattern2.matcher(line);
                    if (matcher2.find()) {
                        return matcher2.group(1);
                    }
                    line = reader.readLine();
                } else {
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getPassword() {
        try {
            File file = new File("src/test/java/com/epam/tc/hw2/credentials");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern1 = Pattern.compile("password", Pattern.CASE_INSENSITIVE);
            while (line != null) {
                Matcher matcher1 = pattern1.matcher(line);
                if (matcher1.find()) {
                    Pattern pattern2 = Pattern.compile("\"([^\"]*)\"");
                    Matcher matcher2 = pattern2.matcher(line);
                    if (matcher2.find()) {
                        return matcher2.group(1);
                    }
                    line = reader.readLine();
                } else {
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void assertCheckBoxes(List<WebElement> checkBoxes, WebDriver driver,
                                    SoftAssertions softly, boolean isSelected) {
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String checkBoxName = checkBox.getText();
            String actualLogText = log.getText();
            String expectedLogText = checkBoxName + ": condition changed to " + isSelected;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);

        }
    }

    protected void checkCheckBoxes(List<WebElement> checkBoxes, WebDriver driver,
                                   SoftAssertions softly) {
        assertCheckBoxes(checkBoxes, driver, softly, true);
        assertCheckBoxes(checkBoxes, driver, softly, false);
    }

    protected void checkRadioBoxes(List<WebElement> radioBoxes, WebDriver driver, SoftAssertions softly) {
        for (WebElement radioBox : radioBoxes) {
            radioBox.click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String radioBoxName = radioBox.getText();
            String actualLogText = log.getText();
            String expectedLogText = "metal: value changed to " + radioBoxName;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);

        }
    }

    protected void checkColorOptions(List<WebElement> colorOptions, WebDriver driver, SoftAssertions softly) {
        for (int i = 3; i >= 0; i--) {
            colorOptions.get(i).click();
            WebElement log = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(e -> driver.findElement(By
                    .xpath("//ul[@class='panel-body-list logs']/li")));
            String optionName = colorOptions.get(i).getText();
            String actualLogText = log.getText();
            String expectedLogText = "Colors: value changed to " + optionName;
            softly.assertThat(expectedLogText).isSubstringOf(actualLogText);
        }
    }

}
