package org.tests;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.*;
import org.swaglabs.setup.SetUp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class CheckoutTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;
    private FinishPage finishPage;

    @BeforeMethod
    public void setUpAndLogin() {
        driver = SetUp.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);

        productsPage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
    }

    @Test
    public void checkOutWithOneItem() {
        productsPage.addItem("backpack");
        productsPage.navigateToCart();
        cartPage.isItemPresentInCart("Sauce Labs Backpack");
        cartPage.clickCheckout();
        checkoutPage.enterFirstName("Spider");
        checkoutPage.enterLastName("Man");
        checkoutPage.enterZipPostalCode("12345A");
        checkoutPage.clickContinue();
        overviewPage.checkAddedItemIsPresent("Sauce Labs Backpack");
        overviewPage.clickFinish();
        finishPage.thankYouTextIsPresent();
    }

    @Test
    public void impossibleCheckoutWithoutDataInput() {
        productsPage.addItem("backpack");
        productsPage.navigateToCart();
        cartPage.isItemPresentInCart("Sauce Labs Backpack");
        cartPage.clickCheckout();
        checkoutPage.enterFirstName("");
        checkoutPage.enterLastName("");
        checkoutPage.enterZipPostalCode("");
        checkoutPage.clickContinue();
        checkoutPage.errorMessageIsPresentNoLastName();
    }

    @AfterSuite
    public void tearDown() {
        SetUp.closeDriver();
    }

    @AfterMethod
    public void afterEach() {
        productsPage.resetAppStateButton();
    }
}
