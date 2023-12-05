package org.tests.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.base.BasePage;
import org.swaglabs.pages.base.LoginPage;
import org.swaglabs.pages.home.HomePage;
import org.swaglabs.pages.listing.HomeListingPage;
import org.swaglabs.setup.CommonActions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTests {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected HomeListingPage homeListingPage = new HomeListingPage(driver);

    public static final String PLATFORM_AND_BROWSER = "win_chrome";
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
    public static final Boolean HOLD_BROWSER_OPEN = true;

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
