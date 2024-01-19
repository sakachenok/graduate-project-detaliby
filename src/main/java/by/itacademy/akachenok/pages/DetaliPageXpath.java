package by.itacademy.akachenok.pages;

public class DetaliPageXpath {
    public static final String BUTTON_ENTER_MAIN_PAGE = "//span[text()='Войти']";
    public static final String INPUT_LOGIN = "//*[@id='login-input']";
    public static final String INPUT_PASSWORD = "//*[@id='password']";
    public static final String RADIO_BUTTON_EMAIL = "//*[@id='authemail']";
    public static final String RADIO_BUTTON_PHONE = "//*[@id='authphone']";
    public static final String BUTTON_ENTER_AUTH_FORM = "//*[@data-locator='login-button']";
    public static final String ERROR_MESSAGE_WRONG_CREDENTIALS = "//span[@class='error-notice__text wt-control-m wtm-caption']";
    public static final String ERROR_MESSAGE_INVALID_EMAIL_OR_PHONE_FORMAT = "//div[@class='w-input__error']";
    public static final String INPUT_SEARCH_FORM = "//*[@class='search-form__input']";
    public static final String BUTTON_SEARCH = "//*[@class='search-form__submit-svg']";
    public static final String TEXT_SEARCH_RESULT_SEARCH_PAGE = "//h2[@class='search-by-name__title wt-h-2 wtm-h-3']";
    public static final String LINK_SEARCH_BY_NAME_RESULTS = "//a[@href='/search.html?article=FX550&brand=TRICO&withAnalogs=1']";
    public static final String BUTTON_ADD_TO_CART = "/html/body/div[2]/main/div[2]/div/div/div[3]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/div[5]/button";
    public static final String BUTTON_CART = "//*[@id=\"main_inner_wrapper\"]/div[3]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/div[5]/a";
    public static final String TEXT_ITEM_IN_CART = "//*[@id=\"content_inner\"]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/p";
}