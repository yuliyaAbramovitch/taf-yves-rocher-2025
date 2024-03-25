package by.yvesrocher.ui;

import org.openqa.selenium.By;

public class ProductSearchPage {
    private By searchField = By.cssSelector(".search .eye-placeholder");
    private By searchMagnifier = By.cssSelector("div[aria-label='search-btn']");
    private By searchResultsCounter = By.cssSelector(".heading-wrapper .number-of-products");
    private By item = By.cssSelector(".products .product-item");
    private By itemName = By.cssSelector(".product-item .card-name");
    private By priceScrollBar = By.cssSelector(".slider .price-scrollbar");
    private By lowerRate = By.cssSelector(".noUi-handle-lower");
    private By upperRate = By.cssSelector(".noUi-handle-upper");
    private By basketBtn = By.cssSelector(".basket-btn");
    private By redirectToBasketBtn = By.cssSelector(".modal-basket .basket-btn");

}
