package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliLogin {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(10));

    public DetaliLogin() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonEnterMainPage() {
        driver.findElement(By.xpath(DetaliLoginXpath.BUTTON_ENTER_MAIN_PAGE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.BUTTON_ENTER_AUTH_FORM)));
    }

    public void sendKeysInputLogin(String newUsername) {
        driver.findElement(By.xpath(DetaliLoginXpath.INPUT_LOGIN)).sendKeys(newUsername);
    }

    public void sendKeysInputPassword(String newPassword) {
        driver.findElement(By.xpath(DetaliLoginXpath.INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public void clickButtonEnterAuthForm() {
        driver.findElement(By.xpath(DetaliLoginXpath.BUTTON_ENTER_AUTH_FORM)).click();
    }

    public void clickRadioButtonEmail() {
        driver.findElement(By.xpath(DetaliLoginXpath.RADIO_BUTTON_EMAIL)).click();
    }

    public void clickRadioButtonPhone() {
        driver.findElement(By.xpath(DetaliLoginXpath.RADIO_BUTTON_PHONE)).click();
    }


    public String getTextErrorMessageWrongCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)));
        return driver.findElement(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)).getText();
    }

    public String getTextErrorMessageInvalidEmailOrPhoneFormat() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)));
        return driver.findElement(By.xpath(DetaliLoginXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)).getText();
    }

}
