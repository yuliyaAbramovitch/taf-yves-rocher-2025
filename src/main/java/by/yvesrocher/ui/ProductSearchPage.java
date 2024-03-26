package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchPage {
    WebDriver driver;

    public ProductSearchPage() {
        this.driver = Driver.getDriver();
    }

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

    public String getSearchItemCount() {
        return driver.findElement(searchResultsCounter).getText();
    }

    private List<WebElement> getItemList() {
        List<WebElement> items = driver.findElements(item);
        System.out.println(items.size());
        return items;
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : getItemList()) {
            itemNames.add(item.findElement(itemName).getText());
        }
        return itemNames;
    }

    private WebElement getItem() {
        return driver.findElement(item);
    }

    public String getItemName() {
        return getItem().findElement(itemName).getText();
    }

    public void addItemToBasket() {
        getItem().findElement(basketBtn).click();
    }

    public void goToBasket() {
        driver.findElement(redirectToBasketBtn).click();
    }
}
