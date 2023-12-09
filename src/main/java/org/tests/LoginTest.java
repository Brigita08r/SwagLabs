package org.tests;

import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.LoginPage;
import org.swaglabs.setup.SetUp;
import org.swaglabs.pages.ProductsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @BeforeTest
    public void setUp() {
        driver = SetUp.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void invalidLoginTest() {
        productsPage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
        productsPage.addToCart("backpack");
        productsPage.navigateToCart();
    }

    @AfterTest
    public void tearDown() {
        //basePage.resetAppStateButton();
        SetUp.closeDriver();
    }
}
