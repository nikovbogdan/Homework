package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.List;

public class UserCartComponent extends Base {
    private static final By CART_BUTTON = By.id("cart-total");
    private static final By TOP_ITEM_IN_CART = By.xpath("//tbody/tr[1]/td[2]/a[1]");
    private static final By ALL_ITEMS_IN_CART = By.cssSelector(".table-striped");
    private static final By QUANTITY_IN_CART = By.xpath("//table[@class='table table-striped']/tbody/tr[1]/td[3]");

    /**
     * Clicks on Cart component Button
     */
    public static void clickOnCartButton() {
        click(CART_BUTTON);
    }

    /**
     * ensures that the TOP item in cart is as the one you expect.
     * @param expectedItem the item you expect to be at the first place in the cart.
     */
    public static void verifyTheTopItemInCartIs(String expectedItem) {
        elementHasText(TOP_ITEM_IN_CART,expectedItem,"BUG");
    }

    /**
     * Ensures that the cart contains a specific item.
     * @param expectedItem the item you expect to be in the cart.
     */
    public static void verifyItemIsInCart(String expectedItem) {
        elementContainsText(ALL_ITEMS_IN_CART,expectedItem,"BUG");
    }

    /**
     * Ensures the quantity of the first item in cart.
     * @param expectedQuantity the expected quantity.
     */
    public static void verifyFirstItemQuantity(String expectedQuantity) {
        elementContainsText(QUANTITY_IN_CART,expectedQuantity,"BUG");
    }

    /**
     * Prints all the items in cart in the IDE console.
     */
    public static void printAllItemsInCart() {
        List<WebElement> elements = Browser.driver.findElements(ALL_ITEMS_IN_CART);
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
