package org.swaglabs.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;
    private static final String ITEM_ID_TEMPLATE = "add-to-cart-sauce-labs-%s";
    private WebElement itemId;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    private WebElement cartItems;

    public void setItemAndInitialize(String item) {
        String dynamicItemId = String.format(ITEM_ID_TEMPLATE, item);
        itemId = driver.findElement(By.id(dynamicItemId));
        itemId.click();
    }


    public void addToCart(String item) {
        setItemAndInitialize(item);
    }

    public void navigateToCart() {
        cartItems.click();
    }
}
