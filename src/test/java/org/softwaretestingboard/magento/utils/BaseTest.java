package org.softwaretestingboard.magento.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.softwaretestingboard.magento.pages.HomePage;

public class BaseTest {

    protected static WebDriver driver;
    protected static HomePage homePage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }


}
