package by.yvesrocher.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketPageTest extends BaseTest {
    @Test
    public void testBasketItems() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.acceptCookie();
        homePage.leaveCurrentLanguageForUse();
        homePage.searchInCatalog("Кондиционер");

        ProductSearchPage productSearchPage = new ProductSearchPage();
        String itemName = productSearchPage.getItemName();
        System.out.println(itemName);
        productSearchPage.addItemToBasket();
        productSearchPage.goToBasket();

        BasketPage basketPage = new BasketPage();
        System.out.println("Items: " + basketPage.getItemNames());
        Assertions.assertTrue(basketPage.getItemNames().contains(itemName));

    }
}
