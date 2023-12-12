package org.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    private WebDriver driver;
    @FindBy(className = "title")
    private WebElement titleText;
    @FindBy(className = "inventory_item_name")
    private WebElement inventoryItemName;
    //    remove-sauce-labs-backpack
    @FindBy(name = "Remove")
    private WebElement removeButton;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRemove() {
        removeButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void removeItemByID(String itemId) {
        WebElement toRemove = driver.findElement(By.id("remove-sauce-labs-" + itemId));
        toRemove.click();
    }

    public void checkTitlePage() {
        String pageTitle = driver.getTitle();
        String expectedTitleText = "Your Cart";
        Assert.assertEquals(pageTitle.contains(expectedTitleText),
                String.format("Expected title to contain '%s', but actual title is '%s'", expectedTitleText, pageTitle));
    }

    public boolean isItemPresentInCart(String itemName) {
        WebElement item = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + itemName + "']"));
        return item.isDisplayed();
    }

    public boolean checkItemIsNotPresent(String itemName) {
        try {
            WebElement item = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + itemName + "']"));
            return item.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Item not found, return false
        }
    }
}