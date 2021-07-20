package pages.backend;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;
import utils.Waiter;

public class AdminPLP extends Base {
    private static final By ADD_NEW_ITEM_BUTTON = By.cssSelector(".fa-plus");
    private static final By NEW_PRODUCT_NAME_INPUT = By.id("input-name1");
    private static final By NEW_PRODUCT_META_TAG_INPUT = By.id("input-meta-title1");
    private static final By DATA_TAB = By.xpath("//ul[contains(@class,'nav-tabs')]/li[2]");
    private static final By NEW_PRODUCT_MODEL_INPUT = By.id("input-model");
    private static final By SAVE_BUTTON = By.cssSelector(".fa-save");
    private static final By GREEN_MESSAGE = By.cssSelector(".alert-success");
    private static final By DELETE_ITEM_BUTTON = By.xpath("//i[@class='fa fa-trash-o']");

    /**
     * Clicks on + button ("ADD NEW") when on PLP.
     */
    public static void addNewItem() {
        click(ADD_NEW_ITEM_BUTTON);
    }

    /**
     * Fills the New Item Form and clicks SAVE.
     * @param productName enters a name for a product
     * @param metaTag enters meta tag for a product
     * @param model enters the model of a product
     */
    public static void completeNewItemForm(String productName,String metaTag,String model) {
        type(NEW_PRODUCT_NAME_INPUT,productName);
        type(NEW_PRODUCT_META_TAG_INPUT,metaTag);
        click(DATA_TAB);
        type(NEW_PRODUCT_MODEL_INPUT,model);
        click(SAVE_BUTTON);
    }

    /**
     * Ensures that the message for newly created item is displayed.
     */
    public static void verifyGreenMessageIsDisplayed() {
         Assert.assertTrue(isElementDisplayed(GREEN_MESSAGE));
    }

    /**
     * Ensures the message for newly created item contains specific text.
     * @param expectedMessage the message you expect to be shown in green message.
     * @param ifNot if the message is not as the expected.
     */
    public static void verifyGreenMessageContainsText(String expectedMessage,String ifNot) {
        Assert.assertTrue(Browser.driver.findElement(GREEN_MESSAGE).getText().contains(expectedMessage));
    }

    /**
     * Delete item from PLP list by index.
      * @param index index of the product you want to delete.
     */
    public static void delete(int index) {
        Browser.driver.findElement(By.xpath("//tbody/tr["+index +"]/td[1]/input[1]")).click();
        Waiter.waitFor(1);
        click(DELETE_ITEM_BUTTON);
        Browser.driver.switchTo().alert().accept();

    }

    /**
     * Deletes the first product from PLP list.
     */
    public static void delete() {
        Browser.driver.findElement(By.xpath("//tbody/tr["+ 1 +"]/td[1]/input[1]")).click();
        Waiter.waitFor(1);
        click(DELETE_ITEM_BUTTON);
        Browser.driver.switchTo().alert().accept();
    }

    /**
     * Deletes all products from PLP list.
     */
    public static void deleteAll() {
        Browser.driver.findElement(By.xpath("//thead/tr[1]/td[1]/input[1]")).click();
        Waiter.waitFor(1);
        click(DELETE_ITEM_BUTTON);
        Browser.driver.switchTo().alert().accept();
    }
}

