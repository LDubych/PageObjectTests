import Pages.ShopPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SearchItemTest extends Main {

    @Test
    public void searchingItemFirstInList() {
        assertTrue(searchPage.isSearchedItemFirstAtThePage());
    }

    @Test
    public void openSearchedItem() {
        ShopPage shopPage = new ShopPage(driver);
        String itemTitle = searchPage.getItemTitle(1);
        searchPage.clickItem();
        assertTrue(itemTitle.equalsIgnoreCase(shopPage.getProductTitle()));
    }
}
