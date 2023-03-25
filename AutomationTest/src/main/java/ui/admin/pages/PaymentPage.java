package ui.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.admin.BaseAdminPage;
import java.util.List;

public class PaymentPage extends BaseAdminPage {

    @FindAll({
            @FindBy(name = "name_on_card"),
            @FindBy(name = "card_number"),
            @FindBy(name = "cvc"),
            @FindBy(name = "expiry_month"),
            @FindBy(name = "expiry_year")
    }
    )
    private List<WebElement> formPayment;
    private static final int CARDFIELD = 0;
    private static final int NUMBERFIELD = 1;
    private static final int CVCFIELD = 2;
    private static final int MONTHFIELD = 3;
    private static final int EXPIRYFIELD = 4;

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        formPayment = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("payment-form")));
    }

    public PaymentDonePage fillTheFormQuickText(String quickText) {
        formPayment.forEach((p) -> {
            p.click();
            p.clear();
            p.sendKeys(quickText);
        });
        try {
            WebElement buttonXpath = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            buttonXpath.submit();
        } catch (org.openqa.selenium.StaleElementReferenceException ex){
            WebElement buttonXpath = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            buttonXpath.submit();
        }

        return new PaymentDonePage();
    }

    public PaymentDonePage fillTheForm(String cardName, String cardNumber, String cvc, String month, String year) {
        formPayment.get(CARDFIELD).click();
        formPayment.get(CARDFIELD).clear();
        formPayment.get(CARDFIELD).sendKeys(cardName);
        formPayment.get(NUMBERFIELD).click();
        formPayment.get(NUMBERFIELD).clear();
        formPayment.get(NUMBERFIELD).sendKeys(cardNumber);
        formPayment.get(CVCFIELD).click();
        formPayment.get(CVCFIELD).clear();
        formPayment.get(CVCFIELD).sendKeys(cvc);
        formPayment.get(MONTHFIELD).click();
        formPayment.get(MONTHFIELD).clear();
        formPayment.get(MONTHFIELD).sendKeys(month);
        formPayment.get(EXPIRYFIELD).click();
        formPayment.get(EXPIRYFIELD).clear();
        formPayment.get(EXPIRYFIELD).sendKeys(year);
        try {
            WebElement buttonXpath = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            buttonXpath.submit();
        } catch (org.openqa.selenium.StaleElementReferenceException ex){
            WebElement buttonXpath = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            buttonXpath.submit();
        }
        return new PaymentDonePage();
    }

}
