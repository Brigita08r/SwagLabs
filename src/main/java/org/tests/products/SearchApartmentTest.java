package org.tests.products;

import org.testng.annotations.Test;
import org.tests.base.BaseTests;

import static org.swaglabs.setup.CommonActions.HOMEPAGE;

public class SearchApartmentTest extends BaseTests {
    @Test
    public void checkIsRedirectToListing() {
        basePage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
        basePage.openSideMenu();
    }
}
