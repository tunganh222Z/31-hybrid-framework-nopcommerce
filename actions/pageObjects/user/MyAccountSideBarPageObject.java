package pageObjects.user;

import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driverPageObject){
        this.driver = driverPageObject;
    }

    public AddressPageObject openAddressPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGenratorManager.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        return PageGenratorManager.getOrderPage(driver);
    }

    public RewardPointPageObject openRewardPointPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        return PageGenratorManager.getRewardPointPage(driver);
    }

    public CustomerPageObject openCustomerPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        return PageGenratorManager.getCustomerPage(driver);
    }


}
