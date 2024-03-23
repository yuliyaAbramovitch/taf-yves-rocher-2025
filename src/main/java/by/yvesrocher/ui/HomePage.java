package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    private By login = By.cssSelector(".icons-list .login-icon");
    private By continueWithCurrentLanguage = By.cssSelector(".change-lng-modal-inner .change-lng-btn");
    private By acceptCookie = By.cssSelector(".buttons-container .button-submit");
    private By languageBar = By.cssSelector(".view-versions-container .langauge-buttons");
    private By currentLanguage = By.cssSelector(".langauge-buttons .langauge-button.active");

    public void openLoginPage() {
        Utils.setWaiterByVisibility(driver, 5, 300, login);
        driver.findElement(login).click();
    }

    public void leaveCurrentLanguageForUse() {
        Utils.setWaiterByVisibility(driver, 10, 300, continueWithCurrentLanguage);
        driver.findElement(continueWithCurrentLanguage).click();
    }

    public void acceptCookie() {
        Utils.setWaiterByVisibility(driver, 5, 300, acceptCookie);
        driver.findElement(acceptCookie).click();
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
