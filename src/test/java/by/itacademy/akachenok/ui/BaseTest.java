package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    @BeforeEach
    public void start() {
        WebDriver driver = SingletonWebDriver.getDriver();
        driver.get("https://detali.by/");
    }

    @AfterEach
    public void baseFinish() {
        SingletonWebDriver.quitDriver();
    }

}
