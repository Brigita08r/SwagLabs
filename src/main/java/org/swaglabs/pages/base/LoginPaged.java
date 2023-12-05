package org.swaglabs.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPaged {
    private WebDriver driver;

    public LoginPaged(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement usernameInput() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }

    private WebElement loginBtn() {
        return driver.findElement(By.id("login-button"));
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void login(String username, String password) {
        usernameInput().sendKeys(username);
        passwordInput().sendKeys(password);
        loginBtn().click();
    }
}
