package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.pages.JdiElementsPage;
import ru.training.at.hw5.pages.JdiMainPage;
import ru.training.hw5.utils.BrowserManager;

public class ElementsPageSteps {

    @And("I open 'Different Elements' page")
    public void openDifferentElementsPage() {
        new JdiMainPage(BrowserManager.getChromeDriver()).openDifferentElementsPage();
    }

    @When("I select checkboxes 'Water' and 'Wind'")
    public void selectCheckboxes() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).selectWaterCheckbox();
        new JdiElementsPage(BrowserManager.getChromeDriver()).selectWindCheckbox();
    }

    @Then("log row displayed for each selected checkbox")
    public void checkboxesLogRowsVerify() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).verifyWaterCheckboxLog();
        new JdiElementsPage(BrowserManager.getChromeDriver()).verifyWindCheckboxLog();
    }

    @When("I select radio 'Selen'")
    public void selectRadio() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).selectSelenRadioButton();
    }

    @Then("log row displayed for selected radio")
    public void radioLogRowVerify() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).verifySelenRadiobuttonLog();
    }

    @When("I select dropdown item 'Yellow'")
    public void selectYellowDropdown() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).selectYellowDropdownOption();
    }

    @Then("log row displayed for selected dropdown element")
    public void dropdownLogRowVerify() {
        new JdiElementsPage(BrowserManager.getChromeDriver()).verifyDropdownElementsLog();
    }
}
