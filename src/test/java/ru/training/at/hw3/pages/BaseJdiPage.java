package ru.training.at.hw3.pages;

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

    public BaseJdiPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        sidebar = new Sidebar(webDriver);
    }

    public void openPage() {
        webDriver.get(URL);
    }

    public void login(String username, String password) {
        loginIcon.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void openDifferentElementsPage() {
        header.getServiceItem().click();
        header.getDifferentElementsSubItem().click();
        Assert.assertEquals(webDriver.getTitle(), "Different Elements");
    }
}
