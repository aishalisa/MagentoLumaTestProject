package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = ".//header[@class='page-header']//a[text()='Create an Account']")
    protected WebElement buttonCreateAccount;

    public void clickCreateAccountButton() {
        buttonCreateAccount.click();
    }
}
