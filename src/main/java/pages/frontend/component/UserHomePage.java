package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Urls;

public class UserHomePage extends Base {

    private final static By MAC_BOOK_PRODUCT = By.xpath("//a[contains(text(),'MacBook')]");

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
}
