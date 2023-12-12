package org.swaglabs.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.tests.ProductsTests;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SetUp {
    public static WebDriver driver;
    public static final String HOMEPAGE = "https://www.saucedemo.com";
    private static final Logger logger = Logger.getLogger(ProductsTests.class.getName());

    public SetUp() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
            logger.log(Level.INFO, "Setting up and logging in...");
            //runHeadless();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void runHeadless() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}