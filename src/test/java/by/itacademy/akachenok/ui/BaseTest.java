package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeEach
    public void start() {
        WebDriver driver = SingletonWebDriver.getDriver();
        driver.get("https://detali.by/");
        LOGGER.info("Homepage https://detali.by/ is opened");
    }

    @AfterEach
    public void baseFinish() {
        SingletonWebDriver.quitDriver();
        LOGGER.info("Quit driver");
    }

}
