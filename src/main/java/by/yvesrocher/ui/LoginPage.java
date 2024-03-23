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
    private By submit = By.cssSelector(".submit-btn.eye-button");
    private By errorMessage = By.cssSelector(".email-validation-error .ng-star-inserted");
    private By emailValidationError = By.cssSelector(".email.eye-form .ng-star-inserted");
    private By passwordValidationError = By.cssSelector(".password.eye-form .ng-star-inserted");
    private By delimiter = By.cssSelector(".authorization-wrapper .hr-line-with-text");
    public static String authorizationError = "Праверце карэктнасць уведзеных дадзеных";
    public static String shortPasswordError = "Пароль* павінен быць больш за 6 сімвалаў";
    public static String longPasswordError = "Пароль* павінен быць не больш за 30 сімвалаў";
    public static String emptyFieldError = "Гэта поле з'яўляецца абавязковым";
    public static String incorrectEmailError = "Email* павінен быць сапраўдным";
    public static String longEmailError = "Email* павінен быць не больш за 255 сімвалаў";

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public void placeCursorInField(By cssSelector) {
        Utils.setWaiterByVisibility(driver, 3, 300, cssSelector);
        driver.findElement(cssSelector).click();
    }

    public void inputEmail(String email) {
        Utils.setWaiterByVisibility(driver, 3, 300, emailField);
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputPassword(String password) {
        Utils.setWaiterByVisibility(driver, 3, 300, passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitForm() {
        Utils.setWaiterByVisibility(driver, 3, 300, submit);
        driver.findElement(submit).click();
    }

    public void completeAuthorizationForm(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        Utils utils = new Utils();
        utils.scrollingWheel(delimiter);
        submitForm();
        Utils.setWaiterByVisibility(driver, 3, 300, errorMessage);
    }

    public String getEmailValidationError() {
        return driver.findElement(emailValidationError).getText();
    }

    public String getPasswordValidationError() {
        return driver.findElement(passwordValidationError).getText();
    }

    public String getError() {
        return driver.findElement(errorMessage).getText();
    }
}
