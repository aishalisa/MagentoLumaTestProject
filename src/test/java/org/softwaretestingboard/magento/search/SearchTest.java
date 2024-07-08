package org.softwaretestingboard.magento.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.softwaretestingboard.magento.components.SearchResultsPage;
import org.softwaretestingboard.magento.pages.HomePage;
import org.softwaretestingboard.magento.utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Should insert the item name in the search field and find it")
    void search() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForItem();
        Boolean isSearchCorrect = new SearchResultsPage(driver)
                .checkResultsContainTheItem();
        assertTrue(isSearchCorrect, "Search result doesn't contain the searched item");
    }

    @Test
    @DisplayName("Header should contain the searched item in its title")
    void checkHeader() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForItem();
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Boolean isHeaderContainsItemName = resultsPage.checkTheSearchResultsTitle();
        assertTrue(isHeaderContainsItemName);
    }
}
