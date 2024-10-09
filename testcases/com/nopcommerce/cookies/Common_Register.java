package com.nopcommerce.cookies;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.CustomerPageObject;
import pageObjects.nopcommerce.user.HomePageObject;
import pageObjects.nopcommerce.user.RegisterPageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import java.util.Set;

public class Common_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private UserLoginPageObject loginPage;

    public static String firstName, lastName, emailAddress, password;
    public static Set<Cookie> cookies;

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
        homePage = registerPage.clickToLogOutLink();
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        homePage.sleepInSecond(5);

        cookies = homePage.getBrowserCookies(driver);
        closeBrowser();
    }

    //AfterTest chạy sau cùng

}
