package by.itacademy.akachenok.domain;

import com.github.javafaker.Faker;

public class User {
    public static String getRandomUsername() {
        Faker faker = new Faker();
        return faker.name().username();
    }

    public static String getRandomCorrectEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomInvalidEmail() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String getRandomPhoneNumber() {
        return Long.toString((long) (Math.random() * 1000000000 * 100)) + Integer.toString((int) (Math.random() * 100));
    }

    public static String getRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String getTextForSearch() {
        return "TRICO FX550 ЩЕТКА СТЕКЛООЧИСТИТЕЛЯ";
    }

}
