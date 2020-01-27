package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseScreenIOS {

    protected IOSDriver _driver;

    protected enum Direction{
        up,
        down,
        left,
        right
    }

    protected enum AlertAction{
        accept,
        dismiss
    }

    protected void sleep(Integer seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String GetMobileApplicationName() {
        MobileElement applicationElement = (MobileElement) _driver.findElementByClassName("XCUIElementTypeApplication");
        return applicationElement.getAttribute("name");
    }

    protected String GetAttributeValue(MobileElement element) {
        return element.getAttribute("value");
    }

    protected MobileElement GetMobileElementByAccessibilityId(String id, boolean isAwaited) {
        if(isAwaited){
            return (MobileElement) new WebDriverWait(_driver, 30).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(id)));
        }
        return (MobileElement) _driver.findElementByAccessibilityId(id);
    }

    protected MobileElement GetMobileElementByXPATH(String xpath, boolean isAwaited) {
        if(isAwaited){
            return (MobileElement) new WebDriverWait(_driver, 30).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xpath)));
        }
        return (MobileElement) _driver.findElementByXPath(xpath);
    }

    protected MobileElement GetMobileElementByClassName(String className) {
        return (MobileElement) _driver.findElementByClassName(className);
    }

    protected MobileElement GetMobileElementByNSPredicateString(String predicate, boolean isAwaited) {
        if(isAwaited){
            return (MobileElement) new WebDriverWait(_driver, 30).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString(predicate)));
        }
        return (MobileElement) _driver.findElementByIosNsPredicate(predicate);
    }

    protected MobileElement GetMobileElementByClassChain(String chain, boolean isAwaited) {
        if(isAwaited){
            return (MobileElement) new WebDriverWait(_driver, 30).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSClassChain(chain)));
        }
        return (MobileElement) _driver.findElementByIosClassChain(chain);
    }

    protected void SetLocation(double latitude, double longitude, double altitude) {
        _driver.setLocation(new org.openqa.selenium.html5.Location(49, 123, 10));
    }

    protected void Swipe(WebElement element, Direction direction) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction.toString());
        params.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: swipe", params);
    }

    protected void Swipe(Direction direction) {
        MobileElement element = (MobileElement) _driver.findElementByClassName("XCUIElementTypeApplication");
        Swipe(element, direction);
    }

    protected void Scroll(WebElement element, Direction direction) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction.toString());
        params.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", params);
    }

    protected void Scroll(Direction direction) {
        MobileElement element = (MobileElement) _driver.findElementByClassName("XCUIElementTypeApplication");
        Scroll(element, direction);
    }

    private void Zoom(WebElement element, Boolean zoomIn) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("scale", zoomIn ? "0.5" : "1.5");
        params.put("velocity", 1.0f);
        js.executeScript("mobile: pinch", params);
    }

    protected void ZoomIn(WebElement element) {Zoom(element, true);}
    protected void ZoomOut(WebElement element) {Zoom(element, false);}

    protected void ZoomIn() {
        MobileElement element = (MobileElement) _driver.findElementByClassName("XCUIElementTypeApplication");
        Zoom(element, true);
    }

    protected void ZoomOut() {
        MobileElement element = (MobileElement) _driver.findElementByClassName("XCUIElementTypeApplication");
        Zoom(element, false);
    }

    protected void LongTap(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("duration", 2.0f);
        js.executeScript("mobile: touchAndHold", params);
    }

    protected void AcceptAlert(String buttonText, AlertAction action) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        Map<String, Object> params = new HashMap<>();
        params.put("action", action.toString());
        params.put("buttonLabel", buttonText);
        js.executeScript("mobile: alert", params);
    }
}
