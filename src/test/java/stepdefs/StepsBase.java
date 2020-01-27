package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pages.CurrencyListScreen;
import pages.HomeScreen;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class StepsBase {

    private IOSDriver driver;
    HomeScreen homeScreen;
    CurrencyListScreen currencyListScreen;

    // region StepsBase
    @Before
    public void beforeScenario() throws MalformedURLException
    {
        try {

            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "../appium-ios-auto/apps");
            System.out.println("APPDIR: " + appDir);
            System.out.println("CanonicalPath: " + appDir.getCanonicalPath());
            File app = new File(appDir.getCanonicalPath(), "Rates.ipa");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("automationName", "XCUITest");
            desiredCapabilities.setCapability("udid", "32507487e3b0a86158bb5e4d3da6d861d00f6b61");
            desiredCapabilities.setCapability("deviceName", "Jatin's iPhone");
            desiredCapabilities.setCapability("app", app.getAbsolutePath());

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new IOSDriver(remoteUrl, desiredCapabilities);
        }
        catch(Exception e){
            e.printStackTrace();
//            System.exit(1);
        }
    }

    // region HOME SCREEN

     @Given("I am on Home screen")
     public void homescreen_i_am_on_homescreen() {
         homeScreen = new HomeScreen(driver);
     }

     @When("I check Home screen")
     public void homescreen_check_elements() {
         Assert.assertTrue("Home screen : App title not as expected", homeScreen.check_app_title());
     }

     @When("I click Add button")
     public void homescreen_click_add() {
         homeScreen.tap_add_button();
     }

     @Then("Home screen has all required assets")
     public void verify_home_screen(){
         Assert.assertTrue("Home screen : Screen title not as expected", homeScreen.check_screen_title());
         Assert.assertTrue("Home screen : Nav bar not as expected", homeScreen.check_navigationbar());
         Assert.assertTrue("Home screen : USD button not as expected", homeScreen.check_USD_button());
         Assert.assertTrue("Home screen : Add button not as expected", homeScreen.check_Add_button());
     }

    // endregion

    // region Currency List SCREEN

    @And("I am on Currency List screen")
    public void currency_list_screen_i_am_on_screen() {
        currencyListScreen = new CurrencyListScreen(driver);
    }

    @And("Currency List screen has all required assets")
    public void currency_list_screen_check_elements() {
        Assert.assertTrue("Currency List screen : Screen Title not as expected", currencyListScreen.check_screen_title());
        Assert.assertTrue("Currency List screen : Cancel button not as expected", currencyListScreen.check_cancel_button());
    }

    @And("I select currency {string}")
    public void currency_list_screen_select_currency(String currency) {
        currencyListScreen.check_currency_option(currency);
        currencyListScreen.select_currency_option(currency);
    }

    //endregion


    @After
    public void afterScenario(){
        driver.quit();
    }
}
