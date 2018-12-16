package Pages;

import Locators.CheckoutShippingLoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutShippingLoginPage extends BasicPage implements CheckoutShippingLoginPageLocators {
    private String pageURL;
    public CheckoutShippingLoginPage(WebDriver driver) {
        super(driver);
        this.pageURL = driver.getCurrentUrl();
    }

    @FindBy(id = LOGIN_INFO_MESSAGE)
    WebElement loginInfoMessage;

    public WebElement getLoginInfoMessageElement() {
        return loginInfoMessage;
    }

    public boolean isLoginInfoMessagePresent() {
        return isElementPresent(By.id(LOGIN_INFO_MESSAGE));
    }

    public String getPageURL() {
        return pageURL;
    }
}
