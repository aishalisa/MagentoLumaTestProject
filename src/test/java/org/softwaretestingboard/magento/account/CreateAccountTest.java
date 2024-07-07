package org.softwaretestingboard.magento.account;

import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.pages.CreateAccountPage;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

public class CreateAccountTest extends BaseTest {

    @Test
    void createAccount() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.insertPersonalInfoAndSubmit();
        Thread.sleep(3000);
    }
}
