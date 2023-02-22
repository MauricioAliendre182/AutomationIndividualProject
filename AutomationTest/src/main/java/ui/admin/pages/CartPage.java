package ui.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class CartPage extends BaseAdminPage {
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        checkoutButton = wait.until(ExpectedConditions.visibilityOf(checkoutButton));
    }

    public void clickOnQuantityButton(String idProduct) {
        String quantityPath = String.format("//button[@class='disabled'][%s]",idProduct);
        WebElement quantityButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(quantityPath)));
        quantityButton.click();
    }

    public void clickOnDeleteProduct(String idProduct) {
        String deletePath = String.format("//a[@class='cart_quantity_delete'][%s]",idProduct);
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deletePath)));
        deleteButton.click();
    }

    public DetailsPage clickOnDetailsProduct (String idProduct) {
        String detailsPath = String.format("//a[contains(@href,'/product_details/%s')]",idProduct);
        WebElement detailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(detailsPath)));
        detailsButton.click();
        return new DetailsPage();
    }

    public CheckoutPage clickOnProceedCheckout() {
        checkoutButton.click();
        return new CheckoutPage();
    }
}
