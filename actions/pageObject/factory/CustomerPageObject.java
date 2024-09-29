package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePageFactory {
    WebDriver driver;
    public CustomerPageObject (WebDriver driverPageObject){
        this.driver = driverPageObject;
        PageFactory.initElements(this.driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextBox;

    public String getFirstNameTextboxAttributeValue() {
        waitForElementVisible(driver,firstNameTextBox);
        return getElementAttribute(driver,firstNameTextBox, "value");
    }

    public String getLastNameTextboxAttributeValue() {
        waitForElementVisible(driver,lastNameTextBox);
        return getElementAttribute(driver,lastNameTextBox, "value");
    }

    public String getEmailAddressTextboxAttributeValue() {
        waitForElementVisible(driver,emailTextBox);
        return getElementAttribute(driver,emailTextBox, "value");
    }
}
