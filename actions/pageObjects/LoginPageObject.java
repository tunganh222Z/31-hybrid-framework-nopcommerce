package pageObjects;

import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driverPageObject;

    public LoginPageObject(WebDriver driverPageObject) {
        this.driverPageObject = driverPageObject;
    }

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driverPageObject, LoginPageUI.EMAIL_TEXTBOX, keyToSend);
    }

    public void enterToPasswordTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driverPageObject, LoginPageUI.PASSWORD_TEXTBOX, keyToSend);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driverPageObject, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driverPageObject, LoginPageUI.LOGIN_BUTTON);
        return PageGenratorManager.getHomePage(driverPageObject);
    }
}
