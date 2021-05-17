package ru.training.at.hw4.exercise2;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.BaseTest;
import ru.training.at.hw4.listeners.ScreenshotListener;

@Feature("Elements page capabilities")
@Listeners(ScreenshotListener.class)
public class SecondExerciseTest extends BaseTest {

    @Test(priority = 3)
    @Description("This test checks opening 'Different Elements' page")
    @Story("As a User I can open 'Different Element' page from 'Main' page")
    public void openDifferentPageTest() {
        jdiMainPage.openDifferentElementsPage();
        jdiMainPage.verifyBrowserName("Different Elements");
    }

    @Test(priority = 4)
    @Description("This test checks selecting checkboxes and displaying logs")
    @Story("As a User I can do actions with 'Select' elements on the page and "
            + "view logs for the elements in log block")
    public void selectCheckboxesTest() {
        jdiElementsPage.selectWaterCheckbox();
        jdiElementsPage.verifyWaterCheckboxLog();
        jdiElementsPage.selectWindCheckbox();
        jdiElementsPage.verifyWindCheckboxLog();

    }

    @Test(priority = 5)
    @Description("This test checks selecting radio button and displaying logs")
    @Story("As a User I can do actions with 'Radio button' elements on the page and "
            + "view logs for the elements in log block")
    public void selectRadioButtonTest() {
        jdiElementsPage.selectSelenRadioButton();
        jdiElementsPage.verifySelenRadiobuttonLog();
    }

    @Test(priority = 6)
    @Description("This test checks selecting dropdown item and displaying logs")
    @Story("As a User I can do actions with 'Dropdown' elements on the page and "
            + "view logs for the elements in log block")
    public void selectDropdownItemTest() {
        jdiElementsPage.selectYellowDropdownOption();
        jdiElementsPage.verifyDropdownElementsLog();
    }
}
