package core;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class Base {
    /**
     * .clear method on located WebElement.
     * @param locator type By locator.
     */
    protected static void clear(By locator) {
        Browser.driver.findElement(locator).clear();
    }


    /**
     * .click method on located WebElement.
     * @param locator type By locator.
     */
    protected static void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    /**
     * .sendKeys method on located WebElement.
     * @param locator type By locator.
     * @param text the text you want to enter.
     */
    protected static void type(By locator, String text) {
        Browser.driver.findElement(locator).sendKeys(text);
    }

    /**
     * Gets the visible text of the located WebElement.
     * @param locator type By locator.
     * @return the text of the WebElement.
     */
    protected static String getTextOfTheElement(By locator) {
        return Browser.driver.findElement(locator).getText();
    }

    /**
     * Asserts is this element displayed or not.
     * @param locator type By locator.
     */
    protected static boolean isElementDisplayed(By locator) {
        return Browser.driver.findElement(locator).isDisplayed();
    }

    /**
     * Asserts does element contains expectedText or not.
     * @param locator type By locator.
     * @param expectedText the text you
     * @param ifNot the message to display if the element doesn't contains the expected text.
     */
    protected static void elementContainsText(By locator, String expectedText,String ifNot){
        Assert.assertTrue(Browser.driver.findElement(locator).getText().contains(expectedText),ifNot);
    }
    /**
     * Asserts does element HAS expectedText or not.
     * @param locator type By locator.
     * @param expectedText the text you
     * @param ifNot the message to display if the element doesn't contains the expected text.
     */
    protected static void elementHasText(By locator, String expectedText,String ifNot){
        Assert.assertEquals(Browser.driver.findElement(locator).getText(),expectedText,ifNot);
    }

}
