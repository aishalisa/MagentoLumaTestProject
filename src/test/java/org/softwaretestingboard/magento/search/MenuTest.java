package org.softwaretestingboard.magento.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

public class MenuTest extends BaseTest {
    @Test
    @DisplayName("Choose tops from drop down menu")
    void sortProductsBySpecificParameter(){
        HomePage homePage = new HomePage(driver);
        homePage.chooseItem();
    }
}
