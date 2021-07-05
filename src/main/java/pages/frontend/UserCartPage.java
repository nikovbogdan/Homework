package pages.frontend;

import core.Base;
import org.openqa.selenium.By;

public class UserCartPage extends Base {

    private final static By QUANTITY = By.xpath("//tr/td[4]/div/input");
    private final static By UPDATE_QUANTITY_BUTTON = By.xpath("//span/button[@type='submit']");
    private final static By GREEN_MESSAGE = By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]");

    /**
     * Puts values in Quantity input field and submits the change
     * @param quantity the new quantity
     */
    public static void changeQuantityTo(String quantity) {
        clear(QUANTITY);
        type(QUANTITY,quantity);
        click(UPDATE_QUANTITY_BUTTON);
    }

    /**
     * Verifies that the green message for success is displayed.
     */
    public static void verifyGreenMessageIsDisplayed() {
        isElementDisplayed(GREEN_MESSAGE);
    }
}
