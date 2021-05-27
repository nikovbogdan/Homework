package pages.frontend.component;

import core.Base;
import utils.Browser;
import utils.Urls;

public class UserHomePage extends Base {

    /**
     * Browser navigates to shop.pragmatic.bg
     */
    public static void open() {
        Browser.driver.get(Urls.USER_URL);
    }
}
