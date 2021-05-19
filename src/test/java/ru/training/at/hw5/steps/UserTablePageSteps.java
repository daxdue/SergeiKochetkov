package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.pages.JdiMainPage;
import ru.training.at.hw5.pages.UserTablePage;
import ru.training.hw5.utils.BrowserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTablePageSteps {

    @When("I click on 'Service' button in Header")
    public void clickServiceButton() {
        new JdiMainPage(BrowserManager.getChromeDriver()).clickServiceButton();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickUserTableButton() {
        new JdiMainPage(BrowserManager.getChromeDriver()).clickUserTableButton();
    }

    @Then("\"User table\" page should be opened")
    public void verifyUserTablePage() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyBrowserName("User Table");
    }

    @And("6 Number type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyNumbersOfDropdownTypes() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyDropdownsQuantity(6);
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDisplayedUsernames() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyUsernamesQuantity(6);
    }

    @And("6 Description texts under images should be displayed on Users Table on Users Table Page")
    public void verifyNumberOfDescriptionTextsDisplayed() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyDescriptionsQuantity(6);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDisplayedCheckboxes() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyCheckboxesQuantity(6);
    }

    @And("User table should contain following values:")
    public void verifyUserTableValues(List<Map<String, String>> userTableValues) {
        List<String> usersExpected = new ArrayList<>();
        for (Map<String, String> userInfo : userTableValues) {
            usersExpected.add(userInfo.get("User"));
        }
        new UserTablePage(BrowserManager.getChromeDriver()).verifyUsers(usersExpected);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void verifyDroplistValues(List<Map<String, String>> droplistValues) {
        List<String> requiredValues = new ArrayList<>();
        for (Map<String, String> selectOption : droplistValues) {
            requiredValues.add(selectOption.get("Dropdown Values"));
        }
        new UserTablePage(BrowserManager.getChromeDriver()).verifySelectOptions(requiredValues);
    }
}
