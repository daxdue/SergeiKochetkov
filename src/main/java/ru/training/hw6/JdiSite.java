package ru.training.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import org.testng.Assert;
import ru.training.hw6.pages.JdiMainPage;
import ru.training.hw6.sections.LoginForm;
import ru.training.hw6.entities.User;
import ru.training.hw6.pages.JdiBasePage;
import ru.training.hw6.pages.JdiMetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiMainPage jdiMainPage;

    public static JdiBasePage jdiBasePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    public static void open() {
        jdiMainPage.open();
    }

    public static LoginForm loginForm;

    public static void loginUser(String username, String password, String expectedName) {
        jdiMainPage.loginIcon.click();
        loginForm.loginAs(new User(username, password));
        Assert.assertEquals(jdiMainPage.loggedInUserName.getValue(), expectedName);
    }
}
