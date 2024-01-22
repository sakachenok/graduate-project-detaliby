package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliStep {

    WebDriver driver;
    DetaliPage detaliPage;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(20));

    public  DetaliStep () {
        this.driver = SingletonWebDriver.getDriver();
        this.detaliPage = new DetaliPage();
    }

    public void openLoginFormByUsernameFillAndSubmit (String username, String password){
        detaliPage.clickButtonEnterMainPage();
        detaliPage.sendKeysInputLogin(username);
        detaliPage.sendKeysInputPassword(password);
        detaliPage.clickButtonEnterAuthForm();
    }

    public void openLoginFormByEmailFillAndSubmit(String email, String password) {
        detaliPage.clickButtonEnterMainPage();
        detaliPage.clickRadioButtonEmail();
        detaliPage.sendKeysInputLogin(email);
        detaliPage.sendKeysInputPassword(password);
        detaliPage.clickButtonEnterAuthForm();
    }

    public void openLoginFormByEmailAndFill(String email, String password) {
        detaliPage.clickButtonEnterMainPage();
        detaliPage.clickRadioButtonEmail();
        detaliPage.sendKeysInputLogin(email);
        detaliPage.sendKeysInputPassword(password);
    }

    public void openLoginFormByPhoneFillAndSubmit(String phone, String password) {
        detaliPage.clickButtonEnterMainPage();
        detaliPage.clickRadioButtonPhone();
        detaliPage.sendKeysInputLogin(phone);
        detaliPage.sendKeysInputPassword(password);
        detaliPage.clickButtonEnterAuthForm();
    }

    public void openLoginFormByPhoneAndFill(String phone, String password) {
        detaliPage.clickButtonEnterMainPage();
        detaliPage.clickRadioButtonPhone();
        detaliPage.sendKeysInputLogin(phone);
        detaliPage.sendKeysInputPassword(password);
    }

    public void enterTextInSearchFormAndSearch(String textForSearch) {
        detaliPage.sendKeysInputSearchForm(textForSearch);
        detaliPage.clickCheckboxWithAnalogs();
        detaliPage.clickButtonSearch();
    }

    public void searchForTheItemAndAddItToTheCartAndOpenTheCart() {
        enterTextInSearchFormAndSearch(User.getTextForSearch());
        detaliPage.clickButtonAcceptCookies();
        detaliPage.clickLinkSearchByNameResults();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DetaliPageXpath.BUTTON_MORE_ITEMS)));
        detaliPage.clickButtonAddToCart();
        detaliPage.clickButtonCart();
    }

}
