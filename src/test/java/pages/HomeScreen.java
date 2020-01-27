package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends BaseScreenIOS {

    public HomeScreen(IOSDriver driver) {
        PageFactory.initElements(driver, this);
        this._driver = driver;
    }

    public Boolean check_app_title() {
        return GetMobileApplicationName().contains("Rates");
    }

    public Boolean check_screen_title() {
        MobileElement element = GetMobileElementByXPATH("//XCUIElementTypeNavigationBar[@name=\"Rates\"]/XCUIElementTypeOther[@name=\"Rates\"]", false);
        return element.isEnabled() && element.isDisplayed() && element.getAttribute("label").contains("Rates");
    }

    public Boolean check_navigationbar() {
        MobileElement navBar = GetMobileElementByClassName("XCUIElementTypeNavigationBar");
        Boolean checkNavBarTitle = navBar.getAttribute("name").contains("Rates");
        Boolean checkNavBarVisible = navBar.isEnabled() && navBar.isDisplayed();
        return  checkNavBarTitle && checkNavBarVisible;
    }

    public Boolean check_USD_button() {
        MobileElement button = GetMobileElementByXPATH("//XCUIElementTypeButton[@name=\"USD\"]", false);
        return button.isEnabled() && button.isDisplayed();
    }

    public Boolean check_Add_button() {
        MobileElement button = GetMobileElementByXPATH("//XCUIElementTypeButton[@name=\"Add\"]", false);
        return button.isEnabled() && button.isDisplayed();
    }

    public void tap_add_button() {
        MobileElement button = GetMobileElementByXPATH("//XCUIElementTypeButton[@name=\"Add\"]", false);
        button.click();
    }

}
