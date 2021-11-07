package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(value = "{fileName}", type = "image/png", fileExtension = ".png")
    public static byte[] attachFile(final String fileName, byte[] file) {
        return file;
    }



}
