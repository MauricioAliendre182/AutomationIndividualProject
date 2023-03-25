package ui.admin.pages;

import framework.CredentialsManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import utils.LoggerManager;

public class LoginPage extends BasePageObject {
    private static final LoggerManager log = LoggerManager.getInstance();

    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//form[@action='/login']/input[@name='password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//form[@action='/login']/button")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(emailTextBox));
        passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public void setEmailTextBox(String userName) {
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password) {
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.submit();
    }

    public HomeAdminPage loginWithUser() {
        setEmailTextBox(CredentialsManager.getInstance().getEmail());
        setPasswordTextBox(CredentialsManager.getInstance().getPassword());
        clickLoginButton();
        return new HomeAdminPage();
    }
}
