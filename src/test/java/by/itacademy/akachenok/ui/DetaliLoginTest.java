package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliLogin;
import by.itacademy.akachenok.pages.DetaliLoginStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DetaliLoginTest extends BaseTest {
    DetaliLogin detaliLogin = new DetaliLogin();
    DetaliLoginStep detaliLoginStep = new DetaliLoginStep();

    @Test
    public void testLoginFormByUsernameWrongCredentials() {
        detaliLoginStep.openLoginFormByUsernameFillAndSubmit(User.getRandomUsername(),User.getRandomPassword());
        Assertions.assertEquals("Логин или пароль введены неверно", detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailWrongCredentials() {
        detaliLoginStep.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами email в базе данных не найден.", detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailInvalidEmailFormat() {
        detaliLoginStep.openLoginFormByEmailAndFill(User.getRandomInvalidEmail(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите правильный email-адрес. Для примера \"test@domain.com\"", detaliLogin.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testLoginFormByPhoneWrongCredentials() {
        detaliLoginStep.openLoginFormByPhoneFillAndSubmit(User.getRandomPhoneNumber(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами телефон в базе данных не найден.", detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByPhoneInvalidPhoneFormat() {
        detaliLoginStep.openLoginFormByPhoneAndFill(User.getRandomPassword(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите номер в международном формате.", detaliLogin.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

}
