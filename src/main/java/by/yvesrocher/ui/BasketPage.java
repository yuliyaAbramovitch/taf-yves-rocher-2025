package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    WebDriver driver;

    public BasketPage() {
        this.driver = Driver.getDriver();
    }

    private By chosenProduct = By.cssSelector(".chosen-products .chosen-product");
    private By getChosenProductName = By.cssSelector(".product-info .name");

    public List<WebElement> getChosenItems() {
        return driver.findElements(chosenProduct);
    }

    private List<String> getItemNames(List<WebElement> chosenItems) {
        List<String> itemNames = new ArrayList<>();
        for (WebElement chosenItem : chosenItems) {
            itemNames.add(chosenItem.findElement(getChosenProductName).getText());
        }
        return itemNames;
    }
}
