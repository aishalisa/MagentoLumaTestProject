package org.softwaretestingboard.magento.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @FindBy(css = "span.qs-option-name")
    protected List<WebElement> dropdownListResults;
    @FindBy(className = "product-item-link")
    protected List<WebElement> listResults;

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

    public Boolean checkDropdownListContainsItem() {
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownListResults));
        for (WebElement result : dropdownListResults) {
            String itemName = result.getText();
            if (!itemName.matches("(?i).*" + reader.getItemName() + ".*")) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkTheSearchResultsContainBottoms() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listResults));
        for (WebElement result : listResults) {
            String itemName = result.getText();
            if (itemName.matches("(?i).*" + reader.getItemName() + ".*")) {
                return true;
            }
        }
        return false;
    }
}
