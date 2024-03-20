package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils {
    WebDriver driver;

    public Utils() {
        this.driver = Driver.getDriver();
    }

    public void scrollingWheel(By cssSelector) {
        WebElement iframe = driver.findElement(cssSelector);
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
    }
}
