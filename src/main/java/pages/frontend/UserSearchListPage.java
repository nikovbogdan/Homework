package pages.frontend;

import core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.List;

public class UserSearchListPage extends Base {
    private final static By SEARCHED_PRODUCTS = By.xpath("//h4");
    private final static By SEARCH_PAGE_HEADER = By.xpath("//h1[contains(text(),'Search')]");


    public static boolean isProductDisplayed(String expectedProduct) {

        List<WebElement> listOfProducts = Browser.driver.findElements(SEARCHED_PRODUCTS);
        for (WebElement product : listOfProducts) {
            if (product.getText().contains(expectedProduct)) {
                return product.isDisplayed();
            }

        }
        return false;
    }
}

