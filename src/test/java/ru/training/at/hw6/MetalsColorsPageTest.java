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
        WebDriverFactory.useDriver(() -> BrowserManager.getChromeDriver());
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
                containsString(getElementsAsString(metalsColorsFormData.getElements())));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.COLOR),
                containsString(metalsColorsFormData.getColor()));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.METAL),
                containsString(metalsColorsFormData.getMetals()));
        assertThat(jdiMetalsColorsPage.resultSection.getItemValue(ResultSectionItems.VEGETABLES),
                containsString(getVegetablesAsString(metalsColorsFormData.getVegetables())));
    }


    private String getElementsAsString(List<String> elements) {
        String elementsString = new String();
        for (int i = 0; i < elements.size() - 1; i++) {
            elementsString.concat(elements.get(i)).concat(", ");
        }
        elementsString.concat(elements.get(elements.size() - 1));
        return elementsString;
    }

    private String getVegetablesAsString(List<String> vegetables) {
        String vegetablesString = new String();
        for (int i = 0; i < vegetables.size() - 1; i++) {
            vegetablesString.concat(vegetables.get(i)).concat(", ");
        }
        vegetablesString.concat(vegetables.get(vegetables.size() - 1));
        return vegetablesString;
    }
}