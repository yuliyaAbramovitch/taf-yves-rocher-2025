package by.yvesrocher.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {
    @Test
    @DisplayName("Test Non-Existing Credentials")
    public void testNonExistingCredentials() throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(10000);
        homePage.leaveCurrentLanguageForUse();
        Thread.sleep(5000);
        homePage.acceptCookie();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage();
        Thread.sleep(2000);
        loginPage.completeAuthorizationForm("login@mail.com", "password4890");

        Assertions.assertEquals(LoginPage.authorizationError, loginPage.getError());
    }
}
