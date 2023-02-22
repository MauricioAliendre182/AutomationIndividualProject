package ui.admin.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class CheckoutPage extends BaseAdminPage {
    @FindBy(xpath = "//h2[text()='Address Details']")
    WebElement addressDetails;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        addressDetails = wait.until(ExpectedConditions.visibilityOf(addressDetails));
    }
}
