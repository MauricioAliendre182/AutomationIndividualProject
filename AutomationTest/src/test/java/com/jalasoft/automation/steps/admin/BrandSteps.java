package com.jalasoft.automation.steps.admin;

import framework.selenium.UIMethods;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.BrandPage;
import ui.admin.pages.CategoryPage;
import ui.admin.pages.ContentPage;

public class BrandSteps {
    private final PageTransporter pageTransporter;
    private final ContentPage contentPage;
    private BrandPage brandPage;

    public BrandSteps(ContentPage contentPage) {
        this.contentPage = contentPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Then("^I go to brand section and select the brand \"(.*?)\" as identifier and scroll down \"(.*?)\"$")
    public void verifyIfTheBrandCanBeSelected (String brand, String scroll) {
        brandPage = contentPage.goToBrandPage(brand, Integer.parseInt(scroll));
    }

    @Then("^I go to check if the products belong to the brand \"(.*?)\" and the section \"(.*?)\"$")
    public void verifyIfTheUserIsOnTheCorrectPage(String brand, String section) {
        Assert.assertTrue(brandPage.IsOnTheCorrectBrand(section, brand), "user is not in the brand section");
    }
}
