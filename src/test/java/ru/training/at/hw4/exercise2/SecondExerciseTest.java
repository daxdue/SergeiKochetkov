package ru.training.at.hw4.exercise2;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.BaseTest;

@Feature("Elements page capabilities")
public class SecondExerciseTest extends BaseTest {

    @Test(priority = 3)
    @Description("This test checks opening 'Different Elements' page")
    @Story("Actions with pages")
    public void openDifferentPageTest() {
        jdiMainPage.openDifferentElementsPage();
        jdiMainPage.verifyBrowserName("Different Elements");
    }

    @Test(priority = 4)
    @Description("This test checks selecting checkboxes and displaying logs")
    @Story("Actions with elements")
    public void selectCheckboxesTest() {
        jdiElementsPage.selectWaterCheckbox();
        jdiElementsPage.verifyWaterCheckboxLog();
        jdiElementsPage.selectWindCheckbox();
        jdiElementsPage.verifyWindCheckboxLog();

    }

    @Test(priority = 5)
    @Description("This test checks selecting radio button and displaying logs")
    @Story("Actions with elements")
    public void selectRadioButtonTest() {
        jdiElementsPage.selectSelenRadioButton();
        jdiElementsPage.verifySelenRadiobuttonLog();
    }

    @Test(priority = 6)
    @Description("This test checks selecting dropdown item and displaying logs")
    @Story("Actions with elements")
    public void selectDropdownItemTest() {
        jdiElementsPage.selectYellowDropdownOption();
        jdiElementsPage.verifyDropdownElementsLog();
    }
}
