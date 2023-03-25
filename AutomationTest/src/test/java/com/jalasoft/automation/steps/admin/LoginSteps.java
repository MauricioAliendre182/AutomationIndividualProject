package com.jalasoft.automation.steps.admin;

import io.cucumber.java.en.Given;
import ui.PageTransporter;
import ui.admin.pages.LoginPage;

public class LoginSteps {

    private final PageTransporter pageTransporter;
    private LoginPage loginPage;

    public LoginSteps() {
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I am logged in to automation exercise page$")
    public void navigateToAdminLoginPage() {
        loginPage = pageTransporter.navigateToAdminLoginPage();
        loginPage.loginWithUser();
    }
}
