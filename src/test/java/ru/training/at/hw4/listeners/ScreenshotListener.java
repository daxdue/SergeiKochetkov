package ru.training.at.hw4.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.hw4.attachments.Attachments;
import ru.training.hw4.utils.BrowserManager;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BrowserManager.getChromeDriver();
        Attachments.attachScreenshot(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES), driver.toString());
    }
}
