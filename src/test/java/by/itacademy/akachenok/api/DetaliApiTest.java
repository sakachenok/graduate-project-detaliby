package by.itacademy.akachenok.api;

import by.itacademy.akachenok.pages.DetaliApi;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DetaliApiTest {

    @Test
    public void testLoginWithUsernameWrongCredentials() {
        DetaliApi.requestHeader()
                .body(DetaliApi.bodyLoginWithUsernameWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Логин или пароль введены неверно"))
                .log().all();
    }

    @Test
    public void testLoginWithUsernameEmptyFields() {
        DetaliApi.requestHeader()
                .body(DetaliApi.bodyLoginWithUsernameEmptyFields)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами логин в базе данных не найден."))
                .log().all();
    }

    @Test
    public void testLoginWithEmailWrongCredentials() {
        DetaliApi.requestHeader()
                .body(DetaliApi.bodyLoginWithEmailWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами email в базе данных не найден."))
                .log().all();
    }

    @Test
    public void testLoginWithPhoneWrongCredentials() {
        DetaliApi.requestHeader()
                .body(DetaliApi.bodyLoginWithPhoneWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами телефон в базе данных не найден."))
                .log().all();
    }

}
