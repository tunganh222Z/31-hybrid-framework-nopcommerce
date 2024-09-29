package pageObjects.user;

import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driverPageObject;

    public RegisterPageObject(WebDriver driverPageObject) {
        this.driverPageObject = driverPageObject;
    }

    public void enterToFirstNameTextBox(String keyToSend) {
        waitForElementVisible(driverPageObject, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driverPageObject, RegisterPageUI.FIRSTNAME_TEXTBOX, keyToSend);
    }

    public void enterToLastNameTextBox(String keyToSend) {
        waitForElementVisible(driverPageObject, RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driverPageObject, RegisterPageUI.LASTNAME_TEXTBOX, keyToSend);
    }

    public void enterToEmailTextBox(String keyToSend) {
        waitForElementVisible(driverPageObject, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driverPageObject, RegisterPageUI.EMAIL_TEXTBOX, keyToSend);
    }

    public void enterToPasswordTextBox(String keyToSend) {
        waitForElementVisible(driverPageObject, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driverPageObject, RegisterPageUI.PASSWORD_TEXTBOX, keyToSend);
    }

    public void enterToConfirmPasswordTextBox(String keyToSend) {
        waitForElementVisible(driverPageObject, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driverPageObject, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, keyToSend);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driverPageObject, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driverPageObject, RegisterPageUI.REGISTER_BUTTON);
    }

    public HomePageObject clickToNopcommerceLogo() {
        waitForElementClickable(driverPageObject, RegisterPageUI.NOPCOMMERCE_LOGO);
        clickToElement(driverPageObject, RegisterPageUI.NOPCOMMERCE_LOGO);
        return new HomePageObject(driverPageObject);
    }

    public String getEmailErrorMsgText() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.EMAIL_ERROR_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    public String getRegistrationCompletedMsg() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }

    public String getFirstNameErrorMsgText() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMsgText() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getConfirmPasswordErrorMsgText() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.CONFIRM_PASSWORD_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.CONFIRM_PASSWORD_MSG);
    }

    public String getPasswordErrorMsgText() {
        waitForListElementsVisible(driverPageObject, RegisterPageUI.PASSWORD_ERROR_MSG);
        return getWebElementText(driverPageObject, RegisterPageUI.PASSWORD_ERROR_MSG);
    }

    public HomePageObject clickToLogOutLink() {
        waitForElementClickable(driverPageObject, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driverPageObject, RegisterPageUI.LOGOUT_LINK);
        return PageGenratorManager.getHomePage(driverPageObject);
    }
}
