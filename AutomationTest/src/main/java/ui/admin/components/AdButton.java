package ui.admin.components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class AdButton extends BasePageObject {
    @FindBy(xpath = "//div[@aria-label='Close ad']")
    WebElement adButton;

    public AdButton() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
    }

    public boolean isAnAdDisplayed() {
        return adButton.isDisplayed();
    }

    public void clickOnAdButton() {
        adButton = wait.until(ExpectedConditions.elementToBeClickable(adButton));
        adButton.click();
    }
}
