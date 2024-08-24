package org.softwaretestingboard.magento.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.softwaretestingboard.magento.components.SearchResultsPage;
import org.softwaretestingboard.magento.helpers.CredentialsReader;

import java.util.List;

public class HomePage extends BasePage {
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
    @FindBy(xpath = ".//ol[@class='items']/*[2]/a")
    protected WebElement bottomsButtonMenu;
    @FindBy(xpath = ".//li[@class='authorization-link']/*")
    protected List<WebElement> signInButtons;
    @FindBy(xpath = ".//div[@class='panel header']/ul/li[1]/span")
    protected WebElement welcomeMessage;

    @FindBy(id = "email")
    protected WebElement emailField;
    @FindBy(id = "pass")
    protected WebElement password;
    @FindBy(id = "send2")
    protected WebElement signInButtonBottom;

    public void insertEmailPassword() {
        emailField.sendKeys(reader.getUserEmail());
        password.sendKeys(reader.getUserPassword());
        signInButtonBottom.click();
    }

    public void clickCreateAccountButton() {
        buttonCreateAccount.click();
    }

    public void searchForItem() {
        searchField.sendKeys(reader.getItemName(), Keys.ENTER);
        new SearchResultsPage(driver);
    }

    public void chooseMenuButton() {
        menuButtonWoman.click();
        bottomsButtonMenu.click();
    }

    public SearchResultsPage searchForItemDoNotPressEnter() {
        searchField.sendKeys(reader.getItemName());
        return new SearchResultsPage(driver);
    }

    public void clickSignInButtonHeader() {
        WebElement signInButtonHeader = signInButtons.get(0);
        signInButtonHeader.click();
    }

    public String getMessage() {
        driver.navigate().refresh();
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).getText();
    }
}
