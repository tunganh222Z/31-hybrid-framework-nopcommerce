package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class PageGenratorManager {

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static CustomerPageObject getCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }
}
