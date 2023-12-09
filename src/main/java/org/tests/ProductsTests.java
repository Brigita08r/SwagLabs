package org.tests;

import org.swaglabs.pages.LoginPage;
import org.swaglabs.pages.ProductsPage;
import org.swaglabs.setup.SetUp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.swaglabs.setup.SetUp.HOMEPAGE;
import static org.swaglabs.setup.SetUp.driver;

public class ProductsTests {
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @BeforeTest
    public void setUp() {
        driver = SetUp.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void loginAndNavigateToMainPage() {
        productsPage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
    }

    @Test
    public void addProductToCart() {
        productsPage.open(HOMEPAGE);
        productsPage.addItem("backpack");
    }

    @AfterMethod
    public void tearDown() {
        //basePage.resetAppStateButton();
        SetUp.closeDriver();
    }
}
