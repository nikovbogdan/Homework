package pages.frontend.component;

import core.Base;
import org.openqa.selenium.By;

public class UserSearchBar extends Base {
    private final static By SEARCH_BAR_INPUT = By.name("search");
    private final static By SUBMIT_SEARCH = By.xpath("//span[@class='input-group-btn']");

    /**
     * Search for a product in the Product List.
     * @param productName the name of the searched product.
     */
    public static void searchFor(String productName) {
        type(SEARCH_BAR_INPUT,productName);
        click(SUBMIT_SEARCH);
    }
}
