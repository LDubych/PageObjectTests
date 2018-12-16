import Pages.ShopPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddItemToBasket extends Main {


    @Before
    public void setUpAddItemToBasket() throws Exception {
        searchPage.clickItem();
        shopPage = new ShopPage(driver);
    }

    @Test
    public void viewBasketButtonAppearance() {
        int quantity = 2;
        shopPage.inputQuantity(quantity);
        shopPage.clickAddToBasketButton();
        assertTrue(shopPage.isViewBasketButtonPresent());
    }

    @Test
    public void addingToBasket() {
        int quantity = 2;
        shopPage.inputQuantity(quantity);
        shopPage.clickAddToBasketButton();
        assertEquals(shopPage.getCartTotal(), quantity);
    }

    @After
    public void tearDownAddItemToBasket() {
        driver.manage().deleteAllCookies();
        driver.get(driver.getCurrentUrl());
        shopPage = null;
    }

}
