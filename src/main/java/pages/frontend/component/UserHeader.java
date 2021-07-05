package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;

public class UserHeader extends Base {

    private final static By SHOPPING_CART_HEADER = By.xpath("//span[contains(text(),'Shopping Cart')]");


    public static void selectCart() {
        click(SHOPPING_CART_HEADER);
    }
}
