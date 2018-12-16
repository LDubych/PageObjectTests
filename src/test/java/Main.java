import Pages.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;
    static String baseUrl = "https://decemberboys.com.ua/";

    static BasicPage basicPage;
    static SearchPage searchPage;
    static ShopPage shopPage;
    static BasketPage basketPage;
    static CheckoutShippingLoginPage checkoutShippingLoginPage;
    public static String textForSearch = "Bicycle Brick Box";

    @BeforeClass
    public static void beforeClass() throws Exception {
        /*
        *   In this case path to chromedriver.exe was written in System variable PATH.
        *   If you have different setting, please uncomment code below  and provide proper path to your driver.
        */
        // System.setProperty("webdriver.chrome.driver", "../path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        basicPage = new BasicPage(driver);
    }

    @Before
    public void setUp() throws Exception {
        basicPage.searchItem(textForSearch);
        searchPage = new SearchPage(driver, textForSearch);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
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
