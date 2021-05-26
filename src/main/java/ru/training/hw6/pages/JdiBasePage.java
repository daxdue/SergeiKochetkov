package ru.training.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class JdiBasePage extends WebPage {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8")
    public static Menu headerMenu;

    @FindBy(id = "user-icon")
    public Icon loginIcon;

    @FindBy(id = "user-name")
    public Text loggedInUserName;

    public String getLoggedUserName() {
        return loggedInUserName.getValue();
    }

    public void clickHeaderElement(int element) {
        headerMenu.get(element).click();
    }
}
