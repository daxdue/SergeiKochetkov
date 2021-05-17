package ru.training.at.hw4;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw4.pages.JdiElementsPage;
import ru.training.at.hw4.pages.JdiMainPage;
import ru.training.hw3.PropertyManager;
import ru.training.hw4.utils.BrowserManager;

public abstract class BaseTest {
    protected JdiMainPage jdiMainPage;
    protected JdiElementsPage jdiElementsPage;
    protected PropertyManager propertyManager;

    @BeforeClass
    @Step("Prepare environment for tests")
    public void setUp() {
        jdiMainPage = new JdiMainPage(BrowserManager.getChromeDriver());
        jdiElementsPage = new JdiElementsPage(BrowserManager.getChromeDriver());
        propertyManager = new PropertyManager();
        propertyManager.load();
    }

    @AfterClass
    @Step("Deinit test's environment")
    public void setDown() {
        BrowserManager.close();
    }

    @Test(priority = 1)
    @Description("This test checks browser title")
    @Story("As a user I can view right browser title")
    public void browserTitleTest() {
        jdiMainPage.openPage();
        jdiMainPage.verifyBrowserName("Home Page");
    }

    @Test(priority = 2)
    @Description("This test checks user's ability to login")
    @Story("As a user I can login into System")
    public void performLoginTest() {
        jdiMainPage.login(propertyManager.getUsername(),
                propertyManager.getPassword());
        jdiMainPage.verifyLoggedUserName("ROMAN IOVLEV");
    }
}
