package ru.training.at.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class JdiMainPage extends BaseJdiPage {
    @FindBy(id = "user-name")
    private WebElement loggedUserName;
    @FindBy(css = "span.icons-benefit")
    private List<WebElement> benefitsImages;
    @FindBy(css = "span.benefit-txt")
    private List<WebElement> benefitsTexts;
    @FindBy(id = "frame")
    private WebElement frameElement;

    public JdiMainPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void verifyLoggedUserName(String expectedValue) {
        Assert.assertEquals(loggedUserName.getText(), expectedValue);
    }

    public void verifyHeaderItemsQuantity(int expectedQuantity) {
        Assert.assertEquals(header.getHeaderElements().size(), expectedQuantity);
    }

    public void verifyHeaderItemsTitles(List<String> expectedTitles) {
        List<WebElement> headerElements = header.getHeaderElements();
        Assert.assertEquals(headerElements.size(), expectedTitles.size());
        for (int i = 0; i < headerElements.size(); i++) {
            Assert.assertTrue(headerElements.get(i).isDisplayed());
            Assert.assertEquals(headerElements.get(i).getText(), expectedTitles.get(i));
        }
    }

    public void verifyImagesQuantity(int expectedQuantity) {
        Assert.assertEquals(benefitsImages.size(), expectedQuantity);
    }

    public void verifyBenefitsTextQuantity(int expectedQuantity) {
        Assert.assertEquals(benefitsTexts.size(), expectedQuantity);
    }

    public void verifyBenefitsTextContent(List<String> expectedContents) {
        for (String textContent : expectedContents) {
            WebElement actualContent = benefitsTexts.stream()
                    .filter(bc -> bc.getText().equals(textContent))
                    .findFirst()
                    .orElse(null);
            softAssert.assertEquals(actualContent.getText(), textContent);
        }
        softAssert.assertAll();
    }

    public void verifyFrameElementDisplayed() {
        Assert.assertTrue(frameElement.isDisplayed());
    }

    public void verifyFrameButtonDisplayed() {
        softAssert.assertTrue(frameElement.isDisplayed());
        webDriver.switchTo().frame(frameElement);
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
        webDriver.switchTo().defaultContent();
        softAssert.assertAll();
    }

    public void verifySidebarElements(List<String> expectedItems) {
        List<WebElement> sidebarElements = sidebar.getSidebarElements();
        softAssert.assertEquals(sidebarElements.size(), expectedItems.size());
        for (String itemText : expectedItems) {
            WebElement actualItem = sidebarElements.stream()
                    .filter(se -> se.getText().equals(itemText))
                    .findFirst()
                    .orElse(null);
            softAssert.assertEquals(actualItem.getText(), itemText);
        }
        softAssert.assertAll();
    }
}
