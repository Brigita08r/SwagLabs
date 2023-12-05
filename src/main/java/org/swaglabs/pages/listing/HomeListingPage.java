package org.swaglabs.pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.swaglabs.pages.base.BasePage;
import org.testng.Assert;

public class HomeListingPage extends BasePage {
    public HomeListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='listing-item highlighted']");

    public HomeListingPage checkCountCards() {
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 20);
        return this;
    }
}
