package com.jalasoft.automation.steps.hooks.admin;

import io.cucumber.java.After;
import methods.CommonMethods;
import utils.LoggerManager;

public class AdminFeatureHook {
    private static final LoggerManager log = LoggerManager.getInstance();

    @After("@AddToCart")
    public void afterLoginAdmin() {
        CommonMethods.logout();
    }
}
