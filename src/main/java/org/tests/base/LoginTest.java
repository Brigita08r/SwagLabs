package org.tests.base;

import org.openqa.selenium.WebDriver;
import org.swaglabs.setup.SetUp;
import org.swaglabs.pages.base.BasePage;
import org.swaglabs.pages.base.LoginPaged;
import org.swaglabs.pages.home.ProductsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.swaglabs.setup.CommonActions.HOMEPAGE;

public class LoginTest {
    private WebDriver driver;
    private LoginPaged loginPaged;
    private ProductsPage productsPage;
    private BasePage basePage;


    @BeforeTest
    public void setUp() {
        driver = SetUp.getDriver();
        loginPaged = new LoginPaged(driver);
        productsPage = new ProductsPage(driver);
        basePage = new BasePage(driver);
    }

    @Test
    public void invalidLoginTest() {
        loginPaged.navigateToLoginPage(HOMEPAGE);
        loginPaged.login("standard_user", "secret_sauce");
        productsPage.addToCart("backpack");
        productsPage.navigateToCart();
    }

    @AfterTest
    public void tearDown() {
        basePage.resetAppStateButton();
        SetUp.closeDriver();
    }
}
