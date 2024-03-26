package by.yvesrocher.ui;

import by.yvesrocher.driver.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void warmUp() {
        driver = Driver.getDriver();
        driver.get("https://www.y-r.by/");
    }

//    @AfterEach
//    public void tearDown() {
//        Driver.quitDriver();
//    }
}
