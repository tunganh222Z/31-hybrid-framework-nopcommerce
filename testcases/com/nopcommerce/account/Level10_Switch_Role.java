package com.nopcommerce.account;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGenratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;

public class Level10_Switch_Role extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;
    private AddressPageObject addressPage;
    private RewardPointPageObject rewardPage;
    private OrderPageObject orderPage;
    private String emailAddress = getEmailRandom();
    private String adminURL, userURL;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;


    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        this.adminURL = adminURL;
        this.userURL = userURL;

        homePage = PageGenratorManager.getHomePage(driver);
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên

    }

    @Test
    public void User_01_User_To_Admin() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Tung");
        registerPage.enterToLastNameTextBox("Anh");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("123tunganh");
        registerPage.enterToConfirmPasswordTextBox("123tunganh");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");

        homePage = registerPage.clickToLogOutLink();

        loginPage = homePage.clickToLoginLink();


        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123tunganh");
        homePage = loginPage.clickToLoginButton();
        // valid data login > login success > Homepage
        customerPage = homePage.clickToMyAccountLink();
        // Homepage user -> login page admin
        homePage.openPageURL(driver, this.adminURL);

        adminLoginPage = PageGenratorManager.getAdminLoginPage(driver);

        adminLoginPage.enterToEmailTextbox(GlobalConstant.ADMIN_USERNAME);
        adminLoginPage.enterToPasswordTextbox(GlobalConstant.ADMIN_PASSWORD);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

    }

    @Test
    public void User_02_Admin_To_User() {
        homePage = adminDashboardPage.clickToLogOutLink();
        // -> homePage user -> Login Admin -> Login User
        homePage.openPageURL(driver,this.adminURL);
        PageGenratorManager.getAdminLoginPage(driver);
        adminLoginPage.openPageURL(driver,this.userURL);
        PageGenratorManager.getHomePage(driver);

    }




    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}
