package org.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    private WebDriver driver;
    @FindBy(className = "cart_list")
    private WebElement cartListItems;
    @FindBy(className = "cart_item")
    private WebElement cartItem;
    @FindBy(className = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "finish")
    private WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public boolean checkAddedItemIsPresent(String addedItem) {
        WebElement item = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + addedItem + "']"));
        return item.isDisplayed();
    }
}