package ui.admin.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//label[text()='Quantity:']")
    WebElement labelQuantity;

    public DetailsPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        inputQuantity = wait.until(ExpectedConditions.elementToBeClickable(inputQuantity));
        addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        labelQuantity = wait.until(ExpectedConditions.visibilityOf(labelQuantity));
    }

    public void configureTheQuantity(String quantity) {
        inputQuantity.click();
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    public void addToCart() {
        addToCartButton.click();
        continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public CartPage goToCartSection() {
        return topBarMenu.cartPage();
    }

    public boolean IsQuantityLabelPresent() {
        return labelQuantity.isDisplayed();
    }

    public boolean isAddedLabelPresent() {
        String addedText = "//h4[text()='Added!']";
        WebElement addedLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addedText)));
        return addedLabel.isDisplayed();
    }

}
