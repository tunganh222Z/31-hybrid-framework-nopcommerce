package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;
    public HomePageObject(WebDriver driverPageObject){
        this.driver = driverPageObject;
        PageFactory.initElements(this.driver, this);
    }

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    //Kết hợp PageObject : NullPointerException
    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(driver, registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(driver,loginLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver,myAccountLink);
    }
}
