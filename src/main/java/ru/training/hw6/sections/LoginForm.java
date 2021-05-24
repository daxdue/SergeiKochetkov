package ru.training.hw6.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.hw6.entities.User;

public class LoginForm extends Form<User> {
    @FindBy(id = "name")
    private static TextField username;

    @FindBy(id = "password")
    private static TextField password;

    @FindBy(id = "login-button")
    private static Button submit;
}
