package com.jalasoft.automation.steps.admin;

import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.CategoryPage;
import ui.admin.pages.ContentPage;
import ui.admin.pages.DetailsPage;

public class CategorySteps {

    private final PageTransporter pageTransporter;
    private final ContentPage contentPage;
    private CategoryPage categoryPage;

    public CategorySteps(ContentPage contentPage) {
        this.contentPage = contentPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Then("^I go to category products and select the category \"(.*?)\" and subcategory \"(.*?)\" as identifier and scroll down \"(.*?)\"$")
    public void goToCategoryPage(String category, String subcategory, String scroll) {
        categoryPage= contentPage.goToCategoryPage(category, subcategory, Integer.valueOf(scroll));
    }

    @Then("^I go to check if the products belong to the category \"(.*?)\" and subcategory \"(.*?)\"$")
    public void checkIfProductsBelongToCategory(String category, String subcategory) {
        Assert.assertTrue(categoryPage.isOnTheCorrectCategory(category, subcategory));
    }
}
