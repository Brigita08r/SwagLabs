package org.tests;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.CartPage;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductsPage;
import org.swaglabs.setup.SetUp;
import org.testng.annotations.*;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class ProductsTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpAndLogin() {
        driver = SetUp.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        productsPage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
    }

    @Test
    public void addOneItemToCart() {
        productsPage.addItem("backpack");
        productsPage.navigateToCart();
        cartPage.isItemPresentInCart("Sauce Labs Backpack");
    }

    @Test
    public void addTwoItemsToCart() {
        productsPage.addItem("backpack");
        productsPage.addItem("bike-light");
        productsPage.navigateToCart();
        cartPage.isItemPresentInCart("Sauce Labs Backpack");
        cartPage.isItemPresentInCart("Sauce Labs Bike Light");
    }

    @Test
    public void addItemAndRemove() {
        productsPage.addItem("backpack");
        productsPage.navigateToCart();
        cartPage.removeItemByID("backpack");
        cartPage.checkItemIsNotPresent("backpack");
    }

    @Test
    public void addProductsAfterReturningToAllItems() {
        productsPage.addItem("backpack");
        productsPage.navigateToCart();
        cartPage.removeItemByID("backpack");
        cartPage.clickContinueShopping();
        productsPage.addItem("onesie");
        productsPage.navigateToCart();
        cartPage.checkItemIsNotPresent("onesie");
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
