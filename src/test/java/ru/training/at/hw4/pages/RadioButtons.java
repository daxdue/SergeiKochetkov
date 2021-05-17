package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtons {
    @FindBy(xpath = "//label[@class='label-radio' and contains (., 'Gold')]/input")
    private WebElement goldRadioButton;
    @FindBy(xpath = "//label[@class='label-radio' and contains (., 'Silver')]/input")
    private WebElement silverRadioButton;
    @FindBy(xpath = "//label[@class='label-radio' and contains (., 'Bronze')]/input")
    private WebElement bronzeRadioButton;
    @FindBy(xpath = "//label[@class='label-radio' and contains (., 'Selen')]/input")
    @Getter
    private WebElement selenRadioButton;

    public RadioButtons(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
