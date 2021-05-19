package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.pages.UserTablePage;
import ru.training.hw5.utils.BrowserManager;

public class ManageUsersSteps {

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckvox() {
        new UserTablePage(BrowserManager.getChromeDriver()).clickCheckboxVipIvan();
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void logRowVerify() {
        new UserTablePage(BrowserManager.getChromeDriver()).verifyVipCheckboxLog();
    }
}
