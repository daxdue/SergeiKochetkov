package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.hw5.utils.BrowserManager;

public class WebDriverHook {

    @Before
    public void setUp() {
        BrowserManager.getChromeDriver();
    }

    @After
    public void setDown() {
        BrowserManager.close();
    }
}
