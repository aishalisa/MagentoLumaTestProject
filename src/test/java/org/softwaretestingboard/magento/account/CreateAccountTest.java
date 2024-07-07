package org.softwaretestingboard.magento.account;

import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.pages.CreateAccountPage;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountTest extends BaseTest {

    @Test
    void createAccountWithExistingCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver).insertPersonalInfoAndSubmit().isAlertVisible();
        assertTrue(alertMessage, "The account was created, password and email were not used before");
    }

    @Test
    void createAccountWithWeakPassword(){
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver).insertInfoAndWeakPassword().isVisibleAlertWeakPassword();
        assertTrue(alertMessage, "Password is strong");
    }
    @Test
    void createAccountWithWrongEmail(){
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver).insertInfoAndWrongEmail().isVisibleAlertWrongEmail();
        assertTrue(alertMessage, "Email is correct");
    }
}
