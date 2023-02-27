package ui;

import framework.CredentialsManager;
import framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.admin.pages.LoginPage;
import utils.LoggerManager;

public class PageTransporter {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final CredentialsManager credentialsManager = CredentialsManager.getInstance();

    private WebDriver driver;
    private String loginURL;
    private String productURL;
    private String cartURL;

    private String brandURL;
    private String categoryURL;
    private String detailsURL;
    private String checkoutURL;
    private String paymentURL;
    private String paymentDoneURL;
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        log.info("Initializing Page Transporter");
        loginURL = credentialsManager.getLoginURL();
        productURL = credentialsManager.getProductsURL();
        cartURL = credentialsManager.getCartURL();
        brandURL = credentialsManager.getBrandURL();
        categoryURL = credentialsManager.getCategoryURL();
        detailsURL = credentialsManager.getDetailsURL();
        checkoutURL = credentialsManager.getCheckoutURL();
        paymentURL = credentialsManager.getPaymentURL();
        paymentDoneURL = credentialsManager.getPaymentDoneURL();
        driver = DriverManager.getInstance().getWebDriver();
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains(loginURL);
    }

    public boolean isOnProductPage() {
        return driver.getCurrentUrl().contains(productURL);
    }

    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains(cartURL);
    }

    public boolean isOnCategoryPage() {
        return driver.getCurrentUrl().contains(categoryURL);
    }

    public boolean isOnDetailsPage() {
        return driver.getCurrentUrl().startsWith(detailsURL);
    }

    public boolean isOnBrandPage() {
        return driver.getCurrentUrl().contains(brandURL);
    }

    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains(checkoutURL);
    }

    public boolean isOnPaymentPage() {
        return driver.getCurrentUrl().contains(paymentURL);
    }

    public boolean isOnPaymentDonePage() {
        return driver.getCurrentUrl().contains(paymentDoneURL);
    }

    public LoginPage navigateToAdminLoginPage() {
        if (!isOnLoginPage()) {
            goToURL(loginURL);
        }
        return new LoginPage();
    }
}
