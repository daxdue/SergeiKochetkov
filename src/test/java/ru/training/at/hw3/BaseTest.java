package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.pages.JdiElementsPage;
import ru.training.at.hw3.pages.JdiMainPage;
import ru.training.hw3.PropertyManager;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private WebDriver webDriver;
    protected JdiMainPage jdiMainPage;
    protected JdiElementsPage jdiElementsPage;
    protected PropertyManager propertyManager;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        jdiMainPage = new JdiMainPage(webDriver);
        jdiElementsPage = new JdiElementsPage(webDriver);
        propertyManager = new PropertyManager();
        propertyManager.load();
    }

    @AfterClass
    public void setDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test(priority = 1)
    public void browserTitleTest() {
        jdiMainPage.openPage();
        jdiMainPage.verifyBrowserName("Home Page");
    }

    @Test(priority = 2)
    public void performLoginTest() {
        jdiMainPage.login(propertyManager.getUsername(),
                propertyManager.getPassword());
        jdiMainPage.verifyLoggedUserName("ROMAN IOVLEV");
    }
}
