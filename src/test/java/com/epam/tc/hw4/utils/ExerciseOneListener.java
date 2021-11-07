package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExerciseOneListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult itestResult) {
        ITestContext context = itestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        AttachmentUtils.attachScreenshot(driver);
    }






}
