package com.jalasoft.automation.steps.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.*;

public class CartSteps {
    private final PageTransporter pageTransporter;
    private final HomeAdminPage homeAdminPage;
    private CartPage cartPage;
    private DetailsPage detailsPage;

    private CheckoutPage checkoutPage;


    public CartSteps(HomeAdminPage homeAdminPage) {
        this.homeAdminPage = homeAdminPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Then("^I go to cart page using the top menu$")
    public void gotToProductsPageUsingMenu() {
        cartPage = homeAdminPage.topBarMenu.cartPage();
    }

    @Then("^I go to details product from the product with \"([0-9]*)\" as identifier$")
    public void goToDetailsProduct(String idProduct) {
        detailsPage = cartPage.clickOnDetailsProduct(idProduct);
        Assert.assertTrue(detailsPage.IsQuantityLabelPresent());
    }

    @Then("^I go to remove a product from cart with \"([0-9]*)\" as identifier$")
    public void goToRemoveAProduct(String idProduct) {
        cartPage.clickOnDeleteProduct(idProduct);
    }

    @Then("^I go to check if the product is not present anymore$")
    public void isTheProductPresent() {
        Assert.assertTrue(cartPage.isTheProductPresent(), "The product is still present");
    }

    @Then("^I go to checkout section$")
    public void goToCheckOutSection() {
        checkoutPage = cartPage.clickOnProceedCheckout();
    }


}
