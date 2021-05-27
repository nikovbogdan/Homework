package pages.backend.component;

import core.Base;
import org.openqa.selenium.By;

public class AdminNavigationBar extends Base {
    private final static By NAVIGATION_BAR = By.id("column-left");
    private static final By CATALOG_MENU_NAVIGATION_BAR = By.id("menu-catalog");
    private static final By PRODUCTS_CATALOG_MENU = By.xpath("//*[@id='collapse1']/li[2]");
    private static final By CATALOG_EXPANDED_MENU = By.xpath("//ul[starts-with(@id,'collapse1') and (contains(@class,'collapse in'))]");

    /**
     * Selects "CATALOG" from NavigationBar
     */
    public static void selectCatalog() {
        if (isElementDisplayed(NAVIGATION_BAR)) {
            click(CATALOG_MENU_NAVIGATION_BAR);
        }
    }

    /**
     * Selects "PRODUCTS" from NavigationBar/Catalog
     */
    public static void selectProducts() {
       if (isElementDisplayed(NAVIGATION_BAR) && isElementDisplayed(CATALOG_EXPANDED_MENU)) {
           click(PRODUCTS_CATALOG_MENU);
       }
    }


}
