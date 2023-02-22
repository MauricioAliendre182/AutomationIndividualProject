package ui.admin.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class DetailsPage extends BaseAdminPage {

    @FindBy(name = "quantity")
    WebElement inputQuantity;

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(text(), 'Continue Shopping')]")
    WebElement continueShoppingButton;

    public DetailsPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        inputQuantity = wait.until(ExpectedConditions.elementToBeClickable(inputQuantity));
        addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }

    private void configureTheQuantity(String quantity) {
        inputQuantity.click();
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    private void addToCart() {
        addToCartButton.click();
        continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }
}
