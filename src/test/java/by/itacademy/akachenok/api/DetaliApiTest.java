package by.itacademy.akachenok.api;

import by.itacademy.akachenok.pages.DetaliApi;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DetaliApiTest {

    @Test
    public void testLoginWithUsernameWrongCredentials() {
        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(DetaliApi.bodyLoginWithUsernameWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Логин или пароль введены неверно"));
    }

    @Test
    public void testLoginWithUsernameEmptyFields() {
        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(DetaliApi.bodyLoginWithUsernameEmptyFields)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами логин в базе данных не найден."));
    }

    @Test
    public void testLoginWithEmailWrongCredentials() {
        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(DetaliApi.bodyLoginWithEmailWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами email в базе данных не найден."));
    }

    @Test
    public void testLoginWithPhoneWrongCredentials() {
        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(DetaliApi.bodyLoginWithPhoneWrongCredentials)
                .when().post(DetaliApi.url)
                .then().statusCode(401).body("errorMessage", equalTo("Указанный Вами телефон в базе данных не найден."));
    }

}
