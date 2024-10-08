package pageObjects.nopcommerce.user;

import commons.BaseElements;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseElements {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driverPageObject){
        super(driverPageObject);
        this.driver = driverPageObject;
    }

    public AddressPageObject openAddressPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDER_LINK_TEXT);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public RewardPointPageObject openRewardPointPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINT_LINK_TEXT);
        return PageGeneratorManager.getRewardPointPage(driver);
    }

    public CustomerPageObject openCustomerPage(){
        waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public MyAccountSideBarPageObject openDynamicSideBar (String pageName){
        sleepInSecond(1);
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        switch (pageName){
            case "Customer info":
                return  PageGeneratorManager.getCustomerPage(driver);
            case "Addresses":
                return PageGeneratorManager.getAddressPage(driver);
            case "Reward points":
                return PageGeneratorManager.getRewardPointPage(driver);
            case "Orders":
                return PageGeneratorManager.getOrderPage(driver);
            default:
                return null;
        }
    }
    public void openDynamicSideBarByName (String pageName) {
        sleepInSecond(1);
        waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
    }

}
