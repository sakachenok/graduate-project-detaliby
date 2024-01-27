package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliLogin;
import by.itacademy.akachenok.pages.DetaliLoginStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DetaliLoginTest extends BaseTest {
    private static final String EXPECTED_ERROR_MESSAGE_FORM_BY_USERNAME_WRONG_CREDENTIALS = "Логин или пароль введены неверно";
    private static final String EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_WRONG_CREDENTIALS = "Указанный Вами email в базе данных не найден.";
    private static final String EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_INVALID_EMAIL_FORMAT = "Пожалуйста, введите правильный email-адрес. Для примера \"test@domain.com\"";
    private static final String EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_WRONG_CREDENTIALS = "Указанный Вами телефон в базе данных не найден.";
    private static final String EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_INVALID_PHONE_FORMAT = "Пожалуйста, введите номер в международном формате.";
    private static final Logger LOGGER = LogManager.getLogger();
    DetaliLogin detaliLogin = new DetaliLogin();
    DetaliLoginStep detaliLoginStep = new DetaliLoginStep();

    @Test
    public void testLoginFormByUsernameWrongCredentials() {
        detaliLoginStep.openLoginFormByUsernameFillAndSubmit(User.getRandomUsername(),User.getRandomPassword());
        LOGGER.info("Expected Error Message: " + EXPECTED_ERROR_MESSAGE_FORM_BY_USERNAME_WRONG_CREDENTIALS);
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE_FORM_BY_USERNAME_WRONG_CREDENTIALS, detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailWrongCredentials() {
        detaliLoginStep.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(), User.getRandomPassword());
        LOGGER.info("Expected Error Message: " + EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_WRONG_CREDENTIALS);
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_WRONG_CREDENTIALS, detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailInvalidEmailFormat() {
        detaliLoginStep.openLoginFormByEmailAndFill(User.getRandomInvalidEmail(), User.getRandomPassword());
        LOGGER.info("Expected Error Message: " + EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_INVALID_EMAIL_FORMAT);
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE_FORM_BY_EMAIL_INVALID_EMAIL_FORMAT, detaliLogin.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testLoginFormByPhoneWrongCredentials() {
        detaliLoginStep.openLoginFormByPhoneFillAndSubmit(User.getRandomPhoneNumber(), User.getRandomPassword());
        LOGGER.info("Expected Error Message: " + EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_WRONG_CREDENTIALS);
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_WRONG_CREDENTIALS, detaliLogin.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByPhoneInvalidPhoneFormat() {
        detaliLoginStep.openLoginFormByPhoneAndFill(User.getRandomPassword(), User.getRandomPassword());
        LOGGER.info("Expected Error Message: " + EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_INVALID_PHONE_FORMAT);
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE_FORM_BY_PHONE_INVALID_PHONE_FORMAT, detaliLogin.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

}
