package pageObjects.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePage {
    WebDriver driver;
    public SearchPageObject (WebDriver driver){
        this.driver = driver;
    }

}
