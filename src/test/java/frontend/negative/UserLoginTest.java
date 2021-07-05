package frontend.negative;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.UserForgottenPasswordPage;
import pages.frontend.UserHomePage;
import pages.frontend.UserLoginPage;

public class UserLoginTest extends BaseTests {

    @Test(testName = "TC0007 - Log in with invalid User account(frontend)")
    public void loginUserPage(){
        UserHomePage.open();
        UserLoginPage.login("bo@mailinator.com","Pass123!");
        UserLoginPage.verifyRedMessageInvalidLoginIsDisplayed();
        UserLoginPage.verifyRedMessageInvalidLoginContainsText("Warning: No match for E-Mail Address and/or Password.","BUG");

    }

    @Test(testName = "TC0008 - Forgotten Password hyperlink(invalid user account)")
    public void forgottenPass(){
        UserHomePage.open();
        UserLoginPage.forgottenPass();
        UserForgottenPasswordPage.enterEmail("bo@mailinator.com");
        UserLoginPage.verifyRedMessageInvalidLoginIsDisplayed();
        UserLoginPage.verifyRedMessageInvalidLoginContainsText("Warning: The E-Mail Address was not found in our records, please try again!","BUG");
    }
}