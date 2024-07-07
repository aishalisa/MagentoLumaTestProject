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
    @FindBy(xpath = ".//div[@role='alert']")
    protected WebElement alertMessage;
    @FindBy(className = "password-weak")
    protected WebElement alertWeakPassword;
    @FindBy(id = "email_address-error")
    protected WebElement wrongEmail;

    public CreateAccountPage insertPersonalInfoAndSubmit() {
        insertName();
        insertSurname();
        insertEmail();
        insertPasswords();
        pressCreateAccountButton();
        return this;
    }
    public CreateAccountPage insertInfoAndWeakPassword(){
        insertName();
        insertSurname();
        insertEmail();
        insertWeakPassword();
        return this;
    }
    public CreateAccountPage insertInfoAndWrongEmail(){
        insertName();
        insertSurname();
        insertPasswords();
        insertWrongEmail();
        pressCreateAccountButton();
        return this;
    }

    private void insertWrongEmail() {
        String wrongEmail = reader.getWrongEmail();
        fieldEmail.sendKeys(wrongEmail);
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
    void insertWeakPassword(){
        String weakPassword = reader.getWeakPassword();
        passwordField1.sendKeys(weakPassword);
        getPasswordField2.sendKeys(weakPassword);
    }
    void pressCreateAccountButton(){
        submitButton.click();
    }
    public Boolean isAlertVisible(){
        return alertMessage.isDisplayed();
    }
    public Boolean isVisibleAlertWeakPassword(){
        return alertWeakPassword.isDisplayed();
    }
    public Boolean isVisibleAlertWrongEmail(){
        return wrongEmail.isDisplayed();
    }
}
