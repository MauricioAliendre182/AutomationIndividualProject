package ui.admin.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class CheckoutPage extends BaseAdminPage {
    @FindBy(xpath = "//h2[text()='Address Details']")
    WebElement addressDetails;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        addressDetails = wait.until(ExpectedConditions.visibilityOf(addressDetails));
        placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
    }

    public PaymentPage goToPaymentPage(Integer scroll) {
        UIMethods.scrollWindow(scroll);
        placeOrderButton.click();
        return new PaymentPage();
    }
}
