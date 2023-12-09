package org.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductsPage;
import org.swaglabs.setup.SetUp;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTests {
    protected WebDriver driver = SetUp.getDriver();
    //    protected BasePage basePage = new BasePage(driver);
//    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected ProductsPage productsPage = new ProductsPage(driver);
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
