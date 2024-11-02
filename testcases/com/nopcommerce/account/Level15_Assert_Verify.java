package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.*;

public class Level15_Assert_Verify extends BaseTest {
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
        homePage = PageGeneratorManager.getHomePage(driver);
        // Mở ra URL page nào -> khởi tạo nó lên
        // Từ 1 page này chuyển qua page kia -> Khở tạo page đó lên

    }

    @Test
    public void User_01_Register_Empty_Data() {



        registerPage = homePage.clickToRegisterLink();

        log.info("User_01_Register_Empty_Data - STEP 01: Open Register page");
        homePage.clickToRegisterLink();

        // Từ homepage click registerLink > RegisterPage
        registerPage = new RegisterPageObject(driver);

        log.info("User_01_Register_Empty_Data - STEP 02: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register_Empty_Data - STEP 03: Verify first name error msg");
        verifyEqual(registerPage.getFirstNameErrorMsgText(), "First NAME is required.");
        System.out.println("123123123");

        log.info("User_01_Register_Empty_Data - STEP 04: Verify LastName error msg");
        verifyEqual(registerPage.getLastNameErrorMsgText(), "Last name is requir3ed.");

        log.info("User_01_Register_Empty_Data - STEP 05: Verify Email error msg");
        verifyEqual(registerPage.getEmailErrorMsgText(), "Email is required.");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");

    }

    @AfterClass
    public void afterClass() {
       closeBrowser();
    }

}
