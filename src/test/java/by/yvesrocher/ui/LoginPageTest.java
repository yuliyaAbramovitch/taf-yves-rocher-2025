package by.yvesrocher.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LoginPageTest extends BaseTest {
    @Test
    @DisplayName("Test Non-Existing Credentials Error")
    public void testNonExistingCredentials() throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        Utils utils=new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(3, "@mail.com"), utils.generateString(7));

        Assertions.assertEquals(LoginPage.authorizationError, loginPage.getError());
    }
    @Test
    @DisplayName("Test Long Password Error")
    public void testLongPassword() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        Utils utils=new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(3, "@mail.com"),utils.generateString(31));

        Assertions.assertEquals(LoginPage.longPasswordError, loginPage.getPasswordValidationError());
    }
    @Test
    @DisplayName("Test Short Password Error")
    public void testShortPassword() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        Utils utils=new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(3, "@mail.com"), utils.generateString(3));

        Assertions.assertEquals(LoginPage.shortPasswordError, loginPage.getPasswordValidationError());
    }
    @Test
    @DisplayName("Test Long Email Error")
    public void testLongEmail() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(4000);
        Utils utils=new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(247, "@mail.com").toLowerCase(Locale.ROOT),utils.generateString(7));

        Assertions.assertEquals(LoginPage.longEmailError, loginPage.getEmailValidationError());
    }
    @Test
    @DisplayName("Test Invalid Email Error")
    public void testInvalidEmail() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        Utils utils=new Utils();
        loginPage.completeAuthorizationForm(utils.generateEmail(3, "@mail.com"), utils.generateString(7));

        Assertions.assertEquals(LoginPage.incorrectEmailError, loginPage.getEmailValidationError());
    }
    @Test
    @DisplayName("Test Empty Email Error")
    public void testEmptyEmail() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        loginPage.placeCursorInField(loginPage.getEmailField());
        Utils utils=new Utils();
        loginPage.inputPassword(utils.generateString(7));
        Assertions.assertEquals(LoginPage.emptyFieldError, loginPage.getEmailValidationError());
    }
    @Test
    @DisplayName("Test Empty Password Error")
    public void testEmptyPassword() throws InterruptedException {
        HomePage homePage=new HomePage();
        Thread.sleep(1000);
        homePage.acceptCookie();
        Thread.sleep(9000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(2000);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        loginPage.placeCursorInField(loginPage.getPasswordField());
        Utils utils=new Utils();
        loginPage.inputEmail(utils.generateEmail(3, "@mail.com"));
        Assertions.assertEquals(LoginPage.emptyFieldError, loginPage.getPasswordValidationError());
    }
}
