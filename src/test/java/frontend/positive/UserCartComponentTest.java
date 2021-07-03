package frontend.positive;

import core.BaseTests;
import pages.frontend.UserPDP;
import org.testng.annotations.Test;
import pages.frontend.component.UserCartComponent;
import pages.frontend.component.UserHomePage;

public class UserCartComponentTest extends BaseTests {

    @Test
    public void addItemToCart(){
        UserHomePage.open();
        UserHomePage.viewMacBookDetails();
        UserPDP.productQuantity("1");
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyItemIsInCart("MacBook");
        UserCartComponent.verifyItemQuantity("x 1");


    }
}
