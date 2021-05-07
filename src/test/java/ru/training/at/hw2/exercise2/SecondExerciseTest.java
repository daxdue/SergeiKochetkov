package ru.training.at.hw2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.BasePageTest;

import java.util.concurrent.TimeUnit;

public class SecondExerciseTest extends BasePageTest {
    /**
     * Assert opening Different Elements Page via Service sidebar item clicking.
     */
    @Test(priority = 3)
    public void openDifferentElementPageTest() {
        WebElement serviceTab = webDriver.findElement(
                By.xpath("//a[contains(text(), 'Service')]"));
        serviceTab.click();
        WebElement diffElementsPageButton = webDriver.findElement(
                By.xpath("//a[contains(text(), 'Different elements')]"));
        diffElementsPageButton.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(webDriver.getTitle(), "Different Elements");
    }

    /**
     * Assert select checkboxes and log rows for the checkboxes.
     */
    @Test(priority = 4)
    public void selectCheckboxesTest() {
        WebElement waterCheckBox = webDriver.findElement(By.cssSelector(
                "label.label-checkbox:nth-child(1) > input"));
        waterCheckBox.click();
        Assert.assertTrue(waterCheckBox.isSelected());
        WebElement windCheckBox = webDriver.findElement(By.cssSelector(
                "label.label-checkbox:nth-child(3) > input"
        ));
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
        WebElement selenRadio = webDriver.findElement(By.cssSelector(
                "label.label-radio:nth-child(4) > input"
        ));
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
        WebElement yellowColorItem = webDriver.findElement(
                By.xpath("//option[contains(text(), 'Yellow')]"));
        yellowColorItem.click();
        Assert.assertTrue(yellowColorItem.isSelected());
        WebElement colorLog = webDriver.findElement(By.xpath("//li[contains(text(), "
                + "'Colors')]"));
        Assert.assertTrue(colorLog.getText().contains("Colors: value changed to Yellow"));
    }
}
