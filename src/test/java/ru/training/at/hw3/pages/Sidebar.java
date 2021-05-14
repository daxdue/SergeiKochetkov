package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sidebar {
    @FindBy(xpath = "//span[contains(text(), 'Home')]")
    private WebElement homeItem;
    @FindBy(xpath = "//span[contains(text(), 'Contact form')]")
    private WebElement contactFormItem;
    @FindBy(xpath = "//span[contains(text(), 'Service')]")
    private WebElement serviceItem;
    @FindBy(xpath = "//span[contains(text(), 'Metals & Colors')]")
    private WebElement metalsColorsItem;
    @FindBy(xpath = "//span[contains(text(), 'Elements packs')]")
    private WebElement elementsPacksItem;

    public Sidebar(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getSidebarElements() {
        return new ArrayList<>(Arrays.asList(
                homeItem,
                contactFormItem,
                serviceItem,
                metalsColorsItem,
                elementsPacksItem
        ));
    }
}
