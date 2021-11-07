package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AttachmentUtils {

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public static String attachString(String str) {
        return str;
    }

    @Attachment
    public static String attachCredentials(String userName, String password) {
        return "Username: " + userName + "\n Password: " + password;
    }


}
