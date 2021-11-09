package com.epam.tc.hw4.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExerciseOneListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult itestResult) {
        Object driver = itestResult.getTestContext().getAttribute("driver");

        System.out.println("DRIVER IN LISTENER" + driver);

        if (driver != null) {
            AttachmentUtils.attachFile("Screenshot",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
