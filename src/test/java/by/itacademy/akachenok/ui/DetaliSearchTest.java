package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliSearch;
import by.itacademy.akachenok.pages.DetaliSearchStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DetaliSearchTest extends BaseTest{
    DetaliSearch detaliSearch = new DetaliSearch();
    DetaliSearchStep detaliSearchStep = new DetaliSearchStep();

    @Test
    public void testSearchByNameResultsOpened() {
        detaliSearchStep.enterTextInSearchFormAndSearch(User.getTextForSearch());
        Assertions.assertEquals("Найдено по наименованию TRICO FX550 ЩЕТКА СТЕКЛООЧИСТИТЕЛЯ", detaliSearch.getTextTitleSearchByName());
    }

    @Test
    public void testAddTheItemIntoTheCart() {
        detaliSearchStep.searchForTheItemAndAddItToTheCartAndOpenTheCart();
        Assertions.assertEquals("TRICO FX550", detaliSearch.getTextItemInCart());
    }

}
