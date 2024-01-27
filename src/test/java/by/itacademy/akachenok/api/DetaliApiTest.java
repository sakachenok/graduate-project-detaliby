package by.itacademy.akachenok.api;

import by.itacademy.akachenok.pages.DetaliApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DetaliApiTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testLoginWithUsernameWrongCredentials() {
        LOGGER.info("testLoginWithUsernameWrongCredentials started");
        DetaliApi.getHeaderContentTypeTextPlainUTF8()
                .body(DetaliApi.BODY_LOGIN_WITH_USERNAME_WRONG_CREDENTIALS)
                .when().post(DetaliApi.URL)
                .then().statusCode(401).body("errorMessage", equalTo("Логин или пароль введены неверно"));
        LOGGER.info("testLoginWithUsernameWrongCredentials passed");
    }

    @Test
    public void testLoginWithUsernameEmptyFields() {
        LOGGER.info("testLoginWithUsernameEmptyFields started");
        DetaliApi.getHeaderContentTypeTextPlainUTF8()
                .body(DetaliApi.BODY_LOGIN_WITH_USERNAME_EMPTY_FIELDS)
                .when().post(DetaliApi.URL)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами логин в базе данных не найден."));
        LOGGER.info("testLoginWithUsernameEmptyFields passed");
    }

    @Test
    public void testLoginWithEmailWrongCredentials() {
        LOGGER.info("testLoginWithEmailWrongCredentials started");
        DetaliApi.getHeaderContentTypeTextPlainUTF8()
                .body(DetaliApi.BODY_LOGIN_WITH_EMAIL_WRONG_CREDENTIALS)
                .when().post(DetaliApi.URL)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами email в базе данных не найден."));
        LOGGER.info("testLoginWithEmailWrongCredentials passed");
    }

    @Test
    public void testLoginWithPhoneWrongCredentials() {
        LOGGER.info("testLoginWithPhoneWrongCredentials started");
        DetaliApi.getHeaderContentTypeTextPlainUTF8()
                .body(DetaliApi.BODY_LOGIN_WITH_PHONE_WRONG_CREDENTIALS)
                .when().post(DetaliApi.URL)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами телефон в базе данных не найден."));
        LOGGER.info("testLoginWithPhoneWrongCredentials passed");
    }

}
