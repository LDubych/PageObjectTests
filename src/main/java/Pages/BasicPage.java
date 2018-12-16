package Pages;

import Locators.BasicPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPage implements BasicPageLocators {
    public WebDriver driver;

    public BasicPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = SEARCH_FIELD_ID)
    WebElement searchField;

    @FindBy(id = SEARCH_BUTTON_ID)
    WebElement searchButton;

    @FindBy(id = CART_TOTAL_ID)
    WebElement cartTotal;

    public void inputSearchText(String item) {
        searchField.clear();
        searchField.sendKeys(item);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchItem(String item){
        inputSearchText(item);
        clickSearchButton();
    }


    public int getCartTotal() {
        if (isElementPresent(By.id(CART_TOTAL_ID))) {
            String text = cartTotal.getText().trim();
            return Integer.valueOf(text.substring(0, text.indexOf(" ")));
        }
        else {
            return -1;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}