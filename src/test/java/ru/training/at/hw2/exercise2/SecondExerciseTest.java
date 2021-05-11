package ru.training.at.hw2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.BasePageTest;

import java.util.concurrent.TimeUnit;

public class SecondExerciseTest extends BasePageTest {
    private static final String LABEL_CHECKBOX = "label-checkbox";
    private static final String LABEL_RADIO = "label-radio";
    private static final String LIST_ITEM_XPATH_PATTERN = "//li[contains(text(),'%s')]";
    private static final String INPUT_ITEM_XPATH_PATTERN = "//label[@class='%s' "
            + "and contains(., '%s')]/input";

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
        WebElement waterCheckBox = findInputElement(LABEL_CHECKBOX, "Water");
        waterCheckBox.click();
        Assert.assertTrue(waterCheckBox.isSelected());
        WebElement windCheckBox = findInputElement(LABEL_CHECKBOX, "Wind");
        windCheckBox.click();
        Assert.assertTrue(windCheckBox.isSelected());

        WebElement waterCheckboxLog = findListItem("Water");
        Assert.assertTrue(waterCheckboxLog.getText().contains("Water: condition changed to true"));
        WebElement windCheckboxLog = findListItem("Wind");
        Assert.assertTrue(windCheckboxLog.getText().contains("Wind: condition changed to true"));

    }

    /**
     * Assert select radio button and log row for the radio button.
     */
    @Test(priority = 5)
    public void selectRadioTest() {
        WebElement selenRadio = findInputElement(LABEL_RADIO, "Selen");
        selenRadio.click();
        Assert.assertTrue(selenRadio.isSelected());
        WebElement selenRadioLog = findListItem("metal");
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
        WebElement colorLog = findListItem("Colors");
        Assert.assertTrue(colorLog.getText().contains("Colors: value changed to Yellow"));
    }

    private WebElement findInputElement(String elementClass, String textToFind) {
        return webDriver.findElement(By.xpath(String.format(INPUT_ITEM_XPATH_PATTERN,
                elementClass, textToFind)));
    }

    private WebElement findListItem(String textToFind) {
        return webDriver.findElement(By.xpath(String.format(LIST_ITEM_XPATH_PATTERN,
                textToFind)));
    }

}
