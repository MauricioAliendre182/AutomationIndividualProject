package ui.admin.components;

import framework.selenium.UIMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.admin.pages.CartPage;
import ui.admin.pages.ContentPage;
import ui.admin.pages.HomeAdminPage;
import ui.admin.pages.LoginPage;

public class TopBarMenu extends BasePageObject {

    private String adPath = "//div[@id='ad_position_box']";

    @FindBy(xpath = "//div[@class='row']//a[text()=' Home']")
    WebElement homeButton;

    @FindBy(xpath = "//div[@class='row']//a[text()=' Products']")
    WebElement contentButton;

    @FindBy(xpath = "//div[@class='row']//a[text()=' Cart']")
    WebElement cartButton;

//    @FindBy(xpath = "//div[@class='row']//a[text()=' Signup / Login']")
//    WebElement loginButton;

    @FindBy(xpath = "//div[@class='row']//a[text()=' Logout']")
    WebElement logoutButton;

    public TopBarMenu() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        homeButton = wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        contentButton = wait.until(ExpectedConditions.elementToBeClickable(contentButton));
        cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
    }

    private void clickHomeButton() {
        homeButton.click();
    }

    private void clickCartButton() {
        cartButton.click();
    }

    private void clickContentButton() {
        contentButton.click();
    }

    public void clickLogoutButton() {
        logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public LoginPage logout() {
        UIMethods.moveToWebElement(logoutButton);
        clickLogoutButton();
        return new LoginPage();
    }

    public ContentPage contentPage() {
        UIMethods.moveToWebElement(contentButton);
        clickContentButton();
        return new ContentPage();
    }

    public CartPage cartPage() {
        UIMethods.moveToWebElement(cartButton);
        clickCartButton();
        return new CartPage();
    }
}
