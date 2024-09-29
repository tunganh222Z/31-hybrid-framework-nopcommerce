package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;
    public LoginPageObject(WebDriver driverPageObject){
        this.driver = driverPageObject;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement loginButton;

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driver,emailTextBox);
        sendKeyToElement(driver, emailTextBox, keyToSend);
    }

    public void enterToPasswordTextbox(String keyToSend) {
        waitForElementVisible(driver,passwordTextBox);
        sendKeyToElement(driver, passwordTextBox, keyToSend);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }
}
