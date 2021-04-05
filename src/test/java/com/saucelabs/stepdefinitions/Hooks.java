package com.saucelabs.stepdefinitions;

import com.saucelabs.base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void start(){
        BasePage.initializeDriver();
    }

    @After
    public void end(){
        BasePage.tearDown();
    }
}
