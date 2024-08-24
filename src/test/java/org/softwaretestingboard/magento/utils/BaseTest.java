package org.softwaretestingboard.magento.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless==new");
        options.addArguments("start-maximized");
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }


}
