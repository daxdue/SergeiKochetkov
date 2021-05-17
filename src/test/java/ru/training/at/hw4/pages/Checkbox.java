package ru.training.at.hw4.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkbox {
    @FindBy(xpath = "//label[@class='label-checkbox' and contains (., 'Water')]/input")
    @Getter
    private WebElement waterCheckBox;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains (., 'Earth')]/input")
    private WebElement earthCheckBox;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains (., 'Wind')]/input")
    @Getter
    private WebElement windCheckBox;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains (., 'Fire')]/input")
    private WebElement fireCheckBox;

    public Checkbox(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
