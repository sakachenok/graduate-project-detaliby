package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliSearch {
    private static final Logger LOGGER = LogManager.getLogger();

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(25));



    public DetaliSearch() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonAcceptCookies() {
        LOGGER.info("Click button Accept Cookies");
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_ACCEPT_COOKIES)).click();
    }

    public void sendKeysInputSearchForm(String textForSearch) {
        LOGGER.info("Send keys into the input Search Form");
        driver.findElement(By.xpath(DetaliSearchXpath.INPUT_SEARCH_FORM)).sendKeys(textForSearch);
    }

    public void clickCheckboxWithAnalogs() {
        LOGGER.info("Click checkbox With Analogs");
        driver.findElement(By.xpath(DetaliSearchXpath.CHECKBOX_WITH_ANALOGS)).click();
    }

    public void clickButtonSearch() {
        LOGGER.info("Click button Search");
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_SEARCH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)));
    }

    public String getTextTitleSearchByName() {
        String actualText = driver.findElement(By.xpath(DetaliSearchXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)).getText();
        LOGGER.info("getTextTitleSearchByName method returns text: " + actualText);
        return actualText;
    }

    public void clickLinkSearchByNameResults() {
        LOGGER.info("Click link Search by name results");
        driver.findElement(By.xpath(DetaliSearchXpath.LINK_SEARCH_BY_NAME_RESULTS)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.BUTTON_ADD_TO_CART)));
    }

    public void clickButtonAddToCart() {
        LOGGER.info("Click button Add to cart");
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_ADD_TO_CART)).click();
    }

    public void clickButtonCart() {
        LOGGER.info("Click button Cart");
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_CART)).click();
    }

    public String getTextItemInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.TEXT_ITEM_IN_CART)));
        String actualText = driver.findElement(By.xpath(DetaliSearchXpath.TEXT_ITEM_IN_CART)).getText();
        LOGGER.info("getTextItemInCart method returns text: " + actualText);
        return actualText;
    }

    public void scrollToButtonMoreItems() {
        Actions action = new Actions(driver);
        LOGGER.info("Scroll to button More Items");
        action.scrollToElement(driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_MORE_ITEMS))).perform();
    }

}
