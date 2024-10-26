package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.*;

public class PageGeneratorManager {

    // Thằng này có chức năng nhét driver vào các page mỗi khi switch page
    // trong test case sẽ báo PageGenratorManager.getHomePage(driver);

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static CustomerPageObject getCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }

    public static AddressPageObject getAddressPage (WebDriver driver){
        return new AddressPageObject(driver);
    }

    public static RewardPointPageObject getRewardPointPage (WebDriver driver){
        return new RewardPointPageObject(driver);
    }

    public static OrderPageObject getOrderPage (WebDriver driver){
        return new OrderPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLoginPage (WebDriver driver){
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage (WebDriver driver){
        return new AdminDashboardPageObject(driver);
    }

    public static SearchPageObject getSearchPage(WebDriver driver){
        return new SearchPageObject(driver);
    }
}
