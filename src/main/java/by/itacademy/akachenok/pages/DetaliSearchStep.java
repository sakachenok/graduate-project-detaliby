package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliSearchStep {
    WebDriver driver;
    DetaliSearch detaliSearch;
    private static final Logger LOGGER = LogManager.getLogger();

    public DetaliSearchStep() {
        this.driver = SingletonWebDriver.getDriver();
        this.detaliSearch = new DetaliSearch();
        LOGGER.info("WebDriver is created in DetaliSearchStep constructor");
    }

    public void enterTextInSearchFormAndSearch(String textForSearch) {
        detaliSearch.sendKeysInputSearchForm(textForSearch);
        detaliSearch.clickCheckboxWithAnalogs();
        detaliSearch.clickButtonSearch();
    }

    public void searchForTheItemAndAddItToTheCartAndOpenTheCart() {
        enterTextInSearchFormAndSearch(User.getTextForSearch());
        detaliSearch.clickButtonAcceptCookies();
        detaliSearch.clickLinkSearchByNameResults();
        detaliSearch.scrollToButtonMoreItems();
        detaliSearch.clickButtonAddToCart();
        detaliSearch.clickButtonCart();
    }
}
