package frontend.positive;

import core.BaseTests;
import pages.frontend.UserPDP;
import org.testng.annotations.Test;
import pages.frontend.component.UserCartComponent;
import pages.frontend.UserHomePage;

public class UserCartComponentTest extends BaseTests {

    @Test(testName = "TC #3")
    public void addItemToCart(){
        UserHomePage.open();
        UserHomePage.viewMacBookDetails();
        UserPDP.productQuantity("1");
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyTheTopItemInCartIs("MacBook");
        UserCartComponent.verifyFirstItemQuantity("x 1");
    }
    @Test(testName = "TC #5")
    public void addItemToCart2(){
        UserHomePage.open();
        UserHomePage.viewMacBookDetails();
        UserPDP.productQuantity("1");
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserHomePage.navigateToHome();
        UserHomePage.viewIphoneDetails();
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyItemIsInCart("iPhone");
        UserCartComponent.printAllItemsInCart();


    }
}
