package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dropdown {
    @FindBy(css = "select.uui-form-element")
    private WebElement dropdown;
    @FindBy(xpath = "//option[contains(text(), 'Red')]")
    private WebElement redOption;
    @FindBy(xpath = "//option[contains(text(), 'Green')]")
    private WebElement greenOption;
    @FindBy(xpath = "//option[contains(text(), 'Blue')]")
    private WebElement blueOption;
    @FindBy(xpath = "//option[contains(text(), 'Yellow')]")
    @Getter
    private WebElement yellowOption;

    public Dropdown(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void click() {
        dropdown.click();
    }
}
