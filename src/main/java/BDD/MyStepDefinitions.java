package BDD;

import core.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.backend.AdminLoginPage;
import pages.backend.component.AdminHeader;
import pages.frontend.UserForgottenPasswordPage;
import pages.frontend.UserLoginPage;
import pages.frontend.UserHomePage;
import pages.frontend.UserPDP;
import pages.frontend.component.UserCartComponent;
import utils.Browser;

public class MyStepDefinitions extends Base {

    @Before
    public void beforeTest() {
        Browser.open();
    }

    @After
    public void afterTest() {
        Browser.quit();
    }

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String page) {
        if (page.equals("admin")) {
            AdminLoginPage.open();
        } else if (page.equals("user")) {
            UserHomePage.open();
        } else {
            try {
                throw new NoSuchMethodException(page);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println(page + " page doesn't exits.");
            }
        }
    }

    @When("user enters {string} and {string} and click OK - {string} account")
    public void user_enters_and_and_click_OK(String username, String password, String account) {
        if (account.equals("admin")) {
            AdminLoginPage.login(username, password);
        } else if (account.equals("user")) {
            UserLoginPage.login(username, password);
        } else {
            try {
                throw new NoSuchMethodException(account);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println(account + " account doesn't exits.");
            }
        }
    }

    @Then("ensure {string} is displayed on page header")
    public void ensure_is_displayed_on_page_header(String fullName) {
        AdminHeader.verifyUserFullName(fullName, "BUG");
    }

    @Then("ensure log out button is displayed on page header")
    public void ensure_log_out_button_is_displayed_on_page_header() {
        AdminHeader.verifyLogoutButtonIsDisplayed();
    }

    @Then("ensure RED message is displayed")
    public void ensureRedMessageIsDisplayed() {
        AdminLoginPage.verifyRedMessageIsDisplayed();
    }

    @And("ensure RED message has {string} text")
    public void ensureRedMessageHasText(String expectedRedText) {
        AdminLoginPage.verifyTextOfTheRedMessage(expectedRedText, "BUG");
    }

    @Then("ensure Edit Your Account hyperlink is displayed")
    public void ensureEditYourAccountHyperlinkIsDisplayed() {
        UserLoginPage.verifyEditYourAccountHyperlinkIsDisplayed();
    }

    @When("user clicks on Forgotten Password hyperlink")
    public void userClicksOnForgottenPasswordHyperlink() {
        UserLoginPage.forgottenPass();
    }

    @And("user enters {string} email, associated whit his account, to receive password reset link")
    public void userEntersEmailAssociatedWhitHisAccountToReceivePasswordResetLink(String email) {
        UserForgottenPasswordPage.enterEmail(email);
    }

    @Then("ensure GREEN message is displayed")
    public void ensureGREENMessageIsDisplayed() {
        UserLoginPage.verifyGreenMessageForgottenPasswordIsDisplayed();
    }

    @And("ensure GREEN message has {string} text")
    public void ensureGREENMessageHasStringText(String expectedText) {
        UserLoginPage.verifyGreenMessageForgottenPasswordContainsText(expectedText, "BUG");
    }


    @And("user views {string} product details")
    public void userViewsProductDetails(String item) {
        switch (item) {
            case "MacBook":
                UserHomePage.viewMacBookDetails();
                break;
            case "Iphone":
                UserHomePage.viewIphoneDetails();
                break;

            default:
                try {
                    throw new NoSuchMethodException(item);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    System.out.println(item + " item doesn't exits.");
                }
        }
    }

    @And("user changes the product quantity to {string}")
    public void userChangesTheProductQuantityTo(String quantity) {
        UserPDP.productQuantity(quantity);
    }

    @And("user adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        UserPDP.addToCart();
    }

    @Then("ensure the green message is displayed")
    public void ensureTheGreenMessageIsDisplayed() {
        UserPDP.verifyGreenMessageIsDisplayed();
    }

    @And("click on the cart component button")
    public void clickOnTheCartComponentButton() {
        UserCartComponent.clickOnCartButton();
    }


    @And("verify the {string} product is at the 1st place in the cart")
    public void verifyTheProductIsInTheCart(String product) {
        UserCartComponent.verifyTheTopItemInCartIs(product);
    }

    @And("verify the item quantity is {string}")
    public void verifyTheItemQuantityIs(String quantity) {
        UserCartComponent.verifyItemQuantity("x " + quantity);
    }

}
