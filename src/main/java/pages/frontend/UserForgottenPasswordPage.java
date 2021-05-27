package pages.frontend;

import core.Base;
import org.openqa.selenium.By;

public class UserForgottenPasswordPage extends Base {

    private static final By EMAIL_INPUT = By.id("input-email");
    private static final By SUBMIT_BUTTON = By.cssSelector(".btn-primary");

    /**
     * Enters the email of the user trying to reset the account password.
     * @param email users email.
     */
    public static void enterEmail(String email) {
        type(EMAIL_INPUT,email);
        click(SUBMIT_BUTTON);


    }
}
