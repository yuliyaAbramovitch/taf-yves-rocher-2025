package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SiteHeader {
    WebDriver driver;

    public SiteHeader() {
        this.driver = Driver.getDriver();
    }

    private By login = By.cssSelector(".icons-list .login-icon");
    private By languageBar = By.cssSelector(".view-versions-container .langauge-buttons");
    private By currentLanguage = By.cssSelector(".langauge-buttons .langauge-button.active");
    private By searchField = By.cssSelector(".search .eye-placeholder");
    private By searchMagnifier = By.cssSelector("div[aria-label='search-btn']");

    public void openLoginPage() {
        Utils.setWaiterByVisibility(driver, 5, 300, login);
        driver.findElement(login).click();
    }

    public void searchInCatalog(String searchWord) {
        driver.findElement(searchField).sendKeys(searchWord, Keys.ENTER);
    }

    public String getCurrentLanguage() {
        List<WebElement> languages = driver.findElements(languageBar);
        String activeLanguage = null;
        for (int i = 0; i < languages.size(); i++) {
            activeLanguage = languages.get(i).findElement(currentLanguage).getText();
        }
        return activeLanguage;
    }
}
