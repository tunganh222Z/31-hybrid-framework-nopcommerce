package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PageGenerator extends BasePage {
    WebDriver driver;


    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static ProductPageObject getProductPage(WebDriver driver) {
        return new ProductPageObject(driver);
    }
}
