package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.softwaretestingboard.magento.helpers.CredentialsReader;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        reader = new CredentialsReader();
    }

    CredentialsReader reader;
    @FindBy(id = "firstname")
    protected WebElement fieldName;
    @FindBy(id = "lastname")
    protected WebElement fieldSurname;
    @FindBy(id = "email_address")
    protected WebElement fieldEmail;
    @FindBy(xpath = ".//input[@id='password']")
    protected WebElement passwordField1;
    @FindBy(id = "password-confirmation")
    protected WebElement getPasswordField2;
    @FindBy(xpath = ".//button/span[text()='Create an Account']")
    protected WebElement submitButton;

    public void insertPersonalInfoAndSubmit() {
        insertName();
        insertSurname();
        insertEmail();
        insertPasswords();
        pressCreateAccountButton();
    }

    void insertName() {
        String name = reader.getName();
        fieldName.sendKeys(name);
    }

    void insertSurname() {
        String surname = reader.getSurname();
        fieldSurname.sendKeys(surname);
    }

    void insertEmail() {
        String userEmail = reader.getUserEmail();
        fieldEmail.sendKeys(userEmail);
    }

    void insertPasswords() {
        String userPassword = reader.getUserPassword();
        passwordField1.sendKeys(userPassword);
        getPasswordField2.sendKeys(userPassword);
    }
    void pressCreateAccountButton(){
        submitButton.click();
    }
}
