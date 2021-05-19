package ru.training.at.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Header {
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private WebElement homeItem;
    @FindBy(xpath = "//a[contains(text(), 'Contact form')]")
    private WebElement contactFormItem;
    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    @Getter
    private WebElement serviceItem;
    @FindBy(xpath = "//a[contains(text(), 'Metals & Colors')]")
    private WebElement metalsColorsItem;
    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    @Getter
    private WebElement differentElementsSubItem;

    @FindBy(xpath = "//a[contains(text(), 'User Table')]")
    @Getter
    private WebElement userTableSubItem;

    public Header(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getHeaderElements() {
        return new ArrayList<>(Arrays.asList(
                homeItem,
                contactFormItem,
                serviceItem,
                metalsColorsItem
        ));
    }
}
