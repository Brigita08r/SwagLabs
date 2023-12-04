package org.parabank.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement addToCartBtn() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }


    public WebElement cartItems() {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public void addToCart() {
        addToCartBtn().click();
    }
    public void navigateToCart(){
        cartItems().click();
    }
}
