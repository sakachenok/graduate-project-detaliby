package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliPage {
    private WebDriver driver;

    public DetaliPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonEnterMainPage() {
        driver.findElement(By.xpath(DetaliPageXpath.BUTTON_ENTER_MAIN_PAGE)).click();
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.BUTTON_ENTER_AUTH_FORM)));
    }

    public void sendKeysInputLogin(String newUsername) {
        driver.findElement(By.xpath(DetaliPageXpath.INPUT_LOGIN)).sendKeys(newUsername);
    }

    public void sendKeysInputPassword(String newPassword) {
        driver.findElement(By.xpath(DetaliPageXpath.INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public void clickButtonEnterAuthForm() {
        driver.findElement(By.xpath(DetaliPageXpath.BUTTON_ENTER_AUTH_FORM)).click();
    }

    public void clickRadioButtonEmail() {
        driver.findElement(By.xpath(DetaliPageXpath.RADIO_BUTTON_EMAIL)).click();
    }

    public void clickRadioButtonPhone() {
        driver.findElement(By.xpath(DetaliPageXpath.RADIO_BUTTON_PHONE)).click();
    }


    public String getTextErrorMessageWrongCredentials() {
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)));
        return driver.findElement(By.xpath(DetaliPageXpath.ERROR_MESSAGE_WRONG_CREDENTIALS)).getText();
    }

    public String getTextErrorMessageInvalidEmailOrPhoneFormat() {
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)));
        return driver.findElement(By.xpath(DetaliPageXpath.ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT)).getText();
    }

    public void sendKeysInputSearchForm(String textForSearch) {
        driver.findElement(By.xpath(DetaliPageXpath.INPUT_SEARCH_FORM)).sendKeys(textForSearch);
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(DetaliPageXpath.BUTTON_SEARCH)).click();
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)));
    }

    public String getTextTitleSearchByName() {
        return driver.findElement(By.xpath(DetaliPageXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)).getText();
    }

    public void clickLinkSearchByNameResults() {
        driver.findElement(By.xpath(DetaliPageXpath.LINK_SEARCH_BY_NAME_RESULTS)).click();
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.BUTTON_ADD_TO_CART)));
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(DetaliPageXpath.BUTTON_ADD_TO_CART)).click();
    }

    public void clickButtonCart() {
        driver.findElement(By.xpath(DetaliPageXpath.BUTTON_CART)).click();
    }

    public String getTextItemInCart() {
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.TEXT_ITEM_IN_CART)));
        return driver.findElement(By.xpath(DetaliPageXpath.TEXT_ITEM_IN_CART)).getText();
    }

    public void openLoginFormByUsernameFillAndSubmit(String username, String password) {
        clickButtonEnterMainPage();
        sendKeysInputLogin(username);
        sendKeysInputPassword(password);
        clickButtonEnterAuthForm();
    }

    public void openLoginFormByEmailFillAndSubmit(String email, String password) {
        clickButtonEnterMainPage();
        clickRadioButtonEmail();
        sendKeysInputLogin(email);
        sendKeysInputPassword(password);
        clickButtonEnterAuthForm();
    }

    public void openLoginFormByEmailAndFill(String email, String password) {
        clickButtonEnterMainPage();
        clickRadioButtonEmail();
        sendKeysInputLogin(email);
        sendKeysInputPassword(password);
    }

    public void openLoginFormByPhoneFillAndSubmit(String phone, String password) {
        clickButtonEnterMainPage();
        clickRadioButtonPhone();
        sendKeysInputLogin(phone);
        sendKeysInputPassword(password);
        clickButtonEnterAuthForm();
    }

    public void openLoginFormByPhoneAndFill(String phone, String password) {
        clickButtonEnterMainPage();
        clickRadioButtonPhone();
        sendKeysInputLogin(phone);
        sendKeysInputPassword(password);
    }

    public void enterTextInSearchFormAndSearch(String textForSearch) {
        sendKeysInputSearchForm(textForSearch);
        clickButtonSearch();
    }

    public void searchForTheItemAndAddItToTheCartAndOpenTheCart() {
        enterTextInSearchFormAndSearch(User.getTextForSearch());
        clickLinkSearchByNameResults();
        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.BUTTON_ADD_TO_CART)));
        clickButtonAddToCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliPageXpath.BUTTON_CART)));
        clickButtonCart();
    }

}
