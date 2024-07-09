package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.softwaretestingboard.magento.components.SearchResultsPage;
import org.softwaretestingboard.magento.helpers.CredentialsReader;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        reader = new CredentialsReader();
    }
    @FindBy(xpath = ".//header[@class='page-header']//a[text()='Create an Account']")
    protected WebElement buttonCreateAccount;
    @FindBy(id = "search")
    protected WebElement searchField;
    @FindBy(id = "ui-id-4")
    protected WebElement menuButtonWoman;

    public void clickCreateAccountButton() {
        buttonCreateAccount.click();
    }

    public void searchForItem() {
        searchField.sendKeys(reader.getItemName(), Keys.ENTER);
        new SearchResultsPage(driver);
    }

    public void chooseItem() {
    menuButtonWoman.click();
    }
    public SearchResultsPage searchForItemDoNotPressEnter() {
        searchField.sendKeys(reader.getItemName());
        return new SearchResultsPage(driver);

    }
}
