package ru.training.at.hw3.exercise1;

import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstExerciseTest extends BaseTest {

    @Test(priority = 3)
    public void headerItemsQuantityTest() {
        jdiMainPage.verifyHeaderItemsQuantity(4);
    }

    @Test(priority = 4)
    public void headerItemsTitlesTest() {
        List<String> itemsTitlesExpected = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"));
        jdiMainPage.verifyHeaderItemsTitles(itemsTitlesExpected);
    }

    @Test(priority = 5)
    public void benefitsImagesQuantityTest() {
        jdiMainPage.verifyImagesQuantity(4);
    }

    @Test(priority = 6)
    public void benefitsTextsQuantityTest() {
        jdiMainPage.verifyBenefitsTextQuantity(4);
    }

    @Test(priority = 7)
    public void benefitsTextsContentTest() {
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

    @Test(priority = 8)
    public void frameElementDisplayingTest() {
        jdiMainPage.verifyFrameElementDisplayed();
    }

    @Test(priority = 9)
    public void frameButtonDisplayingTest() {
        jdiMainPage.verifyFrameButtonDisplayed();
    }

    @Test(priority = 10)
    public void sidebarElementsTest() {
        List<String> expectedSideBarItemsNames =
                new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
                        "Metals & Colors", "Elements packs"));
        jdiMainPage.verifySidebarElements(expectedSideBarItemsNames);
    }
}
