package ui.admin.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

public class ContentPage extends BaseAdminPage {

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement titleSection;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    public ContentPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        titleSection = wait.until(ExpectedConditions.visibilityOf(titleSection));
    }

    public DetailsPage goToDetailsPage(String idProduct, Integer scroll) {
        UIMethods.scrollWindow(scroll);
        String detailsPath = String.format("//a[@href='/product_details/%s']", idProduct);
        WebElement detailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(detailsPath)));
        detailsButton.click();
        return new DetailsPage();
    }

    public void addToCart(String idProduct, Integer scroll) {
        UIMethods.scrollWindow(scroll);
        String cartPath = String.format("//a[@data-product-id='%s']", idProduct);
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cartPath)));
        addToCartButton.click();
        continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public BrandPage goToBrandPage(String brand, Integer scroll) {
        UIMethods.scrollWindow(scroll);
        String selectBrand = String.format("//a[@href='/brand_products/%s']", brand);
        WebElement brandButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectBrand)));
        brandButton.click();
        return new BrandPage();
    }

    public CategoryPage goToCategoryPage(String category, String subcategory, Integer hover) {
        UIMethods.scrollWindow(hover);
        String selectMainCategory = String.format("//a[contains(@href, '%s')]", category);
        String selectSubCategory = String.format("//a[contains(text(), '%s')]", subcategory);
        WebElement mainCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectMainCategory)));
        mainCategory.click();
        WebElement subCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectSubCategory)));
        subCategory.click();
        return new CategoryPage();
    }

    public boolean isOnProductsSection() {
        return titleSection.isDisplayed();
    }


}
