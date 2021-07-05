package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.UserForgottenPasswordPage;
import pages.frontend.UserHomePage;
import pages.frontend.UserLoginPage;

public class UserLoginTest extends BaseTests {

    @Test(testName = "TC0005 - Log in with valid User account(frontend)")
    public void loginUserPage(){
        UserHomePage.open();
        UserLoginPage.login("bogdan@mailinator.com","Pass123!");
        UserLoginPage.verifyEditYourAccountHyperlinkIsDisplayed();

    }

    @Test(testName = "TC0006 - Forgotten Password hyperlink(valid user account)")
    public void forgottenPass(){
        UserHomePage.open();
        UserLoginPage.forgottenPass();
        UserForgottenPasswordPage.enterEmail("bogdan@mailinator.com");
        UserLoginPage.verifyGreenMessageForgottenPasswordIsDisplayed();
        UserLoginPage.verifyGreenMessageForgottenPasswordContainsText("An email with a confirmation link has been sent your email address.","BUG");
    }
}
