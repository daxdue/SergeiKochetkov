package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class BasePageTest {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver webDriver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(URL);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    /**
     * Close webdriver after all tests.
     */
    @AfterClass
    public void setDown() {
        webDriver.close();
    }

    /**
     * Assert browser title.
     */
    @Test(priority = 1)
    public void browserTitleTest() {
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");
    }

    /**
     * Assert user name after user logged in.
     */
    @Test(priority = 2)
    public void loginUserTest() {
        WebElement loginForm = webDriver.findElement(By.id("user-icon"));
        loginForm.click();
        WebElement username = webDriver.findElement(By.id("name"));
        WebElement pass = webDriver.findElement(By.id("password"));
        username.sendKeys("Roman");
        pass.sendKeys("Jdi1234");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement name = webDriver.findElement(By.id("user-name"));
        softAssert.assertEquals(name.getText(), "ROMAN IOVLEV");
        softAssert.assertAll();
    }
}
