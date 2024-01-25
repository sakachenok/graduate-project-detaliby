package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliSearchStep {
    WebDriver driver;
    DetaliSearch detaliSearch;

    public DetaliSearchStep() {
        this.driver = SingletonWebDriver.getDriver();
        this.detaliSearch = new DetaliSearch();
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
