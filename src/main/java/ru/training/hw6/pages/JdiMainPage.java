package ru.training.hw6.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class JdiMainPage extends JdiBasePage {

    @FindBy(id = "user-name")
    public Text loggedInUserName;

}
