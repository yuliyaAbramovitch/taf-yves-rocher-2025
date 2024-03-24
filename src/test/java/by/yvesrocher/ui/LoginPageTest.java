package by.yvesrocher.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {
    @Test
    @DisplayName("Non-Existing Credentials Error")
    public void testNonExistingCredentials() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(20, "@mail.com"), utils.generateString(7));

        Assertions.assertEquals(LoginPage.authorizationError, loginPage.getError());
    }

    @Test
    @DisplayName("Long Password Error")
    public void testLongPassword() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        loginPage.inputPassword(utils.generateString(Constants.PASSWORD_MAX_LENGTH + 1));
        utils.placeCursorInField(loginPage.getEmailField());
        Assertions.assertEquals(LoginPage.longPasswordError, loginPage.getPasswordValidationError());
    }

    @Test
    @DisplayName("Short Password Error")
    public void testShortPassword() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        loginPage.inputPassword(utils.generateString(3));
        utils.placeCursorInField(loginPage.getEmailField());

        Assertions.assertEquals(LoginPage.shortPasswordError, loginPage.getPasswordValidationError());
    }

    @Test
    @DisplayName("Long Email Error")
    public void testLongEmail() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        loginPage.inputEmail(utils.generateEmail(Constants.EMAIL_MAX_LENGTH+1, "@mail.com").toLowerCase());
        utils.placeCursorInField(loginPage.getPasswordField());

        Assertions.assertEquals(LoginPage.longEmailError, loginPage.getEmailValidationError());
    }

    @Test
    @DisplayName("Invalid Email Error")
    public void testInvalidEmail() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        loginPage.inputEmail(utils.generateString(10));
        utils.placeCursorInField(loginPage.getPasswordField());

        Assertions.assertEquals(LoginPage.incorrectEmailError, loginPage.getEmailValidationError());
    }

    @Test
    @DisplayName("Empty Email Error")
    public void testEmptyEmail() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        utils.placeCursorInField(loginPage.getEmailField());
        loginPage.inputPassword(utils.generateString(7));

        Assertions.assertEquals(LoginPage.emptyFieldError, loginPage.getEmailValidationError());
    }

    @Test
    @DisplayName("Empty Password Error")
    public void testEmptyPassword() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Utils utils = new Utils();
        utils.placeCursorInField(loginPage.getPasswordField());
        loginPage.inputEmail(utils.generateEmail(23, "@mail.com"));

        Assertions.assertEquals(LoginPage.emptyFieldError, loginPage.getPasswordValidationError());
    }
}
