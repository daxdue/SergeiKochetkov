package ru.training.at.hw4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JdiElementsPage extends BaseJdiPage {
    private static final String WATER_LOGS_PATTERN = "Water: condition changed to true";
    private static final String WIND_LOGS_PATTERN = "Wind: condition changed to true";
    private static final String SELEN_LOGS_PATTERN = "metal: value changed to Selen";
    private static final String COLORS_LOGS_PATTERN = "Colors: value changed to Yellow";
    private Checkbox checkbox;
    private RadioButtons radioButtons;
    private Dropdown dropdown;
    @FindBy(xpath = "//li[contains(text(),'Water')]")
    private List<WebElement> waterCheckboxLogs;
    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    private List<WebElement> windCheckboxLogs;
    @FindBy(xpath = "//li[contains(text(), 'metal')]")
    private List<WebElement> selenRadiobuttonLogs;
    @FindBy(xpath = "//li[contains(text(), 'Colors')]")
    private List<WebElement> dropdownElementsLogs;
    private WebDriver webDriver;

    public JdiElementsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        checkbox = new Checkbox(webDriver);
        radioButtons = new RadioButtons(webDriver);
        dropdown = new Dropdown(webDriver);
    }

    @Step("Select 'Water' checkbox")
    public void selectWaterCheckbox() {
        checkbox.getWaterCheckBox().click();
        softAssert.assertTrue(checkbox.getWaterCheckBox().isSelected());
    }

    @Step("Select 'Wind' checkbox")
    public void selectWindCheckbox() {
        checkbox.getWindCheckBox().click();
        softAssert.assertTrue(checkbox.getWindCheckBox().isSelected());
    }

    @Step("Select 'Selen' radio button")
    public void selectSelenRadioButton() {
        radioButtons.getSelenRadioButton().click();
        softAssert.assertTrue(radioButtons.getSelenRadioButton().isSelected());
    }

    public void selectYellowDropdownOption() {
        dropdown.click();
        dropdown.getYellowOption().click();
        softAssert.assertTrue(dropdown.getYellowOption().isSelected());
    }

    @Step("Verify 'Water' checkbox log")
    public void verifyWaterCheckboxLog() {
        softAssert.assertTrue(!waterCheckboxLogs.isEmpty());
        softAssert.assertTrue(waterCheckboxLogs.get(0).getText().contains(WATER_LOGS_PATTERN));
        softAssert.assertAll();
    }

    @Step("Verify 'Wind' checkbox log")
    public void verifyWindCheckboxLog() {
        softAssert.assertTrue(!windCheckboxLogs.isEmpty());
        softAssert.assertTrue(windCheckboxLogs.get(0).getText().contains(WIND_LOGS_PATTERN));
        softAssert.assertAll();
    }

    @Step("Verify 'Selen' radio button log")
    public void verifySelenRadiobuttonLog() {
        softAssert.assertTrue(!selenRadiobuttonLogs.isEmpty());
        softAssert.assertTrue(selenRadiobuttonLogs.get(0).getText().contains(SELEN_LOGS_PATTERN));
        softAssert.assertAll();
    }

    @Step("Verify dropdown elements log")
    public void verifyDropdownElementsLog() {
        softAssert.assertTrue(!dropdownElementsLogs.isEmpty());
        softAssert.assertTrue(dropdownElementsLogs.get(0).getText().contains(COLORS_LOGS_PATTERN));
        softAssert.assertAll();
    }
}
