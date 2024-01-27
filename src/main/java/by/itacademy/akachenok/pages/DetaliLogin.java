package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliLogin {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(10));
    private static final Logger LOGGER = LogManager.getLogger();

    public DetaliLogin() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonEnterMainPage() {
        LOGGER.info("Click button Enter on the main page");
        driver.findElement(By.xpath(DetaliLoginXpath.BUTTON_ENTER_MAIN_PAGE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.BUTTON_ENTER_AUTH_FORM)));
    }

    public void sendKeysInputLogin(String newUsername) {
        LOGGER.info("Send keys into the input Login");
        driver.findElement(By.xpath(DetaliLoginXpath.INPUT_LOGIN)).sendKeys(newUsername);
    }

    public void sendKeysInputPassword(String newPassword) {
        LOGGER.info("Send keys into the input Password");
        driver.findElement(By.xpath(DetaliLoginXpath.INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public void clickButtonEnterAuthForm() {
        LOGGER.info("Click button Enter in the Authorization Form");
        driver.findElement(By.xpath(DetaliLoginXpath.BUTTON_ENTER_AUTH_FORM)).click();
    }

    public void clickRadioButtonEmail() {
        LOGGER.info("Click radio button Email");
        driver.findElement(By.xpath(DetaliLoginXpath.RADIO_BUTTON_EMAIL)).click();
    }

    public void clickRadioButtonPhone() {
        LOGGER.info("Click radio button Phone");
        driver.findElement(By.xpath(DetaliLoginXpath.RADIO_BUTTON_PHONE)).click();
    }

    public String getTextErrorMessageWrongCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)));
        String actualText = driver.findElement(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)).getText();
        LOGGER.info("getTextErrorMessageWrongCredentials method returns text: " + actualText);
        return actualText;
    }

    public String getTextErrorMessageInvalidEmailOrPhoneFormat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)));
        String actualText = driver.findElement(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)).getText();
        LOGGER.info("getTextErrorMessageInvalidEmailOrPhoneFormat method returns text: " + actualText);
        return actualText;
    }

}
