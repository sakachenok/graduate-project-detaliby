package by.itacademy.akachenok.ui;

import by.itacademy.akachenok.domain.User;
import by.itacademy.akachenok.pages.DetaliSearch;
import by.itacademy.akachenok.pages.DetaliSearchStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DetaliSearchTest extends BaseTest{
    private  static final String EXPECTED_TITLE_SEARCH_BY_NAME = "Найдено по наименованию TRICO FX550 ЩЕТКА СТЕКЛООЧИСТИТЕЛЯ";
    private  static final String EXPECTED_TEXT_ITEM_IN_CART = "TRICO FX550";
    private static final Logger LOGGER = LogManager.getLogger();
    DetaliSearch detaliSearch = new DetaliSearch();
    DetaliSearchStep detaliSearchStep = new DetaliSearchStep();

    @Test
    public void testSearchByNameResultsOpened() {
        detaliSearchStep.enterTextInSearchFormAndSearch(User.getTextForSearch());
        LOGGER.info("Expected Title Search By Name : " + EXPECTED_TITLE_SEARCH_BY_NAME);
        Assertions.assertEquals(EXPECTED_TITLE_SEARCH_BY_NAME, detaliSearch.getTextTitleSearchByName());
    }

    @Test
    public void testSearchAndAddTheItemIntoTheCart() {
        detaliSearchStep.searchForTheItemAndAddItToTheCartAndOpenTheCart();
        LOGGER.info("Expected text for the item in the cart: " + EXPECTED_TEXT_ITEM_IN_CART);
        Assertions.assertEquals(EXPECTED_TEXT_ITEM_IN_CART, detaliSearch.getTextItemInCart());
    }

}
