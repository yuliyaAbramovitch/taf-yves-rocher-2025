package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.apache.commons.lang3.RandomStringUtils;
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

    public String generateString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateEmail(int length, String postfix) {
        return RandomStringUtils.randomAlphabetic(length) + postfix;
    }

    public String generateEmail(String prefix, int length, String postfix) {
        return prefix + RandomStringUtils.randomAlphabetic(length) + postfix;
    }

    public String generateEmail(String prefix, int length) {
        return prefix + RandomStringUtils.randomAlphabetic(length);
    }
}
