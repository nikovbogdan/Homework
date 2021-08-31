package pages.backend.component;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminHeader extends Base {

    private final static By USER_FULL_NAME = By.cssSelector("li.dropdown >.dropdown-toggle");
    private final static By LOGOUT_BUTTON = By.xpath("//span[contains(@class,'hidden-xs hidden-sm hidden-md')]");

    /**
     * Asserts if the admin account full name that is shown next to the Logout buttons matches the expected.
     * @param expectedFullName the first and the last name of the User you expect to be shown in the header.
     * @param messageIfFails the message that will appear if the assert fails.
     */
    public static void verifyUserFullName(String expectedFullName,String messageIfFails) {
        elementContainsText(USER_FULL_NAME,expectedFullName,messageIfFails);
//        Assert.assertEquals(getTextOfTheElement(USER_FULL_NAME),expectedFullName,messageIfFails);
    }

    /**
     * Asserts if the logout button is displayed
     */
    public static void verifyLogoutButtonIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(LOGOUT_BUTTON));

    }


}
