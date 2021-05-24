package ru.training.hw6.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import java.util.List;

public class ResultSection {

    @FindBy(xpath = "//li[@class='summ-res']")
    protected static Label summaryRes;

    @FindBy(xpath = "//li[@class='col-res']")
    private static Label colorRes;

    @FindBy(xpath = "//li[@class='met-res']")
    private static Label metalRes;

    @FindBy(xpath = "//li[@class='sal-res']")
    private static Label vegetablesRes;

    public boolean verifySummaryRes(int required) {
        return summaryRes.getValue().contains(String.valueOf(required));
    }

    public boolean verifyColorRes(String required) {
        return colorRes.getValue().contains(required);
    }

    public boolean verifyMetalRes(String required) {
        return metalRes.getValue().contains(required);
    }

    public boolean verifyVegetables(List<String> required) {
        for (String vegetable : required) {
            if (!vegetablesRes.getValue().contains(vegetable)) {
                return false;
            }
        }
        return true;
    }
}
