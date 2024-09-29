package pageObjects.user;

import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driverPageObject;

    public UserLoginPageObject(WebDriver driverPageObject) {
        this.driverPageObject = driverPageObject;
    }

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driverPageObject, UserLoginPageUI.EMAIL_TEXTBOX, keyToSend);
    }

    public void enterToPasswordTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driverPageObject, UserLoginPageUI.PASSWORD_TEXTBOX, keyToSend);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driverPageObject, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driverPageObject, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenratorManager.getHomePage(driverPageObject);
    }
}
