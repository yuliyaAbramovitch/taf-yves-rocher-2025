package by.yvesrocher.ui;

import org.junit.jupiter.api.Test;

public class BasketPageTest extends BaseTest {
    @Test
    public void testBasketItems() {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.searchInCatalog("Крем");

    }
}
