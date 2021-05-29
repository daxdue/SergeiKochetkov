package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.dataprovider.DataSource;
import ru.training.at.hw6.dataprovider.MetalsColorsFormDataProviders;
import ru.training.hw5.utils.BrowserManager;
import ru.training.hw6.JdiSite;
import ru.training.hw6.entities.MetalsColorsFormData;
import ru.training.hw6.utils.HeaderElements;
import ru.training.hw6.utils.ResultSectionItems;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static ru.training.hw6.JdiSite.jdiBasePage;
import static ru.training.hw6.JdiSite.jdiMetalsColorsPage;

public class MetalsColorsPageTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverFactory.useDriver(BrowserManager::getChromeDriver);
        WebDriverFactory.reopenDriver();
        PageFactory.initSite(JdiSite.class);
        JdiSite.open();
    }

    @AfterMethod(alwaysRun = true)
    public void setDown() {
        BrowserManager.close();
    }

    @Test(dataProvider = MetalsColorsFormDataProviders.JSON_DATA_PROVIDER,
        dataProviderClass = DataSource.class)
    public void metalsColorsPageFeaturesTest(MetalsColorsFormData metalsColorsFormData) {

        JdiSite.loginUser("Roman", "Jdi1234");
        assertThat(jdiBasePage.getLoggedUserName(), equalTo("ROMAN IOVLEV"));

        jdiBasePage.clickHeaderElement(HeaderElements.METALS_AND_COLORS.getPosition());
        jdiMetalsColorsPage.checkOpened();
        jdiMetalsColorsPage.metalsColorsForm.submit(metalsColorsFormData);

        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.SUMMARY),
                containsString(String.valueOf(metalsColorsFormData.getSummary().get(0)
                    + metalsColorsFormData.getSummary().get(1))));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.ELEMENTS),
                containsString(getItemsAsString(metalsColorsFormData.getElements())));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.COLOR),
                containsString(metalsColorsFormData.getColor()));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.METAL),
                containsString(metalsColorsFormData.getMetals()));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.VEGETABLES),
                containsString(getItemsAsString(metalsColorsFormData.getVegetables())));
    }

    private String getItemsAsString(List<String> items) {
        String itemsString = "";
        for (int i = 0; i < items.size() - 1; i++) {
            itemsString.concat(items.get(i).concat(", "));
        }
        itemsString.concat(items.get(items.size() - 1));
        return itemsString;
    }
}
