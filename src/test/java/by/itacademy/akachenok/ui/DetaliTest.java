package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DetaliTest extends BaseTest {

    @Test
    public void testLoginFormByUsernameWrongCredentials() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.openLoginFormByUsernameFillAndSubmit(User.getRandomUsername(), User.getRandomPassword());
        Assertions.assertEquals("Логин или пароль введены неверно", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailWrongCredentials() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами email в базе данных не найден.", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailInvalidEmailFormat() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.openLoginFormByEmailAndFill(User.getRandomInvalidEmail(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите правильный email-адрес. Для примера \"test@domain.com\"", detaliPage.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testLoginFormByPhoneWrongCredentials() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.openLoginFormByPhoneFillAndSubmit(User.getRandomPhoneNumber(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами телефон в базе данных не найден.", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByPhoneInvalidPhoneFormat() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.openLoginFormByPhoneAndFill(User.getRandomPassword(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите номер в международном формате.", detaliPage.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testSearchByNameResultsOpened() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.enterTextInSearchFormAndSearch(User.getTextForSearch());
        Assertions.assertEquals("Найдено по наименованию TRICO FX550 ЩЕТКА СТЕКЛООЧИСТИТЕЛЯ", detaliPage.getTextTitleSearchByName());
    }

    @Test
    public void testAddTheItemIntoTheCart() {
        DetaliPage detaliPage = new DetaliPage();
        detaliPage.searchForTheItemAndAddItToTheCartAndOpenTheCart();
        Assertions.assertEquals("TRICO FX550", detaliPage.getTextItemInCart());
    }

}
