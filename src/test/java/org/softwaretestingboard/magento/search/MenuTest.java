package org.softwaretestingboard.magento.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.components.SearchResultsPage;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest extends BaseTest {
    @Test
    @DisplayName("Choose bottoms from menu Women/bottoms")
    void sortProductsByWomenBottoms() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseMenuButton();
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Boolean isResultsListContainsBottoms = resultsPage.checkTheSearchResultsContainBottoms();
        assertTrue(isResultsListContainsBottoms, "The list with found results doesn't contain bottoms, shorts");
    }
}
