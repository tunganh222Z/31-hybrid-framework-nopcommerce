package pageObjects.saucelab;

import commons.BaseElements;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import saucelab.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject (WebDriver driver){
        this.driver = driver;
    }

    public void enterToUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX , userName);
    }

    public void enterToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public ProductPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getProductPage(driver);
    }
}
