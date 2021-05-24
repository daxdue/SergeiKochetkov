package ru.training.hw6.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import org.testng.asserts.SoftAssert;
import ru.training.hw6.entities.TestData;
import ru.training.hw6.sections.MetalsColorsForm;
import ru.training.hw6.sections.ResultSection;

public class JdiMetalsColorsPage extends JdiBasePage {

    @FindBy(xpath = "//form[@class='form']")
    public static MetalsColorsForm metalsColorsForm;

    @FindBy(xpath = "//div[@class='info-panel-section']")
    public static ResultSection resultSection;

    public void fillAndSubmitForm(TestData testData) {
        metalsColorsForm.submit(testData);
    }

    public void verifyResults(TestData testData) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultSection
                .verifySummaryRes(testData.getSummary().get(0)
                        + testData.getSummary().get(1)));
        softAssert.assertTrue(resultSection.verifyColorRes(testData.getColor()));
        softAssert.assertTrue(resultSection.verifyMetalRes(testData.getMetals()));
        softAssert.assertTrue(resultSection.verifyVegetables(testData.getVegetables()));
        softAssert.assertAll();
    }
}
