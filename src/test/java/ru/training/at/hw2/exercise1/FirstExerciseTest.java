package ru.training.at.hw2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstExerciseTest {
    WebDriver webDriver;
    SoftAssert softAssert;

    /**
     * Prepare parameters for tests.
     */
    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
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
        WebElement loginForm = webDriver.findElement(By.xpath("/html/body/header/div/nav/ul[2]"));
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

    /**
     * Assert header items names.
     */
    @Test(priority = 3)
    public void headerItemsNamesTest() {
        List<WebElement> headerItems = webDriver
                .findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));
        softAssert.assertEquals(headerItems.size(), 4);
        List<String> itemsTitlesExpected = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"));
        List<String> itemsTitlesActual = new ArrayList<>();
        for (WebElement webElement : headerItems) {
            softAssert.assertTrue(webElement.isDisplayed());
            itemsTitlesActual.add(webElement.getText());
        }
        softAssert.assertEquals(itemsTitlesActual, itemsTitlesExpected);
        softAssert.assertAll();
    }

    /**
     * Assert quantity of images.
     */
    @Test(priority = 4)
    public void imagesAmountTest() {
        List<WebElement> benefitImages = webDriver
                .findElements(By.cssSelector("div.benefit > div.benefit-icon:nth-child(1)"
                        + " > span.icons-benefit"));
        softAssert.assertEquals(benefitImages.size(), 4);
        for (WebElement benefitImage : benefitImages) {
            softAssert.assertTrue(benefitImage.isDisplayed());
        }
        softAssert.assertAll();
    }

    /**
     * Assert quantity of texts.
     */
    @Test(priority = 5)
    public void textsAmountTest() {
        List<WebElement> benefitTexts = webDriver
                .findElements(By.cssSelector("div.benefit > span.benefit-txt:nth-child(2)"));
        softAssert.assertEquals(benefitTexts.size(), 4);
        for (WebElement benefitText : benefitTexts) {
            softAssert.assertTrue(benefitText.isDisplayed());
        }
        softAssert.assertAll();
    }

    /**
     * Assert iframe exists in page.
     */
    @Test(priority = 6)
    public void iframeExistingTest() {
        WebElement frame = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        softAssert.assertTrue(frame.isDisplayed());
    }

    /**
     * Assert Frame Button exists in iframe.
     */
    @Test(priority = 7)
    public void frameButtonExistingTest() {
        WebElement frame = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        softAssert.assertTrue(frame.isDisplayed());
        webDriver.switchTo().frame(frame);
        WebElement frameButton =  webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());
        webDriver.switchTo().defaultContent();
        softAssert.assertAll();
    }

    /**
     * Assert sidebar names of elements.
     */
    @Test(priority = 8)
    public void sidebarElementsExistingTest() {
        List<WebElement> sideBarItems = webDriver
                .findElements(By.xpath("//div[@id='mCSB_1_container']/ul/li/a"));
        softAssert.assertEquals(sideBarItems.size(), 5);
        List<String> expectedSideBarItemsNames =
                new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
                        "Metals & Colors", "Elements packs"));
        List<String> actualSideBarItemsNames = new ArrayList<>();
        for (WebElement sideBarItem : sideBarItems) {
            actualSideBarItemsNames.add(sideBarItem.getText());
        }
        softAssert.assertEquals(actualSideBarItemsNames, expectedSideBarItemsNames);
        softAssert.assertAll();
    }

    /**
     * Close webdriver after all tests.
     */
    @AfterClass
    public void setDown() {
        webDriver.close();
    }

}
