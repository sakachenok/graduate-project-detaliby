package by.itacademy.akachenok.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DetaliApiTest {

    @Test
    public void testLoginWithUsernameWrongCredentials() {
        String bodyAsString = "{\"login\":\"test@test.com\",\"password\":\"test\"}";

        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(bodyAsString)
                .when().post("https://detali.by/api/v2/customer/login/")
                .then().assertThat().statusCode(401)
                .body("errorMessage", equalTo("Логин или пароль введены неверно"))
                .log().all();
    }

    @Test
    public void testLoginWithUsernameEmptyFields() {
        String bodyAsString = "{\"login\":\"\",\"password\":\"\"}";

        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(bodyAsString)
                .when().post("https://detali.by/api/v2/customer/login/")
                .then().assertThat().statusCode(401)
                .body("errorMessage", equalTo("Указанный Вами логин в базе данных не найден."))
                .log().all();
    }

    @Test
    public void testLoginWithEmailWrongCredentials() {
        String bodyAsString = "{\"email\":\"test@test.com\",\"password\":\"123\"}";

        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(bodyAsString)
                .when().post("https://detali.by/api/v2/customer/login/")
                .then().assertThat().statusCode(401)
                .body("errorMessage", equalTo("Указанный Вами email в базе данных не найден."))
                .log().all();
    }

    @Test
    public void testLoginWithPhoneWrongCredentials() {
        String bodyAsString = "{\"phone\":\"+375(22)222-22-22\",\"password\":\"1234556\"}";

        given().header("Content-Type", "text/plain;charset=UTF-8")
                .body(bodyAsString)
                .when().post("https://detali.by/api/v2/customer/login/")
                .then().assertThat().statusCode(401)
                .body("errorMessage", equalTo("Указанный Вами телефон в базе данных не найден."))
                .log().all();
    }

}
