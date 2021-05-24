package ru.training.hw6.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.hw6.entities.TestData;

public class MetalsColorsForm extends Form<TestData> {

    @FindBy(name = "custom_radio_odd")
    private static RadioButtons oddRadioButtons;

    @FindBy(name = "custom_radio_even")
    private static RadioButtons eventRadioButtons;

    @UI("p.checkbox > [type=checkbox]")
    private static Checklist elementsChecklist;

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private static Dropdown colorsDropdown;

    @JDropdown(root = "div[id=metals]",
            value = "button.btn.dropdown-toggle",
            list = "li",
            expand = ".caret")
    private static Dropdown metalsDropdown;

    @JDropdown(root = "div[id=vegetables]",
            value = "button.btn.btn-default",
            list = "li",
            expand = ".caret")
    private static Dropdown vegetablesDropdown;

    @FindBy(id = "submit-button")
    private static Button submitButton;

    @Override
    public void submit(TestData testData) {
        oddRadioButtons.select(testData.getSummary().get(0).toString());
        eventRadioButtons.select(testData.getSummary().get(1).toString());

        for (String element : testData.getElements()) {
            elementsChecklist.select(element);
        }

        colorsDropdown.select(testData.getColor());
        metalsDropdown.select(testData.getMetals());
        resetVegetables();
        for (String vegetable : testData.getVegetables()) {
            vegetablesDropdown.select(vegetable);
        }

        submitButton.click();
    }

    private void resetVegetables() {
        vegetablesDropdown.select("Vegetables");
    }
}
