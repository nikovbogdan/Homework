package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.UserCartPage;
import pages.frontend.UserPDP;
import pages.frontend.UserHomePage;
import pages.frontend.component.UserCartComponent;
import pages.frontend.component.UserHeader;


public class UserCartPageTest extends BaseTests {

    @Test(testName = "TC #6")
    public void changeQuantity(){
        UserHomePage.open();
        UserHomePage.viewIphoneDetails();
        UserPDP.productQuantity("1");
        UserPDP.addToCart();
        UserPDP.verifyGreenMessageIsDisplayed();
        UserHeader.selectCart();
        UserCartPage.changeQuantityTo("3");
        UserCartPage.verifyGreenMessageIsDisplayed();
        UserCartComponent.clickOnCartButton();
        UserCartComponent.verifyItemQuantity("3");
    }
}
