package org.tests;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.CartPage;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductsPage;
import org.swaglabs.setup.SetUp;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class ProductsTests {
    private static final Logger logger = Logger.getLogger(ProductsTests.class.getName());
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

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
    }

    @Test
    public void addOneItemToCart() {
        logger.log(Level.INFO, "Adding one item to the cart...");
        addItemsAndNavigateToCart("backpack");
        Assert.assertTrue(cartPage.isItemPresentInCart("Sauce Labs Backpack"),
                "Item not found in the cart");
    }

    public void addItemsAndNavigateToCart(String item) {
        productsPage.addItem(item);
        productsPage.navigateToCart();
    }

    @Test
    public void addTwoItemsToCart() {
        logger.log(Level.INFO, "Adding two items to the cart...");
        productsPage.addItem("backpack");
        productsPage.addItem("bike-light");
        productsPage.navigateToCart();
        Assert.assertTrue(cartPage.isItemPresentInCart("Sauce Labs Backpack"),
                "Item 1 not found in the cart");
        Assert.assertTrue(cartPage.isItemPresentInCart("Sauce Labs Bike Light"),
                "Item 2 not found in the cart");
    }

    @Test
    public void addItemAndRemove() {
        addItemsAndNavigateToCart("backpack");
        cartPage.removeItemByID("backpack");
        cartPage.checkItemIsNotPresent("backpack");
    }

    @Test
    public void addProductsAfterReturningToAllItems() {
        addItemsAndNavigateToCart("backpack");
        cartPage.removeItemByID("backpack");
        cartPage.clickContinueShopping();
        addItemsAndNavigateToCart("onesie");
        Assert.assertFalse(cartPage.checkItemIsNotPresent("onesie"),
                "Unexpected item found in the cart");
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