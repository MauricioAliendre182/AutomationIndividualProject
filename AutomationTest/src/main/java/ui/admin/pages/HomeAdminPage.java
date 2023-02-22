package ui.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;
import utils.LoggerManager;

public class HomeAdminPage extends BaseAdminPage {
    private static final LoggerManager log = LoggerManager.getInstance();

    @FindBy(xpath = "//span[text()='Automation']")
    WebElement mainTitle;

    public HomeAdminPage() {
        log.info("Initialize the home page");
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        mainTitle = wait.until(ExpectedConditions.visibilityOf(mainTitle));
    }
}
