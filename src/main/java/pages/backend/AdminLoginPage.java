package pages.backend;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;
import utils.Urls;


public class AdminLoginPage extends Base {

    private final static By USERNAME_INPUT = By.id("input-username");
    private final static By PASSWORD_INPUT = By.id("input-password");
    private final static By SUBMIT_BUTTON = By.cssSelector(".btn-primary");
    private final static By ALERT_RED_MESSAGE_DIV = By.cssSelector(".alert-danger");
    /**
     * Browser navigates to shop.pragmatic.bg/admin
     */
    public static void open() {
        Browser.driver.get(Urls.ADMIN_URL);
    }
    /**
     * Login to admin area with provided credentials
     * @param username the username you would like to login with.
     * @param password the password you would like to login with.
     */
    public static void login(String username, String password) {
        type(USERNAME_INPUT,username);
        type(PASSWORD_INPUT,password);
        click(SUBMIT_BUTTON);
    }
    /**
     * Verifies the validation(RED) message is displayed.
     */
    public static void verifyRedMessageIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(ALERT_RED_MESSAGE_DIV));
    }
    /**
     * Verifies the text in the validation(RED) message is as the expected.
     * @param expectedMessage the message we expect to be shown
     */
    public static void verifyTextOfTheRedMessage(String expectedMessage,String ifNot) {
        elementContainsText(ALERT_RED_MESSAGE_DIV,expectedMessage,ifNot);
    }
}
