package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.softwaretestingboard.magento.helpers.CredentialsReader;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        reader = new CredentialsReader();
    }

    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id="pass")
    WebElement password;
    @FindBy(id = "send2")
    WebElement signInButtonBottom;

    public void insertEmailPassword() {
    emailField.sendKeys(reader.getUserEmail());
    password.sendKeys(reader.getUserPassword());
    signInButtonBottom.click();
    }
}
