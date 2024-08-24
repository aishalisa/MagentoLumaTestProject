package org.softwaretestingboard.magento.account;

import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.pages.LoginPage;
import org.softwaretestingboard.magento.utils.BaseTest;

public class AccountTest extends BaseTest {
    @Test
    void logIn(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButtonHeader();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmailPassword();

        }
    }

