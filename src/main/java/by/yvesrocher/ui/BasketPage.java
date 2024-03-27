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
    private By getChosenProductsNames = By.cssSelector(".product-info .name");

    public List<WebElement> getChosenItems() {
//        Utils.setWaiterByVisibility(driver, 3, 500, chosenProduct);
        Utils.setWaiterByURLToBe(driver, 3,300, "https://www.y-r.by/basket");
        return driver.findElements(chosenProduct);
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement chosenItem : getChosenItems()) {
            itemNames.add(chosenItem.findElement(getChosenProductsNames).getText());
        }
        return itemNames;
    }
}
