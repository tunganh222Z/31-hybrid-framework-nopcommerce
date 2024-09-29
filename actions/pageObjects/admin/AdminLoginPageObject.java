package pageObjects.admin;

import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driverPageObject;

    public AdminLoginPageObject(WebDriver driver){
        this.driverPageObject = driver;
    }

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driverPageObject, AdminLoginPageUI.EMAIL_TEXTBOX, keyToSend);
    }

    public void enterToPasswordTextbox(String keyToSend) {
        waitForElementVisible(driverPageObject, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driverPageObject, AdminLoginPageUI.PASSWORD_TEXTBOX, keyToSend);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driverPageObject, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driverPageObject, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenratorManager.getAdminDashboardPage(driverPageObject);
    }
}
