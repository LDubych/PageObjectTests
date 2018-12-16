package Pages;

import Locators.BasketPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasicPage implements BasketPageLocators {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = ITEMS_QUANTITY_FIELD_ID)
    WebElement itemQuantityField;

    @FindBy(css = DELETE_BUTTON_CSS)
    WebElement deleteButton;

    @FindBy(css = CHECKOUT_BUTTON_CSS)
    WebElement checkoutButton;

    @FindBy(css = ITEM_LINK_CSS)
    WebElement itemTitle;

    public int getNumberOfItem() {
        return Integer.valueOf(itemQuantityField.getAttribute("value"));
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public String getItemTitleText() {
        return itemTitle.getText().trim();
    }
}
