package pageObjects.nopcommerce.user;

import commons.BaseElements;
import commons.BasePage;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.user.HomePageUI;

public class HomePageObject extends BaseElements {
    // Khai báo driverPageObject -> vẫn là null chưa khởi tạo
    WebDriver driverPageObject;

    public HomePageObject(WebDriver driverPageObject) {
        super(driverPageObject);
        // truyền tham số driverPageObject từ class khác vào
        // gán thằng this.driverPageObject = tham số driverPageObject class khác
        // như vậy thì từ class khác sẽ không phải khởi tạo thêm driver nào khác
        this.driverPageObject = driverPageObject;
    }


    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driverPageObject, HomePageUI.REGISTER_LINK);
        clickToElement(driverPageObject, HomePageUI.REGISTER_LINK);
        return PageGenratorManager.getRegisterPage(driverPageObject);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driverPageObject, HomePageUI.LOGIN_LINK);
        clickToElement(driverPageObject, HomePageUI.LOGIN_LINK);
        return PageGenratorManager.getUserLoginPage(driverPageObject);
    }

    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driverPageObject, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driverPageObject, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenratorManager.getCustomerPage(driverPageObject);
    }
}
