package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    String thankYouText = "Thank you for your order!";

    private WebDriver driver;
    @FindBy(className = "complete-header")
    private WebElement header;
    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;
    public FinishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
