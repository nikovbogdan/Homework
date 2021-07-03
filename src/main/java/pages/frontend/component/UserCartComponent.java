package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;

public class UserCartComponent extends Base {
    private static final By CART_BUTTON = By.id("cart-total");
    private static final By TOP_ITEM_IN_CART = By.xpath("//tbody/tr[1]/td[2]/a[1]");
    private static final By QUANTITY_IN_CART = By.xpath("//td[contains(text(),'x 1')]");

    /**
     * Clicks on Cart component Button
     */
    public static void clickOnCartButton() {
        click(CART_BUTTON);
    }

    public static void verifyItemIsInCart(String text) {
        elementContainsText(TOP_ITEM_IN_CART,text,"BUG");
    }

    public static void verifyItemQuantity(String quantity) {
        elementHasText(QUANTITY_IN_CART,quantity,"BUG");
    }
}
