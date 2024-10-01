package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject {
    WebDriver driverPageObject;

    public CustomerPageObject(WebDriver driverPageObject) {
        super(driverPageObject);
        this.driverPageObject = driverPageObject;
    }

    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driverPageObject, CustomerPageUI.FIRSTNAME_TEXTBOX);
        return getAttributeInDOM(driverPageObject, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driverPageObject, CustomerPageUI.LASTNAME_TEXTBOX);
        return getAttributeInDOM(driverPageObject, CustomerPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driverPageObject, CustomerPageUI.EMAIL_TEXTBOX);
        return getAttributeInDOM(driverPageObject, CustomerPageUI.EMAIL_TEXTBOX, "value");
    }
}
