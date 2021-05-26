package ru.training.hw6.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class ResultSection {

    @FindBy(css = "li.summ-res")
    public Label summaryRes;

    @FindBy(css = "li.col-res")
    private Label colorRes;

    @FindBy(css = "li.met-res")
    private Label metalRes;

    @FindBy(css = "li.sal-res")
    private Label vegetablesRes;

    public String getSummaryRes() {
        return summaryRes.getValue();
    }

    public String getColorRes() {
        return colorRes.getValue();
    }

    public String getMetalRes() {
        return metalRes.getValue();
    }

    public String getVegetablesRes() {
        return vegetablesRes.getValue();
    }
}
