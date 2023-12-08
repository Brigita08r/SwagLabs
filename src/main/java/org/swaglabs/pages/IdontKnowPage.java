package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.swaglabs.pages.BasePage;

public class IdontKnowPage extends BasePage {

    public IdontKnowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public void performCartPageAction() {
        navigateToCart();
    }

    public void enterCredentialsAndLogin() {
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginBtn.click();
    }
}
