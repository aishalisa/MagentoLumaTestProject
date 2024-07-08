package org.softwaretestingboard.magento.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.softwaretestingboard.magento.helpers.CredentialsReader;
import org.softwaretestingboard.magento.pages.BasePage;

import java.util.List;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        reader = new CredentialsReader();
    }

    @FindBy(className = "product-item-link")
    protected List<WebElement> linkResults;
    @FindBy(css = "h1.page-title")
    protected WebElement headerTitle;

    public Boolean checkResultsContainTheItem() {
        for (WebElement link : linkResults) {
            String title = link.getText();
            if (!title.matches("(?i).*" + reader.getItemName() + ".*")) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkTheSearchResultsTitle() {
        return headerTitle.getText().matches(".*" + reader.getItemName() + ".*");
    }
}
