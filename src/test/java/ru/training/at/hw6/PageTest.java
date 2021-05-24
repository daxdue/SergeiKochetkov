package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.dataprovider.DataProviders;
import ru.training.at.hw6.dataprovider.DataSource;
import ru.training.hw6.JdiSite;
import ru.training.hw6.entities.TestData;
import ru.training.hw6.utils.HeaderElements;

public class PageTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver();
        WebDriverFactory.useDriver(() -> new ChromeDriver());
        WebDriverFactory.reopenDriver();
        PageFactory.initSite(JdiSite.class);
        JdiSite.open();
    }

    @AfterMethod(alwaysRun = true)
    public void setDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = DataProviders.JSON_DATA_PROVIDER,
        dataProviderClass = DataSource.class)
    public void performLoginTest(TestData testData) {
        JdiSite.loginUser("Roman", "Jdi1234", "ROMAN IOVLEV");
        JdiSite.jdiMainPage.clickHeaderElement(HeaderElements.METALS_AND_COLORS);
        JdiSite.jdiMetalsColorsPage.checkOpened();
        JdiSite.jdiMetalsColorsPage.fillAndSubmitForm(testData);
        JdiSite.jdiMetalsColorsPage.verifyResults(testData);
    }
}
