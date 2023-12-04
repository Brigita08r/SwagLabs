package org.parabank.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.parabank.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {

    public static final String HOMEPAGE = "https://www.saucedemo.com";

    public static WebDriver createDriver() {
        WebDriver driver;
        driver = new ChromeDriver();

//        switch (PLATFORM_AND_BROWSER) {
//            case "win_chrome":
//                System.setProperty("webdriver.chrome.driver",
//                        "src/main/resources/chromedriver");
//                driver = new ChromeDriver();
//                break;
//            default:
//                org.testng.Assert.fail("Incorrect Platform or Browser name "
//                        + PLATFORM_AND_BROWSER);
//        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}