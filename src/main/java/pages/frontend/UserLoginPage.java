package pages.frontend;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserLoginPage extends Base {
    private final static By MY_ACCOUNT_DROPDOWN = By.xpath("//span[@class='caret']");
    private final static By LOGIN_MY_ACCOUNT_DROPDOWN = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]");
    private final static By EMAIL_ADDRESS_INPUT = By.id("input-email");
    private final static By PASSWORD_INPUT = By.id("input-password");
    private final static By SUBMIT_LOGIN_BUTTON = By.xpath("//input[@type='submit']");
    private final static By EDIT_YOUR_ACCOUNT_HYPERLINK = By.xpath("//ul[@class='list-unstyled']//li[1]/a[contains(text(),'Edit your account')]");
    private final static By FORGOTTEN_PASSWORD_HYPERLINK = By.xpath("//div[@class='form-group'][2]/a");
    private final static By GREEN_MESSAGE_FORGOTTEN_PASS = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private final static By RED_MESSAGE_INVALID_USERNAME_OR_PASSWORD = By.cssSelector(".alert-danger");

    /**
     * Login to user area with provided credentials
     * @param emailAddress the email address you would like to login with.
     * @param password the password you would like to login with.
     */
    public static void login(String emailAddress, String password) {
        click(MY_ACCOUNT_DROPDOWN);
        click(LOGIN_MY_ACCOUNT_DROPDOWN);
        type(EMAIL_ADDRESS_INPUT, emailAddress);
        type(PASSWORD_INPUT, password);
        click(SUBMIT_LOGIN_BUTTON);
    }

    /**
     * Verifies the "Edit your account" hyperlink is visible when user is logged in.
     */
    public static void verifyEditYourAccountHyperlinkIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(EDIT_YOUR_ACCOUNT_HYPERLINK));
    }

    /**
     * Clicks on "Forgotten Password" hyperlink at the User Login page.
     */
    public static void forgottenPass() {
        click(MY_ACCOUNT_DROPDOWN);
        click(LOGIN_MY_ACCOUNT_DROPDOWN);
        click(FORGOTTEN_PASSWORD_HYPERLINK);
    }

    /**
     * Verifies the validation(GREEN) message is displayed.
     */
    public static void verifyGreenMessageForgottenPasswordIsDisplayed() {
       Assert.assertTrue(isElementDisplayed(GREEN_MESSAGE_FORGOTTEN_PASS));
    }
    /**
     * Verifies the text in the validation(GREEN) message is as the expected.
     * @param expectedMessage the message we expect to be shown
     */
    public static void verifyGreenMessageForgottenPasswordContainsText(String expectedMessage, String ifNot) {
        elementContainsText(GREEN_MESSAGE_FORGOTTEN_PASS,expectedMessage,ifNot);
    }
    /**
     * Verifies the validation(RED) message is displayed.
     */
    public static void verifyRedMessageInvalidLoginIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(RED_MESSAGE_INVALID_USERNAME_OR_PASSWORD));
    }
    /**
     * Verifies the text in the validation(GREEN) message is as the expected.
     * @param expectedMessage the message we expect to be shown
     */
    public static void verifyRedMessageInvalidLoginContainsText(String expectedMessage, String ifNot) {
        elementContainsText(RED_MESSAGE_INVALID_USERNAME_OR_PASSWORD,expectedMessage,ifNot);
    }

}
