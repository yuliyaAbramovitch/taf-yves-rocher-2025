package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
    }

    private By emailField = By.cssSelector("#user-email");
    private By passwordField = By.cssSelector("#user-password");
    private By submit = By.cssSelector("submit-btn.eye-button");
    private By errorMessage = By.cssSelector(".email-validation-error .ng-star-inserted");
    private By emailValidationErrorMessage = By.cssSelector(".email.eye-form .ng-star-inserted");
    private By passwordValidationErrorMessage = By.cssSelector(".password.eye-form .ng-star-inserted");


    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(submit).click();
    }

    public void completeAuthorizationForm(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        submitForm();
    }

    public String getEmailValidationError() {
        return driver.findElement(emailValidationErrorMessage).getText();
    }

    public String getPasswordValidationError() {
        return driver.findElement(passwordValidationErrorMessage).getText();
    }

    public String getError() {
        return driver.findElement(errorMessage).getText();
    }
}
