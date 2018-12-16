package Pages;

import Locators.SearchedPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasicPage implements SearchedPageLocators {
    private String inputtedText;
    private WebElement searchedItem;
    public SearchPage(WebDriver driver, String inputtedText) {
        super(driver);
        this.inputtedText = inputtedText;
        this.searchedItem = driver.findElement(By.cssSelector(String.format(SEARCHED_ITEM_CSS, this.inputtedText)));
    }

    public String getItemTitle(int indexOfItem) {
        WebElement searchedItem = driver.findElement(By.cssSelector(String.format(".products-category .product-layout:nth-child(%d) .caption a", indexOfItem).trim()));
        return searchedItem.getText();
    }

    public String  getSearchedItem() {
        return searchedItem.getText().trim();
    }

    public boolean isSearchedItemFirstAtThePage() {
//        isElementPresent(searchedItem);
        return getSearchedItem().equals(getItemTitle(1));
    }

    public void clickItem() {
        searchedItem.click();
    }

}
