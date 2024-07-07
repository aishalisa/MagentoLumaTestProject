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

    @FindBy(id = "firstname")
    protected WebElement fieldName;
    @FindBy(id = "lastname")
    protected WebElement fieldSurname;
    @FindBy(id = "email_address")
    protected WebElement fieldEmail;
    @FindBy(xpath = ".//input[@id='password']")
    protected WebElement passwordField1;
    @FindBy(id = "password-confirmation")
    protected WebElement passwordField2;
    @FindBy(xpath = ".//button/span[text()='Create an Account']")
    protected WebElement submitButton;
    @FindBy(xpath = ".//div[@role='alert']")
    protected WebElement alertMessage;
    @FindBy(className = "password-weak")
    protected WebElement alertWeakPassword;
    @FindBy(id = "email_address-error")
    protected WebElement wrongEmail;
    @FindBy(className = "message-success")
    protected WebElement successMessage;

    public CreateAccountPage insertAccountInfo(String name, String surname, String email, String password){

        fieldName.sendKeys(name);
        fieldSurname.sendKeys(surname);
        fieldEmail.sendKeys(email);
        passwordField1.sendKeys(password);
        passwordField2.sendKeys(password);

        pressCreateAccountButton();
        return this;
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
    public Boolean isVisibleSuccessMessage(){
        return successMessage.isDisplayed();
    }

}
