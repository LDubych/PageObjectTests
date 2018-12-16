import Pages.BasketPage;
import Pages.CheckoutShippingLoginPage;
import Pages.ShopPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasketTest extends Main {
    static int quantity = 2;
    static String expectedItemTitle;

    @Before
    public void setUpBasketTest() throws Exception {
        expectedItemTitle = searchPage.getSearchedItem();
        searchPage.clickItem();
        shopPage = new ShopPage(driver);
        shopPage.inputQuantity(quantity);
        shopPage.clickAddToBasketButton();
        shopPage.clickViewBasketButton();
        shopPage = null;
        basketPage = new BasketPage(driver);
    }

    @Test
    public void rightItemInBasket() {
        assertTrue(expectedItemTitle.equalsIgnoreCase(basketPage.getItemTitleText()));
    }

    @Test
    public void rightNumberOfItemsInBasket() {
        assertEquals(quantity, basketPage.getNumberOfItem());
    }

    @Test
    public void redirectToCheckoutPage() {
        String expectedURL = "https://decemberboys.com.ua/accounts/login/?next=/checkout/";
        basketPage.clickCheckoutButton();
        checkoutShippingLoginPage = new CheckoutShippingLoginPage(driver);
        assertEquals(expectedURL, checkoutShippingLoginPage.getPageURL());
        //assertTrue(checkoutShippingLoginPage.isLoginInfoMessagePresent());
    }

    @After
    public void tearDownBasketTest() {
        driver.manage().deleteAllCookies();
        driver.get(driver.getCurrentUrl());
    }
}
