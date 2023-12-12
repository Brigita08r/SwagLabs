package org.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
    private WebDriver driver;
    String errorMessageNoFirstName = "Error: First Name is required";
    String errorMessageNoLastName = "Error: Last Name is required";
    String errorMessageNoPostalCode = "Error: Postal Code is required";
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
    @FindBy(className = "error-button")
    private WebElement errorButton;

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

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterZipPostalCode(String codeNumbers) {
        zipPostalCodeField.sendKeys(codeNumbers);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void errorMessageIsPresentNoName() {
        boolean isTextPresent = driver.getPageSource().contains(errorMessageNoFirstName);
    }

    public void errorMessageIsPresentNoLastName() {
        boolean isTextPresent = driver.getPageSource().contains(errorMessageNoLastName);
    }

    public void errorMessageIsPresentNoPostalCode() {
        boolean isTextPresent = driver.getPageSource().contains(errorMessageNoPostalCode);
    }

}