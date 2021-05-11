package ru.training.at.hw2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BasePageTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExerciseTest extends BasePageTest {
    private WebElement frameElement;

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
        String xpathPattern = "//span[contains(@class,'%s')]/following::span[1]";
        List<String> benefitsValues = new ArrayList<>(Arrays.asList(
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "To be flexible and\n"
                        + "customizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…"
        ));
        List<String> iconsClasses = new ArrayList<>(Arrays.asList(
                "icon-practise",
                "icon-custom",
                "icon-multi",
                "icon-base"
        ));

        List<String> actualTextValues = new ArrayList<>();
        for (String classType : iconsClasses) {
            String elementXpath = String.format(xpathPattern, classType);
            WebElement benefitElement = webDriver.findElement(By.xpath(elementXpath));
            actualTextValues.add(benefitElement.getText());
        }
        softAssert.assertEquals(actualTextValues.size(), 4);
        softAssert.assertEquals(actualTextValues, benefitsValues);
        softAssert.assertAll();
    }

    /**
     * Assert iframe exists in page.
     */
    @Test(priority = 6)
    public void iframeExistingTest() {
        frameElement = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(frameElement.isDisplayed());
    }

    /**
     * Assert Frame Button exists in iframe.
     */
    @Test(priority = 7)
    public void frameButtonExistingTest() {
        softAssert.assertTrue(frameElement.isDisplayed());
        webDriver.switchTo().frame(frameElement);
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
        final String xpathPattern = "//span[contains(text(), '%s')]";
        List<String> expectedSideBarItemsNames =
                new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
                        "Metals & Colors", "Elements packs"));
        List<String> actualSideBarItemsNames = new ArrayList<>();
        for (String textToFind : expectedSideBarItemsNames) {
            String elementXpath = String.format(xpathPattern, textToFind);
            WebElement sidebarElement = webDriver.findElement(By.xpath(elementXpath));
            actualSideBarItemsNames.add(sidebarElement.getText());
        }
        softAssert.assertEquals(actualSideBarItemsNames.size(), 5);
        softAssert.assertEquals(actualSideBarItemsNames, expectedSideBarItemsNames);
        softAssert.assertAll();
    }
}
