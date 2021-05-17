package ru.training.hw4.attachments;

import io.qameta.allure.Attachment;

public class Attachments {
    @Attachment(type = "image/png", value = "try to use param {attributeName}")
    public static byte[] attachScreenshot(byte[] source, String attributeName) {
        return source;
    }
}
