package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
    private WebDriver driver;
    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement zipPostalCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "cancel")
    private WebElement cancelButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkTitlePage() {
        String pageTitle = driver.getTitle();
        String expectedTitleText = "Checkout: Your Information";
        Assert.assertEquals(pageTitle.contains(expectedTitleText),
                String.format("Expected title to contain '%s', but actual title is '%s'", expectedTitleText, pageTitle));
    }

}
