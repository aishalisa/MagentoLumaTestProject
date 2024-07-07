package org.softwaretestingboard.magento.account;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.softwaretestingboard.magento.helpers.CredentialsReader;
import org.softwaretestingboard.magento.pages.CreateAccountPage;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CreateAccountTest extends BaseTest {

    protected CredentialsReader reader = new CredentialsReader();
    protected String email = RandomStringUtils.randomAlphabetic(7) + reader.getUserEmail();

    @Test
    void createNewAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean successMessage = new CreateAccountPage(driver)
                .insertAccountInfo(reader.getName(), reader.getSurname(), email, reader.getUserPassword())
                .isVisibleSuccessMessage();
        assertTrue(successMessage, "The account was not created");
    }

    @Test
    void createAccountWithAlreadyUsedCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver)
                .insertAccountInfo(reader.getName(), reader.getSurname(), reader.getUserEmail(), reader.getUserPassword())
                .isAlertVisible();
        assertTrue(alertMessage, "The account was created, password and email were not used before");
    }

    @Test
    void createAccountWithWeakPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver)
                .insertAccountInfo(reader.getName(), reader.getSurname(), email, reader.getWeakPassword())
                .isVisibleAlertWeakPassword();
        assertTrue(alertMessage, "Password is strong, the account was created");
    }

    @Test
    void createAccountWithWrongEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        Boolean alertMessage = new CreateAccountPage(driver)
                .insertAccountInfo(reader.getName(), reader.getSurname(), reader.getWrongEmail(), reader.getUserPassword())
                .isVisibleAlertWrongEmail();
        assertTrue(alertMessage, "Email is correct, the account was created");
    }

}
