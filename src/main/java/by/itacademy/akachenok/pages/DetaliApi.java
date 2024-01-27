package by.itacademy.akachenok.pages;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DetaliApi {
    public static final String BODY_LOGIN_WITH_USERNAME_WRONG_CREDENTIALS = "{\"login\":\"test@test.com\",\"password\":\"test\"}";
    public static final String BODY_LOGIN_WITH_USERNAME_EMPTY_FIELDS = "{\"login\":\"\",\"password\":\"\"}";
    public static final String BODY_LOGIN_WITH_EMAIL_WRONG_CREDENTIALS = "{\"email\":\"test@test.com\",\"password\":\"123\"}";
    public static final String BODY_LOGIN_WITH_PHONE_WRONG_CREDENTIALS = "{\"phone\":\"+375(22)222-22-22\",\"password\":\"1234556\"}";
    public static final String URL = "https://detali.by/api/v2/customer/login/";

    public static RequestSpecification getHeaderContentTypeTextPlainUTF8() {
        RequestSpecification header = given()
                .contentType("text/plain;charset=UTF-8");
        return header;
    }

}
