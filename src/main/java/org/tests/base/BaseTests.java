package org.tests.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.parabank.common.CommonActions;
import org.parabank.pages.base.BasePage;
import org.parabank.pages.base.LoginPage;
import org.parabank.pages.home.HomePage;
import org.parabank.pages.listing.HomeListingPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import static org.parabank.common.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.parabank.common.Config.HOLD_BROWSER_OPEN;

public class BaseTests {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected HomeListingPage homeListingPage = new HomeListingPage(driver);

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
