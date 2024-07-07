package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softwaretestingboard.magento.helpers.CredentialsReader;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    CredentialsReader reader;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
