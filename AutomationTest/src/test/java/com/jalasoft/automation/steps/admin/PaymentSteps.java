package com.jalasoft.automation.steps.admin;

import framework.selenium.UIMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.testng.Assert;
import ui.PageTransporter;
import ui.admin.pages.CheckoutPage;
import ui.admin.pages.PaymentDonePage;
import ui.admin.pages.PaymentPage;

public class PaymentSteps {
    private final PageTransporter pageTransporter;

    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    private PaymentDonePage paymentDonePage;


    public PaymentSteps(CheckoutPage checkoutPage) {
        this.checkoutPage = checkoutPage;
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Then("^I scroll down \"(.*?)\" and go to payment page$")
    public void goToCheckOutSection(String scroll) {
        paymentPage = checkoutPage.goToPaymentPage(Integer.valueOf(scroll));
    }

    @Then("^I fill every field with the same data which is \"(.*?)\"$")
    public void fillTheFormSameData(String data) {
        paymentPage.fillTheFormQuickText(data);
    }

    @Then("^I go to check that the payment can not be process$")
    public void checkThatThePaymentCanNotBeProcess(){
        String formXpath = "//form[@action='/payment']";
        Assert.assertFalse(UIMethods.isWebElementNotPresentByXpath(formXpath));
    }

    @Then("^I fill every field with the with \"([A-Z][a-z]* [A-Z][a-z]*)\" as name, \"([0-9]*)\" as card, \"([0-9]*)\" as cvc, \"([0-9]*)\" as month, \"([0-9]*)\" as year$")
    public void fillTheFormWithCorrectInformation(String cardName, String cardNumber, String cvc, String month, String year){
        paymentPage.fillTheForm(cardName, cardNumber, cvc, month, year);
    }

    @Then("^I go to check that the payment can be process$")
    public void checkThatThePaymentCanBeProcess() {
        String formXpath = "//form[@action='/payment']";
        Assert.assertTrue(UIMethods.isWebElementNotPresentByXpath(formXpath));
    }
}
