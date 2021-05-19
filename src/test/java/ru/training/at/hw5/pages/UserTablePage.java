package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class UserTablePage extends BaseJdiPage {
    private static final String VIP_LOG_PATTERN = "Vip: condition changed to true";

    @FindBy(xpath = "//select")
    List<WebElement> dropdowns;
    @FindBy(css = "td > a")
    List<WebElement> usernames;
    @FindBy(xpath = "//div[@class='user-descr']")
    List<WebElement> descriptions;
    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> vipCheckboxes;
    @FindBy(xpath = "//tr[contains(., 'Roman')]/td/select/option")
    List<WebElement> optionsValues;
    @FindBy(id = "ivan")
    WebElement vipCheckboxIvan;
    @FindBy(xpath = "//li[contains(text(),'Vip')]")
    List<WebElement> vipLogs;


    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void verifyDropdownsQuantity(int expectedQuantity) {
        Assert.assertEquals(dropdowns.size(), expectedQuantity);
    }

    public void verifyUsernamesQuantity(int expectedQuantity) {
        Assert.assertEquals(usernames.size(), expectedQuantity);
    }

    public void verifyDescriptionsQuantity(int expectedQuantity) {
        Assert.assertEquals(descriptions.size(), expectedQuantity);
    }

    public void verifyCheckboxesQuantity(int expectedQuantity) {
        Assert.assertEquals(vipCheckboxes.size(), expectedQuantity);
    }

    public void verifyUsers(List<String> expectedList) {
        for (String expectedItem : expectedList) {
            WebElement actualItem = usernames.stream()
                    .filter(un -> un.getText().equals(expectedItem))
                    .findFirst()
                    .orElse(null);
            softAssert.assertEquals(actualItem.getText(), expectedItem);
        }
        softAssert.assertAll();
    }

    public void verifySelectOptions(List<String> expectedList) {
        for (String expectedItem : expectedList) {
            WebElement actualItem = optionsValues.stream()
                    .filter(op -> op.getText().equals(expectedItem))
                    .findFirst()
                    .orElse(null);
            softAssert.assertEquals(actualItem.getText(), expectedItem);
        }
        softAssert.assertAll();
    }

    public void clickCheckboxVipIvan() {
        vipCheckboxIvan.click();
        Assert.assertTrue(vipCheckboxIvan.isSelected());
    }

    public void verifyVipCheckboxLog() {
        softAssert.assertTrue(!vipLogs.isEmpty());
        softAssert.assertTrue(vipLogs.get(0).getText().contains(VIP_LOG_PATTERN));
        softAssert.assertAll();
    }
}
