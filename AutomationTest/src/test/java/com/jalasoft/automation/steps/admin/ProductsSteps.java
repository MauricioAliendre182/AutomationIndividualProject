package com.jalasoft.automation.steps.admin;

import framework.selenium.UIMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.ContentPage;
import ui.admin.pages.HomeAdminPage;


public class ProductsSteps {
    private final PageTransporter pageTransporter;
    private final HomeAdminPage homeAdminPage;
    private ContentPage contentPage;


    public ProductsSteps(HomeAdminPage homeAdminPage) {
        this.homeAdminPage = homeAdminPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I go to Products page using the top menu$")
    public void gotToProductsPageUsingMenu() {
        contentPage = homeAdminPage.topBarMenu.contentPage();
    }

    @Then("^I go to add a product to the cart with \"(.*?)\" as identifier and scroll down \"(.*?)\"$")
    public void verifyIfProductWasAddedToCart (String id, String scroll) {
        contentPage.addToCart(id, Integer.valueOf(scroll));
        UIMethods.scrollWindow((-Integer.parseInt(scroll)));
        Assert.assertTrue(contentPage.isOnProductsSection(), "user is not in the products section");
    }

}
