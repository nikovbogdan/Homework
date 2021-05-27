package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTests {

    @BeforeMethod
    public void before() {
        Browser.open();
    }


    @AfterMethod
    public void after() {
        Browser.quit();
    }
}
