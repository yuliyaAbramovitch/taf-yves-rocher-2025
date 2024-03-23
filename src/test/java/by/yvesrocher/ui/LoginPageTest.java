package by.yvesrocher.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        loginPage.completeAuthorizationForm("login@mail.com", "password4890");

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
        loginPage.completeAuthorizationForm(
                "login@mail.com",
                "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
        );

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
        loginPage.completeAuthorizationForm("login@mail.com","111");

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
        Thread.sleep(2000);
        loginPage.completeAuthorizationForm(
                "11178800000000000000000000000000000000000000000000000000000000000000000000000000088888888881111111117777777777777777777777777777777777777111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111455555555555555555555555555555555555555555555555555555555551111111111111111111111111111111111111111111111114444444444444444444444444444411111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111login@mail.com",
                "112234111");

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
        loginPage.completeAuthorizationForm(
                "login@mail.com11111111111111111111111111111111", "112234111");

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
        loginPage.inputPassword("12345678");
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
        loginPage.inputEmail("qwerty@mail.com");
        Assertions.assertEquals(LoginPage.emptyFieldError, loginPage.getPasswordValidationError());
    }
}
