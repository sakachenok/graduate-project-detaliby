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
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(50));

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DetaliSearchXpath.BUTTON_SEARCH_FILTERS_RESET)));
        detaliSearch.clickButtonAddToCart();
        detaliSearch.clickButtonCart();
    }
}
