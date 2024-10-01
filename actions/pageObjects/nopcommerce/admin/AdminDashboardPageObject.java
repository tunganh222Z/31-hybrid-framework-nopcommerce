package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.user.HomePageObject;
import pageUIs.nopcommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    private WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver){
        this.driver = driver;
    }

    public HomePageObject clickToLogOutLink() {
        waitForElementClickable(driver, AdminDashboardPageUI.LOG_OUT_LINK);
        clickToElement(driver, AdminDashboardPageUI.LOG_OUT_LINK);
        return new HomePageObject(driver);
    }
}
