package pages.backend.component;

import core.Base;
import org.openqa.selenium.By;

public class AdminPLPFilter extends Base {
    private final static By PRODUCT_NAME_INPUT = By.id("input-name");
    private final static By FILTER_SUBMIT_BUTTON = By.id("button-filter");


    /**
     * Search for specific product by Product Name.
     * @param searchedProductName the name of the product you are searching for.
     */
    public static void searchForProductByName(String searchedProductName) {
        type(PRODUCT_NAME_INPUT,searchedProductName);
        click(FILTER_SUBMIT_BUTTON);
    }
}
