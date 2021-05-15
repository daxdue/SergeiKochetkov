package ru.training.at.hw4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public abstract class BaseJdiPage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver webDriver;
    protected Header header;
    protected Sidebar sidebar;
    protected SoftAssert softAssert = new SoftAssert();
    @FindBy(id = "user-icon")
    private WebElement loginIcon;
    @FindBy(id = "name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement loggedUserName;

    public BaseJdiPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        sidebar = new Sidebar(webDriver);
    }

    @Step("Open page")
    public void openPage() {
        webDriver.get(URL);
    }

    @Step("Type username and password and click login btn")
    public void login(String username, String password) {
        loginIcon.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Step("Open 'Different Elements' page")
    public void openDifferentElementsPage() {
        header.getServiceItem().click();
        header.getDifferentElementsSubItem().click();
    }

    @Step("Verify browser name")
    public void verifyBrowserName(String requiredBrowserName) {
        Assert.assertEquals(webDriver.getTitle(), requiredBrowserName);
    }

    @Step("Verify logged username")
    public void verifyLoggedUserName(String expectedValue) {
        Assert.assertEquals(loggedUserName.getText(), expectedValue);
    }
}
