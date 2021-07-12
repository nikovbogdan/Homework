package pages.frontend;

import core.Base;
import org.openqa.selenium.By;
import utils.Waiter;

public class UserPDP extends Base {


    private static final By ADD_TO_CART_BUTTON = By.id("button-cart");
    private static final By QUANTITY_INPUT = By.id("input-quantity");
    private static final By GREEN_MESSAGE = By.xpath("//body/div[@id='product-product']/div[1]");


    /**
     * Clicks on Add to Cart button.
     */
    public static void addToCart() {
        click(ADD_TO_CART_BUTTON);
    }

    /**
     * Types the preferred quantity for the product.
     * @param quantity (SET AS A STRING)
     */
    public static void productQuantity(String quantity) {
        clear(QUANTITY_INPUT);
        type(QUANTITY_INPUT,quantity);
    }

    /**
     * Ensures the Success message is displayed.
     */
    public static void verifyGreenMessageIsDisplayed() {
        isElementDisplayed(GREEN_MESSAGE);
        Waiter.waitFor(1);
    }

}
