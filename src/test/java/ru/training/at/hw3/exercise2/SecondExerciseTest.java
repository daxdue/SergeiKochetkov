package ru.training.at.hw3.exercise2;

import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;

public class SecondExerciseTest extends BaseTest {

    @Test(priority = 3)
    public void openDifferentPageTest() {
        jdiMainPage.openDifferentElementsPage();
    }

    @Test(priority = 4)
    public void selectCheckboxesTest() {
        jdiElementsPage.selectWaterCheckbox();
        jdiElementsPage.selectWindCheckbox();
    }

    @Test(priority = 5)
    public void selectRadioButtonTest() {
        jdiElementsPage.selectSelenRadioButton();
    }

    @Test(priority = 6)
    public void selectDropdownItemTest() {
        jdiElementsPage.selectYellowDropdownOption();
    }
}
