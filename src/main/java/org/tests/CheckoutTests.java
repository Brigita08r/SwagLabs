package org.tests;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.*;
import org.swaglabs.setup.SetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class CheckoutTests {
    private static final Logger logger = Logger.getLogger(ProductsTests.class.getName());
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
        setUpPages();
        productsPage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
    }

    public void setUpPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);
    }

    @Test
    public void checkOutWithOneItem() {
        addItemAndCheckItemIsPresent("backpack");
        cartPage.clickCheckout();
        enterCredentials("Spider", "Man", "12345A");
        checkoutPage.clickContinue();
        overviewPage.checkAddedItemIsPresent("Sauce Labs Backpack");
        overviewPage.clickFinish();
        finishPage.thankYouTextIsPresent();
    }

    public void enterCredentials(String name, String lastName, String number) {
        checkoutPage.enterFirstName(name);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterZipPostalCode(number);
    }

    public void addItemAndCheckItemIsPresent(String itemName) {
        logger.log(Level.INFO, "Adding one item to the cart...");
        productsPage.addItem(itemName);
        productsPage.navigateToCart();
        Assert.assertTrue(cartPage.isItemPresentInCart("Sauce Labs Backpack"),
                "Item not found in the cart");
    }

    @Test
    public void impossibleCheckoutWithoutDataInput() {
        addItemAndCheckItemIsPresent("backpack");
        cartPage.clickCheckout();
        enterCredentials("", "", "");
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