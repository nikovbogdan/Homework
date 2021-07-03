package frontend.positive;

import core.BaseTests;
import pages.frontend.UserPDP;
import org.testng.annotations.Test;
import pages.frontend.component.UserCartComponent;
import pages.frontend.UserHomePage;
import utils.Waiter;

public class UserCartComponentTest extends BaseTests {

    @Test
    public void addItemToCart(){
        UserHomePage.open();
        UserHomePage.viewMacBookDetails();
        UserPDP.productQuantity("1");
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyTheTopItemInCartIs("MacBook");
        UserCartComponent.verifyItemQuantity("x 1");
    }
    @Test
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
        Waiter.waitFor(2);
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyItemIsInCart("iPhone");
        UserCartComponent.printAllItemsInCart();


    }
}
