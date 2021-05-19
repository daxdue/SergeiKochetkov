package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.pages.JdiMainPage;
import ru.training.hw5.utils.BrowserManager;

public class BaseSteps {

    @Given("I open JDI GitHub site")
    public void openMainPage() {
        new JdiMainPage(BrowserManager.getChromeDriver()).openPage();
    }

    @When("I perform login with username {string} and password {string}")
    public void performLogin(String username, String password) {
        new JdiMainPage(BrowserManager.getChromeDriver()).login(username, password);
    }

    @Then("I expect to view logged user {string}")
    public void verifyUser(String username) {
        new JdiMainPage(BrowserManager.getChromeDriver()).verifyLoggedUserName(username);
    }
}
