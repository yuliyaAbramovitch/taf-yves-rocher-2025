package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchPage {
    WebDriver driver;

    public ProductSearchPage() {
        this.driver = Driver.getDriver();
    }

    private By searchField = By.cssSelector(".search .eye-placeholder");
    private By searchMagnifier = By.cssSelector("div[aria-label='search-btn']");
    private By searchResultsCounter = By.cssSelector(".heading-wrapper .number-of-products");
    private By item = By.cssSelector(".products .product-item");
    private By itemName = By.cssSelector(".product-item .card-name");
    private By priceScrollBar = By.cssSelector(".slider .price-scrollbar");
    private By minPrice = By.cssSelector(".prices-range .min");
    private By maxPrice = By.cssSelector(".prices-range .max");
    private By lowerRate = By.cssSelector(".noUi-handle-lower");
    private By upperRate = By.cssSelector(".noUi-handle-upper");
    private By basketBtn = By.cssSelector(".basket-btn");
    private By redirectToBasketBtn = By.cssSelector(".modal-basket .basket-btn");

    public void searchInCatalog(String searchWord) {
        driver.findElement(searchField).sendKeys(searchWord);
        driver.findElement(searchMagnifier).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public void goToBasket() {
        driver.findElement(redirectToBasketBtn).click();
    }
}
