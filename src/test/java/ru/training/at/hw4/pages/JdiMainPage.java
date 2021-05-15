package ru.training.at.hw4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class JdiMainPage extends BaseJdiPage {
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

    @Step("Verify quantity of header items")
    public void verifyHeaderItemsQuantity(int expectedQuantity) {
        Assert.assertEquals(header.getHeaderElements().size(), expectedQuantity);
    }

    @Step("Check the header items titles equals the required titles")
    public void verifyHeaderItemsTitles(List<String> expectedTitles) {
        List<WebElement> headerElements = header.getHeaderElements();
        Assert.assertEquals(headerElements.size(), expectedTitles.size());
        for (int i = 0; i < headerElements.size(); i++) {
            Assert.assertTrue(headerElements.get(i).isDisplayed());
            Assert.assertEquals(headerElements.get(i).getText(), expectedTitles.get(i));
        }
    }

    @Step("Check images quantity")
    public void verifyImagesQuantity(int expectedQuantity) {
        Assert.assertEquals(benefitsImages.size(), expectedQuantity);
    }

    @Step("Check images displaying")
    public void verifyImagesDisplaying() {
        for (WebElement image : benefitsImages) {
            softAssert.assertTrue(image.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check benefits texts quantity")
    public void verifyBenefitsTextQuantity(int expectedQuantity) {
        Assert.assertEquals(benefitsTexts.size(), expectedQuantity);
    }

    @Step("Check the benefits text contents equals the required contents")
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

    @Step("Check displaying of frame element")
    public void verifyFrameElementDisplayed() {
        Assert.assertTrue(frameElement.isDisplayed());
    }

    @Step("Check displaying of frame button")
    public void verifyFrameButtonDisplayed() {
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Switch to iframe")
    public void switchToIframe() {
        webDriver.switchTo().frame(frameElement);
    }

    @Step("Switch to main content")
    public void switchToMainContent() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Check quantity of sidebar elements")
    public void verifySidebarElementsQuantity(int requiredQuantity) {
        Assert.assertEquals(sidebar.getSidebarElements().size(), requiredQuantity);
    }

    @Step("Check the sidebar elements titles equals the required titles")
    public void verifySidebarElements(List<String> expectedItems) {
        List<WebElement> sidebarElements = sidebar.getSidebarElements();
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
