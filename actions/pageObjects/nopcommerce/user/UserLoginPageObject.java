package pageObjects.nopcommerce.user;

import commons.BaseElements;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BaseElements {
    WebDriver driverPageObject;

    public UserLoginPageObject(WebDriver driverPageObject) {
        super(driverPageObject);
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
        return PageGeneratorManager.getHomePage(driverPageObject);
    }
}
