package by.itacademy.akachenok.pages;

public class DetaliApi {
    public static String bodyLoginWithUsernameWrongCredentials = "{\"login\":\"test@test.com\",\"password\":\"test\"}";
    public static String bodyLoginWithUsernameEmptyFields = "{\"login\":\"\",\"password\":\"\"}";
    public static String bodyLoginWithEmailWrongCredentials = "{\"email\":\"test@test.com\",\"password\":\"123\"}";
    public static String bodyLoginWithPhoneWrongCredentials = "{\"phone\":\"+375(22)222-22-22\",\"password\":\"1234556\"}";
    public static String url = "https://detali.by/api/v2/customer/login/";


}
