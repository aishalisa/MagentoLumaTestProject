package org.softwaretestingboard.magento.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.helpers.CredentialsReader;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

public class AccountTest extends BaseTest {
    protected CredentialsReader reader = new CredentialsReader();

    @Test
    @DisplayName("Log in to the tester account and check if the welcome message correct")
    void logIn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButtonHeader();
        homePage.insertEmailPassword();
        String welcomeHeaderMessage = homePage.getMessage();
        Assertions.assertEquals("Welcome, "+reader.getName()+" "+reader.getSurname()+"!", welcomeHeaderMessage,"The welcome message is wrong," +
                " you are not log in ");
    }
}

