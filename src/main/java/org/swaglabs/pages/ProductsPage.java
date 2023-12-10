package org.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.swaglabs.setup.SetUp;

import java.time.Duration;

public class ProductsPage extends SetUp {
    private WebDriver driver;
    public static final int EXPLICIT_WAIT = 10;
    private static final String ITEM_ID_TEMPLATE = "add-to-cart-sauce-labs-%s";
    private WebElement itemId;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateButton;
    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeSideMenu;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartItems;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void addItem(String item) {
        driver.findElement(By.id("add-to-cart-sauce-labs-" + item)).click();
    }

    public void open(String url) {
        driver.get(url);
    }

    public void openSideMenu() {
        burgerMenuButton.click();
    }

    public void closeSideMenu() {
        closeSideMenu.click();
    }

    public void navigateToAllItems() {
        openSideMenu();
        allItemsButton.click();
    }

    public void navigateToAbout() {
        openSideMenu();
        aboutButton.click();
    }

    public void resetAppStateButton() {
        openSideMenu();
        waitElementIsVisible(resetAppStateButton);
        resetAppStateButton.click();
    }

    public void logout() {
        openSideMenu();
        logoutButton.click();
    }

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

    public void navigateToLoginPage(String homepage) {
    }
}