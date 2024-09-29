package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.user.HomePageObject;
import pageUIs.admin.AdminDashboardPageUI;
import pageUIs.admin.AdminLoginPageUI;

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
