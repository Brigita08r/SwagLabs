package org.swaglabs.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.swaglabs.pages.base.BasePage;

public class CartPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void performCartPageAction() {
        navigateToCart();
    }

    public void enterCredentialsAndLogin() {
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginBtn.click();
    }
}
