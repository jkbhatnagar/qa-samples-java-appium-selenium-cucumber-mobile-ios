package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class CurrencyListScreen extends BaseScreenIOS {

    public CurrencyListScreen(IOSDriver driver) {
        PageFactory.initElements(driver, this);
        this._driver = driver;
    }

    public Boolean check_screen_title() {
        MobileElement element = GetMobileElementByXPATH("//XCUIElementTypeOther[@name=\"Select Base Currency\"]", true);
        return element.isEnabled() && element.isDisplayed() && element.getAttribute("value").contains("Select Base Currency");
    }

    public Boolean check_cancel_button() {
        MobileElement button = GetMobileElementByXPATH("//XCUIElementTypeButton[@name=\"Cancel\"]", true);
        return button.isEnabled() && button.isDisplayed();
    }

    public Boolean check_currency_option(String currency) {
        MobileElement element = GetMobileElementByXPATH("//XCUIElementTypeStaticText[@name=\"" + currency + "\"]", true);
        return element.isEnabled() && element.isDisplayed();
    }

    public void select_currency_option(String currency) {
        MobileElement element = GetMobileElementByXPATH("//XCUIElementTypeStaticText[@name=\"" + currency + "\"]", true);
        element.click();
    }
}
