package ui.admin.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class PaymentDonePage extends BaseAdminPage {

    @FindBy(xpath = "//b[text()='Order Placed!']")
    WebElement orderPlaced;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        orderPlaced = wait.until(ExpectedConditions.visibilityOf(orderPlaced));
    }
}
