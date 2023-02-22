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

    public static void clickWebElementJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void clickWebElementJs(String xpathLocator) {
        js.executeScript("""
                clickWebElementJs(arguments[0]);
                
                function clickWebElementJs(path) {
                var element =  document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                element.click()
                }
                """, xpathLocator);
    }

    public static void clickWebElementIfPresentJs(String xpathLocator) {
        js.executeScript("""
                clickWebElementIfPresent(arguments[0]);
                function clickWebElementIfPresent(path) {
                var elements = document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                if (elements.length > 0) {
                elements[0].click();
                }
                }""", xpathLocator);
    }

    public static boolean isWebElementPresentJs(String xpathLocator) {
        return (Boolean) js.executeScript("""
                return isWebElementPresent(arguments[0]);
                
                function isWebElementPresent(path) {
                var elements = document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                return elements.length > 0;
                }""", xpathLocator);
    }


    public static boolean isWebElementVisibleJs(WebElement element) {
        return (Boolean) js.executeScript("return arguments[0].checkVisibility();", element);
    }

    public static void removeWebElementFromDOMJs(String cssLocator) {
        js.executeScript("""
                removeWebElement(arguments[0]);
                function removeWebElement(cssLocator) {
                var element = document.querySelector(cssLocator);
                element.remove();
                }""", cssLocator);
    }

    public static void hideWebElementJs(String cssLocator) {
        js.executeScript("""
                hideWebElement(arguments[0]);
                function hideWebElement(cssLocator) {
                var element = document.querySelector(cssLocator);
                element.style.display = 'none';
                }""", cssLocator);
    }
}
