package ru.training.hw6.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import ru.training.hw6.utils.ResultSectionItems;

import java.util.List;

public class ResultSection {

    @FindBy(css = "ul.results > li")
    private List<Label> resultItems;

    public String getItemValue(ResultSectionItems element) {
        return resultItems.get(element.getPosition()).getValue();
    }
}
