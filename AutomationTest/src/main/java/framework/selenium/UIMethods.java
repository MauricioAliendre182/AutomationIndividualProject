package framework.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import utils.LoggerManager;

public class UIMethods {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static final Wait<WebDriver> wait = DriverManager.getInstance().getFluentWait();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void moveToWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollWindow(Integer scrollPixel) {
        js.executeScript("window.scrollBy(0,arguments[0]);", scrollPixel);
    }

    public static boolean isWebElementNotPresentByXpath(String xpathLocator) {
        return (Boolean) js.executeScript("""
                return isWebElementNotPresentByXpath(arguments[0]) == null;
                function isWebElementNotPresentByXpath(path) {
                return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                }""", xpathLocator);
    }
}
