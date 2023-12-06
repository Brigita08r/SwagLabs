package org.swaglabs.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//good example of base plus pages structure: https://github.com/naveenanimation20/PageObjectModel/blob/master/src/main/java/com/crm/qa/pages/ContactsPage.java
public class BasePage {
    protected WebDriver driver;

    public static final int EXPLICIT_WAIT = 10;

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


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void navigateToCart() {
        cartButton.click();
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
}
