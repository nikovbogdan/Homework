package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Urls;

public class UserHomePage extends Base {

    private final static By MAC_BOOK_PRODUCT = By.xpath("//a[contains(text(),'MacBook')]");
    private final static By IPHONE_PRODUCT = By.xpath("//a[contains(text(),'iPhone')]");
    private final static By NAVIGATE_TO_HOME = By.xpath("//a[contains(text(),'Pragmatic Test Store')]");

    /**
     * Browser navigates to shop.pragmatic.bg
     */
    public static void open() {
        Browser.driver.get(Urls.USER_URL);
    }

    /**
     * Clicks on MacBook product at the home page
     */
    public static void viewMacBookDetails() {
        click(MAC_BOOK_PRODUCT);
    }

    /**
     * Clicks on Page Header (Pragmatic Test Store) to navigates to home page
     */
    public static void navigateToHome() {
        click(NAVIGATE_TO_HOME);
    }

    /**
     * Clicks on iPhone product at the home page
     */
    public static void viewIphoneDetails() {
        click(IPHONE_PRODUCT);
    }
}
