package ru.training.hw6.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import lombok.Getter;
import ru.training.hw6.sections.MetalsColorsForm;
import ru.training.hw6.sections.ResultSection;

public class JdiMetalsColorsPage extends JdiBasePage {

    @FindBy(css = "form.form")
    @Getter
    public MetalsColorsForm metalsColorsForm;

    @FindBy(xpath = "div.info-panel-section")
    public ResultSection resultSection;
}
