package backend.positive;

import core.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.backend.AdminLoginPage;
import pages.backend.AdminPLP;
import pages.backend.component.AdminHeader;
import pages.backend.component.AdminNavigationBar;
import pages.backend.component.AdminPLPFilter;
import pages.frontend.component.UserSearchBar;
import pages.frontend.UserSearchListPage;
import utils.Browser;
import utils.Urls;

public class AdminAddNewAndRemoveItemTest extends BaseTests {

    @Test(testName = "TC0003 - Adding new item from Admin page and verify it is shown on User page after searching for it.")
    public static void addItemFromAdminPage() {
        AdminLoginPage.open();
        AdminLoginPage.login("admin", "parola123!");

        AdminHeader.verifyUserFullName("Milen Strahinski", "Wrong Full Name");

        AdminNavigationBar.selectCatalog();
        AdminNavigationBar.selectProducts();

        AdminPLP.addNewItem();
        AdminPLP.completeNewItemForm("Bogdan TEST PRODUCT", "<title> Bogdan </title>", "Bogdan");
        AdminPLP.verifyGreenMessageIsDisplayed();
        AdminPLP.verifyGreenMessageContainsText("Success: You have modified products!", "BUG");

        Browser.driver.get(Urls.USER_URL);
        UserSearchBar.searchFor("Bogdan TEST PRODUCT");
        Assert.assertTrue(UserSearchListPage.isProductDisplayed("Bogdan TEST PRODUCT"));


    }


    @Test(testName = "TC0004 - Removing item from Admin page and verify it is not shown on User page after searching for it.")
    public void removeItemFromAdminPage() {
        AdminLoginPage.open();
        AdminLoginPage.login("admin", "parola123!");

        AdminHeader.verifyUserFullName("Milen Strahinski", "Wrong Full Name");

        AdminNavigationBar.selectCatalog();
        AdminNavigationBar.selectProducts();

        AdminPLPFilter.searchForProductByName("Bogdan TEST PRODUCT");
//        AdminPLP.delete();
//        AdminPLP.delete(2);
        AdminPLP.deleteAll();

        AdminPLP.verifyGreenMessageIsDisplayed();
        AdminPLP.verifyGreenMessageContainsText("Success: You have modified products!", "BUG");

        Browser.driver.get(Urls.USER_URL);
        UserSearchBar.searchFor("Bogdan TEST PRODUCT");
        Assert.assertFalse(UserSearchListPage.isProductDisplayed("Bogdan TEST PRODUCT"));


    }

    @Test
    public void newMethod() {
        AdminAddNewAndRemoveItemTest.addItemFromAdminPage();
        Browser.driver.navigate().to("https://www.abv.bg/");
    }
}
