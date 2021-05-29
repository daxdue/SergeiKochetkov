package ru.training.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.hw6.entities.User;
import ru.training.hw6.pages.JdiBasePage;
import ru.training.hw6.pages.JdiMetalsColorsPage;
import ru.training.hw6.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiBasePage jdiBasePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    public static LoginForm loginForm;

    public static void open() {
        jdiBasePage.open();
    }

    public static void loginUser(String username, String password) {
        jdiBasePage.loginIcon.click();
        loginForm.loginAs(new User(username, password));
    }
}
