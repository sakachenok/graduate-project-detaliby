package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliSearch {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(25));

    public DetaliSearch() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonAcceptCookies() {
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_ACCEPT_COOKIES)).click();
    }

    public void sendKeysInputSearchForm(String textForSearch) {
        driver.findElement(By.xpath(DetaliSearchXpath.INPUT_SEARCH_FORM)).sendKeys(textForSearch);
    }

    public void clickCheckboxWithAnalogs() {
        driver.findElement(By.xpath(DetaliSearchXpath.CHECKBOX_WITH_ANALOGS)).click();
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_SEARCH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)));
    }

    public String getTextTitleSearchByName() {
        return driver.findElement(By.xpath(DetaliSearchXpath.TEXT_SEARCH_RESULT_SEARCH_PAGE)).getText();
    }

    public void clickLinkSearchByNameResults() {
        driver.findElement(By.xpath(DetaliSearchXpath.LINK_SEARCH_BY_NAME_RESULTS)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.BUTTON_ADD_TO_CART)));
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_ADD_TO_CART)).click();
    }

    public void clickButtonCart() {
        driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_CART)).click();
    }

    public String getTextItemInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DetaliSearchXpath.TEXT_ITEM_IN_CART)));
        return driver.findElement(By.xpath(DetaliSearchXpath.TEXT_ITEM_IN_CART)).getText();
    }

    public void scrollToButtonMoreItems() {
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath(DetaliSearchXpath.BUTTON_MORE_ITEMS))).perform();
    }

}
