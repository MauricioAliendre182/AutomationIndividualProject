package ui.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;

import java.util.List;

public class CategoryPage extends BaseAdminPage {
    @FindBy(xpath = "//div[@class='features_items']")
    WebElement sectionProducts;
    public CategoryPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        sectionProducts = wait.until(ExpectedConditions.visibilityOf(sectionProducts));
    }

    public Integer quantityProducts() {
        List<WebElement> titleProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        return titleProducts.size();
    }

    public boolean isOnTheCorrectCategory(String category, String subcategory) {
        String path = String.format("//h2[contains(text(), '%1$s - %2$s')]", category, subcategory);
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return title.isDisplayed();
    }




}
