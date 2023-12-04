package org.tests.base;

import org.openqa.selenium.WebDriver;
import org.parabank.common.SetUp;
import org.parabank.pages.base.LoginPaged;
import org.parabank.pages.home.ProductsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.parabank.common.CommonActions.HOMEPAGE;

public class LoginTest {
    private WebDriver driver;
    private LoginPaged loginPaged;
    private ProductsPage productsPage;


    @BeforeTest
    public void setUp() {
        driver = SetUp.getDriver();
        loginPaged = new LoginPaged(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void invalidLoginTest() {
        loginPaged.navigateToLoginPage(HOMEPAGE);
        loginPaged.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.navigateToCart();
    }

    @AfterTest
    public void tearDown() {
        SetUp.closeDriver();
    }
}
