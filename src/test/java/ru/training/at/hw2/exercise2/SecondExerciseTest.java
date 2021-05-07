package ru.training.at.hw2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SecondExerciseTest {
    WebDriver webDriver;

    /**
     * Prepare parameters for tests.
     */
    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Assert browser title.
     */
    @Test(priority = 1)
    public void browserTitleTest() {
        Assert.assertEquals(webDriver.getTitle(), "Home Page");
    }

    /**
     * Assert user name after user logged in.
     */
    @Test(priority = 2)
    public void usernameTest() {
        WebElement loginForm = webDriver.findElement(By.xpath("/html/body/header/div/nav/ul[2]"));
        loginForm.click();
        WebElement nameField = webDriver.findElement(By.id("name"));
        nameField.sendKeys("Roman");
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("Jdi1234");
        WebElement enterButton = webDriver.findElement(By.id("login-button"));
        enterButton.click();
        WebElement name = webDriver.findElement(By.id("user-name"));
        Assert.assertEquals(name.getText(), "ROMAN IOVLEV");
    }

    /**
     * Assert opening Different Elements Page via Service sidebar item clicking.
     */
    @Test(priority = 3)
    public void openDifferentElementPageTest() {
        WebElement serviceTab = webDriver.findElement(By.cssSelector("div#mCSB_1_container > "
                + "ul > li:nth-child(3)"));
        serviceTab.click();
        WebElement diffElementsPageButton = webDriver.findElement(
                By.cssSelector("div#mCSB_1_container > ul > li:nth-child(3) > "
                        + "ul.sub > li:nth-child(8) > a"));
        diffElementsPageButton.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(webDriver.getTitle(), "Different Elements");
    }

    /**
     * Assert select checkboxes and log rows for the checkboxes.
     */
    @Test(priority = 4)
    public void selectCheckboxesTest() {
        WebElement waterCheckBox = webDriver.findElement(By.cssSelector("div.main-content-hg > "
                + "div.checkbox-row:nth-child(2) > label:nth-child(1) > input"));
        waterCheckBox.click();
        Assert.assertTrue(waterCheckBox.isSelected());
        WebElement windCheckBox = webDriver.findElement(By.cssSelector("div.main-content-hg > "
                + "div.checkbox-row:nth-child(2) > label:nth-child(3) > input"));
        windCheckBox.click();
        Assert.assertTrue(windCheckBox.isSelected());

        WebElement waterCheckboxLog = webDriver.findElement(By.xpath("//li[contains(text(), "
                + "'Water')]"));
        Assert.assertTrue(waterCheckboxLog.getText().contains("Water: condition changed to true"));
        WebElement windCheckboxLog = webDriver.findElement(By.xpath("//li[contains(text(), "
                + "'Wind')]"));
        Assert.assertTrue(windCheckboxLog.getText().contains("Wind: condition changed to true"));

    }

    /**
     * Assert select radio button and log row for the radio button.
     */
    @Test(priority = 5)
    public void selectRadioTest() {
        WebElement selenRadio = webDriver.findElement(By.cssSelector("div.main-content-hg > "
                + "div.checkbox-row:nth-child(3) > label:nth-child(4) > input"));
        selenRadio.click();
        Assert.assertTrue(selenRadio.isSelected());
        WebElement selenRadioLog = webDriver.findElement(By.xpath("//li[contains(text(), "
                + "'metal')]"));
        Assert.assertTrue(selenRadioLog.getText().contains("metal: value changed to Selen"));
    }

    /**
     * Assert select Yellow color in dropdown and log row for the dropdown.
     */
    @Test(priority = 6)
    public void selectDropdownTest() {
        WebElement yellowColorItem = webDriver.findElement(By.cssSelector("div.main-content-hg >"
                + " div.colors > select > option:nth-child(4)"));
        yellowColorItem.click();
        Assert.assertTrue(yellowColorItem.isSelected());
        WebElement colorLog = webDriver.findElement(By.xpath("//li[contains(text(), "
                + "'Colors')]"));
        Assert.assertTrue(colorLog.getText().contains("Colors: value changed to Yellow"));
    }

    /**
     * Close webdriver after all tests.
     */
    @AfterClass
    public void setDown() {
        webDriver.close();
    }

}
