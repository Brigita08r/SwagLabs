package org.tests.products;

import org.tests.base.BaseTests;
import org.testng.annotations.Test;

import static org.parabank.common.CommonActions.HOMEPAGE;

public class SearchApartmentTest extends BaseTests {
    @Test
    public void checkIsRedirectToListing() {
        basePage.open(HOMEPAGE);
        loginPage.enterCredentialsAndLogin("standard_user", "secret_sauce");
    }
}
