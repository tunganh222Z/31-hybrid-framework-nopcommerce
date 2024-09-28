package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
    WebDriver driverPageObject;

    public CustomerPageObject(WebDriver driverPageObject) {
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
