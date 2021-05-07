package ru.training.at.hw2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BasePageTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExerciseTest extends BasePageTest {
    /**
     * Assert header items names.
     */
    @Test(priority = 3)
    public void headerItemsNamesTest() {
        List<WebElement> headerItems = webDriver
                .findElements(By.cssSelector("ul.nav > li"));
        softAssert.assertEquals(headerItems.size(), 4);
        List<String> itemsTitlesExpected = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"));
        List<String> itemsTitlesActual = new ArrayList<>();
        for (WebElement webElement : headerItems) {
            softAssert.assertTrue(webElement.isDisplayed());
            itemsTitlesActual.add(webElement.getText());
        }
        softAssert.assertEquals(itemsTitlesActual, itemsTitlesExpected);
        softAssert.assertAll();
    }

    /**
     * Assert quantity of images.
     */
    @Test(priority = 4)
    public void imagesAmountTest() {
        List<WebElement> benefitImages = webDriver
                .findElements(By.cssSelector("span.icons-benefit"));
        softAssert.assertEquals(benefitImages.size(), 4);
        for (WebElement benefitImage : benefitImages) {
            softAssert.assertTrue(benefitImage.isDisplayed());
        }
        softAssert.assertAll();
    }

    /**
     * Assert quantity of texts.
     */
    @Test(priority = 5)
    public void textsAmountTest() {
        List<WebElement> benefitTexts = webDriver
                .findElements(By.cssSelector("span.benefit-txt:nth-child(2)"));
        softAssert.assertEquals(benefitTexts.size(), 4);
        for (WebElement benefitText : benefitTexts) {
            softAssert.assertTrue(benefitText.isDisplayed());
        }
        softAssert.assertAll();
    }

    /**
     * Assert iframe exists in page.
     */
    @Test(priority = 6)
    public void iframeExistingTest() {
        WebElement frame = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        softAssert.assertTrue(frame.isDisplayed());
    }

    /**
     * Assert Frame Button exists in iframe.
     */
    @Test(priority = 7)
    public void frameButtonExistingTest() {
        WebElement frame = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        softAssert.assertTrue(frame.isDisplayed());
        webDriver.switchTo().frame(frame);
        WebElement frameButton =  webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
        webDriver.switchTo().defaultContent();
        softAssert.assertAll();
    }

    /**
     * Assert sidebar names of elements.
     */
    @Test(priority = 8)
    public void sidebarElementsExistingTest() {
        List<WebElement> sideBarItems = webDriver
                .findElements(By.cssSelector("ul.sidebar-menu > li > a"));
        softAssert.assertEquals(sideBarItems.size(), 5);
        List<String> expectedSideBarItemsNames =
                new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
                        "Metals & Colors", "Elements packs"));
        List<String> actualSideBarItemsNames = new ArrayList<>();
        for (WebElement sideBarItem : sideBarItems) {
            actualSideBarItemsNames.add(sideBarItem.getText());
        }
        softAssert.assertEquals(actualSideBarItemsNames, expectedSideBarItemsNames);
        softAssert.assertAll();
    }
}
