package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SiteHeader {
    WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    private By continueWithCurrentLanguage = By.cssSelector(".change-lng-modal-inner .change-lng-btn");
    private By acceptCookie = By.cssSelector(".buttons-container .button-submit");

    public void leaveCurrentLanguageForUse() {
        Utils.setWaiterByVisibility(driver, 10, 300, continueWithCurrentLanguage);
        driver.findElement(continueWithCurrentLanguage).click();
    }

    public void acceptCookie() {
        Utils.setWaiterByVisibility(driver, 5, 300, acceptCookie);
        driver.findElement(acceptCookie).click();
    }
}
