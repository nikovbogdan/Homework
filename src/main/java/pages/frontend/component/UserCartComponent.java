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
    private static final By QUANTITY_IN_CART = By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]");

    /**
     * Clicks on Cart component Button
     */
    public static void clickOnCartButton() {
        click(CART_BUTTON);
    }

    public static void verifyTheTopItemInCartIs(String text) {
        elementHasText(TOP_ITEM_IN_CART,text,"BUG");
    }
    public static void verifyItemIsInCart(String text) {
        elementContainsText(ALL_ITEMS_IN_CART,text,"BUG");
    }


    public static void verifyItemQuantity(String quantity) {
        elementContainsText(QUANTITY_IN_CART,quantity,"BUG");
    }


    public static void printAllItemsInCart() {
        List<WebElement> elements = Browser.driver.findElements(ALL_ITEMS_IN_CART);
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
