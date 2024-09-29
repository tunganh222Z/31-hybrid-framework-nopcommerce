package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;
    public RegisterPageObject(WebDriver driverPageObject){
        this.driver = driverPageObject;
        PageFactory.initElements(this.driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTexBox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTexBox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement firstNameErrorMsg;

    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastNameErrorMsg;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement passwordErrorMsg;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    private WebElement confirmPasswordErrorMsg;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationCompletedMsg;

    @FindBy(xpath = "//img[@alt='Your store name']")
    private WebElement nopCommerceLogo;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logOutLink;

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getTextElement(driver, firstNameErrorMsg);
    }

    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver, lastNameErrorMsg);
        return getTextElement(driver, lastNameErrorMsg);
    }

    public String getEmailErrorMsgText() {
        waitForElementVisible(driver, emailErrorMsg);
        return getTextElement(driver, emailErrorMsg);
    }

    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getTextElement(driver, confirmPasswordErrorMsg);
    }

    public void clickToNopcommerceLogo() {
        waitForElementClickable(driver, nopCommerceLogo);
        clickToElement(driver, nopCommerceLogo);
    }

    public void enterToFirstNameTextBox(String keyTosend) {
        waitForElementVisible(driver, firstNameTexBox);
        sendKeyToElement(driver, firstNameTexBox,keyTosend);
    }

    public void enterToLastNameTextBox(String keyTosend) {
        waitForElementVisible(driver, lastNameTexBox);
        sendKeyToElement(driver, lastNameTexBox,keyTosend);
    }

    public void enterToEmailTextBox(String keyTosend) {
        waitForElementVisible(driver, emailTextBox);
        sendKeyToElement(driver, emailTextBox,keyTosend);
    }

    public void enterToPasswordTextBox(String keyTosend) {
        waitForElementVisible(driver, passwordTextBox);
        sendKeyToElement(driver, passwordTextBox,keyTosend);
    }

    public void enterToConfirmPasswordTextBox(String keyTosend) {
        waitForElementVisible(driver, confirmPasswordTextBox);
        sendKeyToElement(driver, confirmPasswordTextBox,keyTosend);
    }

    public String getPasswordErrorMsgText() {
        waitForElementVisible(driver, passwordErrorMsg);
        return getTextElement(driver, passwordErrorMsg);
    }

    public String getRegistrationCompletedMsg() {
        waitForElementVisible(driver, registrationCompletedMsg);
        return getTextElement(driver, registrationCompletedMsg);
    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver, logOutLink);
        clickToElement(driver, logOutLink);
    }
}
