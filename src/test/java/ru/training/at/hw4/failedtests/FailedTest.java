package ru.training.at.hw4.failedtests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.BaseTest;
import ru.training.at.hw4.listeners.ScreenshotListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Feature("Main page capabilities")
@Story("View main page")
@Listeners(ScreenshotListener.class)
public class FailedTest extends BaseTest {

    @Test(priority = 3)
    @Description("This test checks quantity of header items and their titles")
    public void headerItemsQuantityTest() {
        jdiMainPage.verifyHeaderItemsQuantity(4);
        List<String> itemsTitlesExpected = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"));
        jdiMainPage.verifyHeaderItemsTitles(itemsTitlesExpected);
    }

    @Test(priority = 4)
    @Description("This test checks quantity of images and their displaying")
    public void benefitsImagesQuantityTest() {
        jdiMainPage.verifyImagesQuantity(4);
        jdiMainPage.verifyImagesDisplaying();
    }

    @Test(priority = 5)
    @Description("This test checks quantity of benefits texts and their content")
    public void benefitsTextsQuantityTest() {
        jdiMainPage.verifyBenefitsTextQuantity(5);
        List<String> benefitsTextsValues = new ArrayList<>(Arrays.asList(
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
        jdiMainPage.verifyBenefitsTextContent(benefitsTextsValues);
    }

    @Test(priority = 6)
    @Description("This test checks displaying of frame element on the page")
    public void frameElementDisplayingTest() {
        jdiMainPage.verifyFrameElementDisplayed();
        jdiMainPage.switchToIframe();
        jdiMainPage.verifyFrameButtonDisplayed();
        jdiMainPage.switchToMainContent();
    }

    @Test(priority = 7)
    public void sidebarElementsTest() {
        jdiMainPage.verifySidebarElementsQuantity(5);
        List<String> expectedSideBarItemsNames =
                new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
                        "Metals & Colors", "Elements packs"));
        jdiMainPage.verifySidebarElements(expectedSideBarItemsNames);
    }
}
