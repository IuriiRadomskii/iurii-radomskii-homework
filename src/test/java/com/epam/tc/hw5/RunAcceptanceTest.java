package com.epam.tc.hw5;

import com.epam.tc.hw5.util.ScreenshotListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/com.epam.tc.hw5.cucumber_features")
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
