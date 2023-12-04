package org.parabank.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
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

    public LoginPage enterCredentialsAndLogin(String username, String password) {
        usernameInput().sendKeys(username);
        passwordInput().sendKeys(password);
        loginBtn().click();
        return this;
    }
}
//    private final By username = By.id("user-name");
//    private final By password = By.id("password");
//
//    private final By loginBtn = By.id("login-button");
//WebElement loginBtn = driver.findElement(By.id("login-button"));

//    public LoginPage enterCredentialsAndLogin() {
//        driver.findElement(username).sendKeys("standard_user");
//        driver.findElement(password).sendKeys("secret_sauce");
//        driver.findElement(loginBtn);
//        return this;
//    }