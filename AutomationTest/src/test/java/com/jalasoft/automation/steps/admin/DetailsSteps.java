package com.jalasoft.automation.steps.admin;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.CartPage;
import ui.admin.pages.ContentPage;
import ui.admin.pages.DetailsPage;

public class DetailsSteps {
    public Boolean negativeState;

    private final PageTransporter pageTransporter;
    private final ContentPage contentPage;

    private DetailsPage detailsPage;
    public CartPage cartPage;


    public DetailsSteps(ContentPage contentPage){
        this.contentPage = contentPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Then("^I go to details product with \"(.*?)\" as identifier and scroll down \"(.*?)\"$")
    public void goToProductDetailsSection(String id, String scroll) {
        detailsPage = contentPage.goToDetailsPage(id, Integer.valueOf(scroll));
        Assert.assertTrue(detailsPage.IsQuantityLabelPresent(), "user is not on the product details");
    }

    @Then("^I go to add the product to cart from product details section$")
    public void addToCartFromProductDetails() {
        if (pageTransporter.isOnDetailsPage()){
            detailsPage.addToCart();
        }
    }

    @Then("^I set the number \"([0-9]|-[0-9])\" in quantity part from details product$")
    public void setNumberInQuantity(String quantity) {
        detailsPage.configureTheQuantity(quantity);
        detailsPage.addToCart();
        cartPage = detailsPage.goToCartSection();
        negativeState = cartPage.isNegativeNumber();
    }

    @Then("^I go to check if the product had a negative number in quantity$")
    public void isANegativeNumberPresent() {
        Assert.assertFalse(negativeState);
    }
}
