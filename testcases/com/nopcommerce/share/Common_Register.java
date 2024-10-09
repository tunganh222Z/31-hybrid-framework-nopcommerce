package com.nopcommerce.share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.CustomerPageObject;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.RegisterPageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Common_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;

    public static String firstName, lastName, emailAddress, password;

    private String adminURL, userURL;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;

    @Parameters({"browser", "adminURL", "userURL"})
    @BeforeTest
    public void beforeClass(String browserName, String adminURL, String userURL) {
        driver = getBrowserDriver(browserName,userURL);

        firstName = "Tung";
        lastName = "Anh";
        emailAddress = getEmailRandom();
        password = "123456tung";
        this.adminURL = adminURL;
        this.userURL = userURL;

        homePage = PageGeneratorManager.getHomePage(driver);

        //Pre-condition tạo dữ liệu test cho class test khác
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");
        closeBrowser();
    }

    //AfterTest chạy sau cùng

}
