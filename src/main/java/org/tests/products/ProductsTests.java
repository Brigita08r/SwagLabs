package org.tests.products;

import org.testng.annotations.Test;
import org.tests.base.BaseTests;

import static org.swaglabs.setup.SetUp.HOMEPAGE;

public class ProductsTests extends BaseTests {

    @Test
    public void cartTest() {
        basePage.open(HOMEPAGE);
        cartPage.enterCredentialsAndLogin();
        cartPage.performCartPageAction();
    }
}
