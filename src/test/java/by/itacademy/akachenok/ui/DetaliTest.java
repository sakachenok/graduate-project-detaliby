package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliPage;
import by.itacademy.akachenok.pages.DetaliStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DetaliTest extends BaseTest {
    DetaliPage detaliPage = new DetaliPage();
    DetaliStep detaliStep = new DetaliStep();

    @Test
    public void testLoginFormByUsernameWrongCredentials() {
        detaliStep.openLoginFormByUsernameFillAndSubmit(User.getRandomUsername(),User.getRandomPassword());
        Assertions.assertEquals("Логин или пароль введены неверно", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailWrongCredentials() {
        detaliStep.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами email в базе данных не найден.", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByEmailInvalidEmailFormat() {
        detaliStep.openLoginFormByEmailAndFill(User.getRandomInvalidEmail(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите правильный email-адрес. Для примера \"test@domain.com\"", detaliPage.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testLoginFormByPhoneWrongCredentials() {
        detaliStep.openLoginFormByPhoneFillAndSubmit(User.getRandomPhoneNumber(), User.getRandomPassword());
        Assertions.assertEquals("Указанный Вами телефон в базе данных не найден.", detaliPage.getTextErrorMessageWrongCredentials());
    }

    @Test
    public void testLoginFormByPhoneInvalidPhoneFormat() {
        detaliStep.openLoginFormByPhoneAndFill(User.getRandomPassword(), User.getRandomPassword());
        Assertions.assertEquals("Пожалуйста, введите номер в международном формате.", detaliPage.getTextErrorMessageInvalidEmailOrPhoneFormat());
    }

    @Test
    public void testSearchByNameResultsOpened() {
        detaliStep.enterTextInSearchFormAndSearch(User.getTextForSearch());
        Assertions.assertEquals("Найдено по наименованию TRICO FX550 ЩЕТКА СТЕКЛООЧИСТИТЕЛЯ", detaliPage.getTextTitleSearchByName());
    }

    @Test
    public void testAddTheItemIntoTheCart() {
        detaliStep.searchForTheItemAndAddItToTheCartAndOpenTheCart();
        Assertions.assertEquals("TRICO FX550", detaliPage.getTextItemInCart());
    }

}
