package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Utils {
    WebDriver driver;

    public Utils() {
        this.driver = Driver.getDriver();
    }
    public static void setWaiterByVisibility(WebDriver driver, int timeoutSeconds, int pollingMillis, By cssLocator){
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(timeoutSeconds)).
                pollingEvery(Duration.ofMillis(pollingMillis));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssLocator));
    }

    public void scrollingWheel(By cssSelector) {
        WebElement iframe = driver.findElement(cssSelector);
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
    }

    private int calculateSymbols(String appendix, int lengthLimit) {
        int length = 0;
        if (appendix.length() < lengthLimit) {
            length = lengthLimit - appendix.length();
        } else {
            length = 0;
        }
        return length;
    }

    public String generateString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateString(String appendix, int lengthLimit) {
        return generateString(calculateSymbols(appendix,lengthLimit));
    }

    public String generateEmail(int lengthLimit, String postfix) {
        return generateString(calculateSymbols(postfix,lengthLimit)) + postfix;
    }

//    public String generateEmail(String prefix, int length, String postfix) {
//        return prefix + RandomStringUtils.randomAlphabetic(length) + postfix;
//    }

    public String generateEmail(String prefix, int lengthLimit) {
        return prefix + generateString(prefix, lengthLimit);
    }
}
