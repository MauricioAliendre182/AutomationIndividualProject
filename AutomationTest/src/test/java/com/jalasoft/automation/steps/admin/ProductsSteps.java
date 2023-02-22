package com.jalasoft.automation.steps.admin;

import framework.selenium.UIMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.testng.Assert;
import ui.admin.components.AdButton;
import ui.admin.pages.ContentPage;
import ui.admin.pages.HomeAdminPage;


public class ProductsSteps {
    private final HomeAdminPage homeAdminPage;
    private ContentPage contentPage;

    public ProductsSteps(HomeAdminPage homeAdminPage) {
        this.homeAdminPage = homeAdminPage;
    }

    @Given("^I go to Products page using the top menu$")
    public void gotToPostsPageUsingMenu() {
        contentPage = homeAdminPage.topBarMenu.contentPage();
    }

    @Then("^I go to add a product to the cart with \"(.*?)\" as identifier and scroll down \"(.*?)\"$")
    public void verifyIfPostWasPublished(String id, String scroll) {
        contentPage.addToCart(id, Integer.valueOf(scroll));
        UIMethods.scrollWindow((-Integer.parseInt(scroll)));
        Assert.assertTrue(contentPage.IsOnProductsSection(), "user is not in the products section");
    }

}
