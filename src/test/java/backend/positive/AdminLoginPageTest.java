package backend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.backend.component.AdminHeader;
import pages.backend.AdminLoginPage;


public class AdminLoginPageTest extends BaseTests {

    @Test(testName = "TC0001 - Test that user can log in with valid credentials")
    public void verifyUserCanLogIn(){
        AdminLoginPage.open();
        AdminLoginPage.login("admin","parola123!");
        AdminHeader.verifyUserFullName("Milen Strahinski"
                ,"Wrong user Full Name!");
        AdminHeader.verifyLogoutButtonIsDisplayed();
    }

}
