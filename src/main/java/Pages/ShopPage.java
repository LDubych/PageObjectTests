package Pages;

import Locators.ShopPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage  extends BasicPage implements ShopPageLocators {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = QUANTITY_FIELD_ID)
    WebElement quantityField;

    @FindBy(id = ADD_TO_BASKET_BUTTON_ID)
    WebElement addToBasketButton;

    @FindBy(css = VIEW_BASKET_BUTTON_CSS)
    WebElement viewBasketButton;

    @FindBy(css = PRODUCT_TITLE_CSS)
    WebElement productTitle;

    @FindBy(css = ALERT_INFO_CSS)
    WebElement alertInfo;

    public void inputQuantity(int quantity) {
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public boolean isAddToBasketButtonPresent() {
        return isElementPresent(By.cssSelector(".product-title h1"));
    }

    public boolean isViewBasketButtonPresent() {
        return isElementPresent(By.cssSelector(VIEW_BASKET_BUTTON_CSS));
    }

    public void clickAddToBasketButton(){
        if (isAddToBasketButtonPresent()){
            addToBasketButton.click();
        }
        else{
            throw new NullPointerException();
        }
    }

    public void clickViewBasketButton() {
        viewBasketButton.click();
    }

    public String getProductTitle(){
        return productTitle.getText().trim();
    }

    public WebElement getAlertInfo() {
        return alertInfo;
    }
}
