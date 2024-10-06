package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driverPageObject;

    public HomePageObject(WebDriver driver){
        driverPageObject = driver;
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(driverPageObject, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driverPageObject, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public boolean isFirstNameTextboxDisplayed() {
        waitForElementVisible(driverPageObject, HomePageUI.FIRST_NAME_TEXTBOX);
        return isElementDisplayed(driverPageObject, HomePageUI.FIRST_NAME_TEXTBOX);
    }

    public boolean isSurNameTextboxDisplayed() {
        waitForElementVisible(driverPageObject, HomePageUI.SUR_NAME_TEXTBOX);
        return isElementDisplayed(driverPageObject, HomePageUI.SUR_NAME_TEXTBOX);

    }

    public boolean isEmailTextboxDisplayed() {
        waitForElementVisible(driverPageObject, HomePageUI.EMAIL_TEXTBOX);
        return isElementDisplayed(driverPageObject, HomePageUI.EMAIL_TEXTBOX);
    }

    public boolean isPasswordTextboxDisplayed() {
        waitForElementVisible(driverPageObject, HomePageUI.PASSWORD_TEXTBOX);
        return isElementDisplayed(driverPageObject, HomePageUI.PASSWORD_TEXTBOX);
    }

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, HomePageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driverPageObject, HomePageUI.EMAIL_TEXTBOX, keyToSend);
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        waitForElementVisible(driverPageObject, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
        return isElementDisplayed(driverPageObject, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
    }

    public void clickToCloseSignUpPopup() {
        waitForElementClickable(driverPageObject, HomePageUI.CLOSE_BUTTON);
        clickToElement(driverPageObject, HomePageUI.CLOSE_BUTTON);
    }
}
