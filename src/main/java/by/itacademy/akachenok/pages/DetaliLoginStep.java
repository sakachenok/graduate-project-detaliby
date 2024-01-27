package by.itacademy.akachenok.pages;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetaliLoginStep {

    WebDriver driver;
    DetaliLogin detaliLogin;

    public DetaliLoginStep() {
        this.driver = SingletonWebDriver.getDriver();
        this.detaliLogin = new DetaliLogin();
    }

    public void openLoginFormByUsernameFillAndSubmit (String username, String password){
        detaliLogin.clickButtonEnterMainPage();
        detaliLogin.sendKeysInputLogin(username);
        detaliLogin.sendKeysInputPassword(password);
        detaliLogin.clickButtonEnterAuthForm();
    }

    public void openLoginFormByEmailAndFill(String email, String password) {
        detaliLogin.clickButtonEnterMainPage();
        detaliLogin.clickRadioButtonEmail();
        detaliLogin.sendKeysInputLogin(email);
        detaliLogin.sendKeysInputPassword(password);
    }

    public void openLoginFormByEmailFillAndSubmit(String email, String password) {
        openLoginFormByEmailAndFill(email, password);
        detaliLogin.clickButtonEnterAuthForm();
    }

    public void openLoginFormByPhoneAndFill(String phone, String password) {
        detaliLogin.clickButtonEnterMainPage();
        detaliLogin.clickRadioButtonPhone();
        detaliLogin.sendKeysInputLogin(phone);
        detaliLogin.sendKeysInputPassword(password);
    }

    public void openLoginFormByPhoneFillAndSubmit(String phone, String password) {
        openLoginFormByPhoneAndFill(phone, password);
        detaliLogin.clickButtonEnterAuthForm();
    }

}
