package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.pages.JdiElementsPage;
import ru.training.at.hw3.pages.JdiMainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private static final String PROPERTIES_FILE_PATH =
            "src/test/java/resources/hw3/test.properties";
    private static final String USERNAME_PROPERTY = "user.username";
    private static final String PASSWORD_PROPERTY = "user.password";
    private WebDriver webDriver;
    protected JdiMainPage jdiMainPage;
    protected JdiElementsPage jdiElementsPage;
    protected Properties properties;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        jdiMainPage = new JdiMainPage(webDriver);
        jdiElementsPage = new JdiElementsPage(webDriver);
        try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Assert.assertEquals(jdiMainPage.getBrowserTitle(), "Home Page");
    }

    @Test(priority = 2)
    public void performLoginTest() {
        jdiMainPage.login(properties.getProperty(USERNAME_PROPERTY),
                properties.getProperty(PASSWORD_PROPERTY));
        jdiMainPage.verifyLoggedUserName("ROMAN IOVLEV");
    }



}
